package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

// Define the Level1 class as a subclass of GameLevel
public class Level1 extends GameLevel{

    // declare an instance variable for the player object
    public Player player;

    // declare an instance variable for the starting position of the first platform
    private Vec2 startPosition = new Vec2(-11f,-11);

    // declare a constant for the image used for the platforms
    private static final BodyImage image = new BodyImage("data/platform.png",1f);

    // Constructor method for Level1, taking in a Game object as a parameter
    public Level1(Game game){
        // call the superclass constructor and pass in the game object
        super(game);

        // get the player object and set its initial position
        player = getPlayer();
        player.setPosition(new Vec2(9.5f,-8));

        // create the ground body using a box shape and set its position
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13.8f));


        // create a moving platform and set its position
        GamingPlatform platform1 = new GamingPlatform(this, startPosition,7, image);
        platform1.setPosition(new Vec2(-11f,-11));

        // create two static platforms and set their positions
        Platform platform2 = new Platform(this);
        platform2.setPosition(new Vec2(-0.5f, -0.5f));

        Platform platform3 = new Platform(this);
        platform3.setPosition(new Vec2(11, 4f));




        // create three coins and set their positions
        Pound pound1 = new Pound(this);
        pound1.setPosition(new Vec2(-11,-3));
        pound1.setGravityScale(13);

        Pound pound2 = new Pound(this);
        pound2.setPosition(new Vec2(-0.5f,2));

        Pound pound3 = new Pound(this);
        pound3.setPosition(new Vec2(11,6));


        // set the initial number of mushrooms to 0
        Mushroom.setMushrooms(0);
    }

    // override the isComplete method to check if the player has collected all the coins
    @Override
    public boolean isComplete() {
        return player.getPounds() == 3;
    }
}
