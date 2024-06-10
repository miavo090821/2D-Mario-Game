package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

// Define the Level1 class as a subclass of GameLevel
public class Level2 extends GameLevel{

    // Declare private Player object and static final BodyImage object for the platform image
    private Player player;
    private static final BodyImage image = new BodyImage("data/platform.png",1f);

    // Set the starting position of the moving platform
    private Vec2 startPosition = new Vec2(-4.5f,-4);

    // Constructor method for Level2, taking in a Game object as a parameter
    public Level2(Game game){
        // Call the GameLevel constructor
        super(game);

        // Initialize the player object and set its starting position
        player = getPlayer();
        player.setPosition(new Vec2(9.5f,-8));

        // create the ground body using a box shape and set its position
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13.8f));


        // Create a new Platform object and set its position
        Platform platform1 = new Platform(this);
        platform1.setPosition(new Vec2(-12, -8.5f));

        // Create a new GamingPlatform object and set its position, start position, movement range and image
        GamingPlatform platform2 = new GamingPlatform(this,startPosition,6, image);
        platform2.setPosition(new Vec2(-4.5f,-4));

        // Create a new Platform object and set its position
        Platform platform3 = new Platform(this);
        platform3.setPosition(new Vec2(4f, 0.5f));



        // Create 3 new Pound objects and set their position (and gravity scale for the second pound)
        Pound pound1 = new Pound(this);
        pound1.setPosition(new Vec2(-12,-3));

        Pound pound2 = new Pound(this);
        pound2.setPosition(new Vec2(-4.5f,2));
        pound2.setGravityScale(13);

        Pound pound3 = new Pound(this);
        pound3.setPosition(new Vec2(4,2));





        // Create a new Pipe object and set its position
        Pipe pipe = new Pipe(this);
        pipe.setPosition(new Vec2(15,-11.5f));

        // Create a new PipeTop object and set its position
        PipeTop pipeTop = new PipeTop(this);
        pipeTop.setPosition(new Vec2(15,-10f));




        // Create two new Enemy objects and set their positions
        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(2, -13));

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-2, -13));



        // Create a new Block object and set its position
        Block block = new Block(this);
        block.setPosition(new Vec2(9.5f, -3.8f));

        // Set the mushroom count to 0
        Mushroom.setMushrooms(0);
    }

    // Override the isComplete method to define the level's completion conditions
    @Override
    public boolean isComplete() {
        return player.getPounds() == 6 && player.getPipeTopCount() == 1;
    }
}
