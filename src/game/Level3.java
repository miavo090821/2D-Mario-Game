package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


// Define Level3 as a subclass of GameLevel
public class Level3 extends GameLevel{

    // Declare a Player object
    public Player player;

    // Set the starting position of the moving platform
    private Vec2 startPosition = new Vec2(-15f,-9);

    // Declare a BodyImage object to store the image for the ground platform
    private static final BodyImage image = new BodyImage("data/platform2.png",1f);

    // Constructor method for Level3, taking in a Game object as a parameter
    public Level3(Game game){
        super(game);

        // Get the Player object from the parent class and set the starting position of the player
        player = getPlayer();
        player.setPosition(new Vec2(13.5f,-8));

        // Create two static bodies to act as the ground and ceiling
        Shape shape = new BoxShape(30, 0f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11f));

        Shape shape2 = new BoxShape(30, 0f);
        StaticBody ceiling = new StaticBody(this, shape2);
        ceiling.setPosition(new Vec2(0f, 9f));


        //create a Fireball object and set its position
        Fireball fireball = new Fireball(this);
        fireball.setPosition(new Vec2(17,-10.2f));

        // Create a GamingPlatform object and set its starting position
        GamingPlatform movingPlatform = new GamingPlatform(this,startPosition, 7.5f, image);
        movingPlatform.setPosition(new Vec2(-15f,-9));


        // Create multiple PlatformSquare objects and set their positions
        PlatformSquare platform3 = new PlatformSquare(this);
        platform3.setPosition(new Vec2(-10f,-2.5f));

        PlatformSquare platform4 = new PlatformSquare(this);
        platform4.setPosition(new Vec2(-7.8f,-2.5f));

        PlatformSquare platform5 = new PlatformSquare(this);
        platform5.setPosition(new Vec2(-5.6f,-2.5f));

        PlatformSquare platform6 = new PlatformSquare(this);
        platform6.setPosition(new Vec2(-3.4f,-2.5f));

        PlatformSquare platform7 = new PlatformSquare(this);
        platform7.setPosition(new Vec2(-3.4f,0f));

        PlatformSquare platform8 = new PlatformSquare(this);
        platform8.setPosition(new Vec2(-3.4f,2.5f));

        PlatformSquare platform9 = new PlatformSquare(this);
        platform9.setPosition(new Vec2(-1.2f,2.5f));

        PlatformSquare platform10 = new PlatformSquare(this);
        platform10.setPosition(new Vec2(1f,2.5f));

        PlatformSquare platform11 = new PlatformSquare(this);
        platform11.setPosition(new Vec2(3.2f,2.5f));

        PlatformSquare platform12 = new PlatformSquare(this);
        platform12.setPosition(new Vec2(3.2f,0f));

        PlatformSquare platform13 = new PlatformSquare(this);
        platform13.setPosition(new Vec2(3.2f,-2.5f));

        PlatformSquare platform14 = new PlatformSquare(this);
        platform14.setPosition(new Vec2(5.4f,-2.5f));

        PlatformSquare platform15 = new PlatformSquare(this);
        platform15.setPosition(new Vec2(7.6f,-2.5f));

        PlatformSquare platform16 = new PlatformSquare(this);
        platform16.setPosition(new Vec2(9.8f,-2.5f));

        PlatformSquare platform17 = new PlatformSquare(this);
        platform17.setPosition(new Vec2(9.8f,0f));

        PlatformSquare platform18 = new PlatformSquare(this);
        platform18.setPosition(new Vec2(9.8f,2.5f));

        PlatformSquare platform19 = new PlatformSquare(this);
        platform19.setPosition(new Vec2(12f,2.5f));

        PlatformSquare platform20 = new PlatformSquare(this);
        platform20.setPosition(new Vec2(14.2f,2.5f));




        //Create 5 coins and set their positions
        Pound pound1 = new Pound(this);
        pound1.setPosition(new Vec2(-6.7f,0));

        Pound pound2 = new Pound(this);
        pound2.setPosition(new Vec2(-2.3f,5));

        Pound pound3 = new Pound(this);
        pound3.setPosition(new Vec2(2.1f,5));

        Pound pound4 = new Pound(this);
        pound4.setPosition(new Vec2(6.5f,0));

        Pound pound5 = new Pound(this);
        pound5.setPosition(new Vec2(12f,5));




        //Create two enemies and set their positions
        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(2, -9));

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-2, -9));


        //set mushroom count to 0
        Mushroom.setMushrooms(0);
    }

    // override the isComplete method to check if the player has collected all the coins
    @Override
    public boolean isComplete() {
        return player.getPounds() == 11;
    }
}
