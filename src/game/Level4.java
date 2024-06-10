package game;

import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


// Define Level4 class as a subclass of GameLevel
public class Level4 extends GameLevel{

    public Player player;
    // Set the image of the platform
    private static final BodyImage image = new BodyImage("data/platform3.png",1f);

    // Set the starting positions for the moving platforms
    private Vec2 startPosition1 = new Vec2(-11.5f,-4);
    private Vec2 startPosition2 = new Vec2(4.5f,-4);

    public Level4(Game game){
        super(game);

        // Get the player instance from the parent GameLevel class and set its position
        player = getPlayer();
        player.setPosition(new Vec2(-18,2));


        // Add a Lava object to the level
        Lava lava = new Lava(this);
        lava.setPosition(new Vec2(0f, -11f));


        // Add two platform to the level
        Shape shape2 = new BoxShape(2, 0f);
        StaticBody platform = new StaticBody(this, shape2);
        platform.setPosition(new Vec2(-18f, -4.8f));

        Shape shape3 = new BoxShape(2, 0f);
        StaticBody platform3 = new StaticBody(this, shape3);
        platform3.setPosition(new Vec2(18f, -2.8f));


        // Add two moving platform to the level
        MovingPlatformHorizontal horizontalPlatform1 = new MovingPlatformHorizontal(this,startPosition1,7, image);
        horizontalPlatform1.setPosition(new Vec2(-11.5f,-4));

        MovingPlatformHorizontal horizontalPlatform3 = new MovingPlatformHorizontal(this,startPosition2,7, image);
        horizontalPlatform3.setPosition(new Vec2(4.5f,-4));



        // Add coin to the level
        Pound pound1 = new Pound(this);
        pound1.setPosition(new Vec2(18.3f,-1.5f));

        //set mushroom to 0
        Mushroom.setMushrooms(0);
    }

    // override the isComplete method to check if the player has collected all the coins
    @Override
    public boolean isComplete() {
        return player.getPounds() == 12;
    }

}
