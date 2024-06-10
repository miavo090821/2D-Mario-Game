package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


// Define Level5 class as a subclass of GameLevel
public class Level5 extends GameLevel{

    // Create a player object
    public Player player;


    public Level5(Game game){
        // Call the superclass constructor with the game parameter
        super(game);

        // Get the player object from the superclass method getPlayer() and set its initial position and gravity scale
        player = getPlayer();
        player.setPosition(new Vec2(-10,-10));
        player.setGravityScale(5);

        // Create the ground object using a BoxShape
        Shape shape = new BoxShape(30, 0f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13.8f));

        // Create several static platforms with different shapes and positions
        Shape shape2 = new BoxShape(0, 1.6f);
        StaticBody platform = new StaticBody(this, shape2);
        platform.setPosition(new Vec2(-12.3f, -12.1f));

        Shape shape3 = new BoxShape(1.5f, 0f);
        StaticBody platform2 = new StaticBody(this, shape3);
        platform2.setPosition(new Vec2(-13.8f, -10.5f));

        Shape shape4 = new BoxShape(0, 1.6f);
        StaticBody platform3 = new StaticBody(this, shape4);
        platform3.setPosition(new Vec2(-15.9f, -9f));

        Shape shape5 = new BoxShape(2f, 0f);
        StaticBody platform4 = new StaticBody(this, shape5);
        platform4.setPosition(new Vec2(-18f, -7f));

        Shape shape7 = new BoxShape(1f, 0f);
        StaticBody platform6 = new StaticBody(this, shape7);
        platform6.setPosition(new Vec2(13f, -12f));


        // Create a flag object and set its position
        Flag flag = new Flag(this);
        flag.setPosition(new Vec2(12.5f, -4f));


        // Set the number of mushrooms to zero
        Mushroom.setMushrooms(0);
    }

    // Override the isComplete method to check if the player has touched the flag
    @Override
    public boolean isComplete() {
        return player.getFlagCount() == 1;
    }
}
