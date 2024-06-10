package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

// Defining the "Player" class, which extends the "Walker" class from the game engine.
public class Player extends Walker {



    // Declaring two public SolidFixture variables named "shape1" and "shape2".
    public SolidFixture shape1;
    public SolidFixture shape2;

    // Declaring two static final BoxShape variables named "PlayerShape" and "PlayerShape2".
    private static final BoxShape PlayerShape = new BoxShape(0.8f,0.9f);
    private static final BoxShape PlayerShape2 = new BoxShape(1.2f,1.5f);

    // Declaring two static final BodyImage variables named "image" and "image2".
    private static final BodyImage image = new BodyImage("data/player.png", 2.5f);
    private static final BodyImage image2 = new BodyImage("data/player.png", 4f);

    private static final BodyImage fireballLeft = new BodyImage("data/fireball-flipped.png", 2f);
    private static final BodyImage fireballRight = new BodyImage("data/fireball.png", 2f);

    boolean facingLeft;


    // SoundClip object for the sound effect played when a fireball is shot
    static SoundClip fireballSound;

    // static initializer block to create and load the fireball sound object
    static{
        try {
            fireballSound = new SoundClip("data/sounds/fireball.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // Defining a constructor for the "Player" class that takes a "World" object as an argument.
    public Player(World world){
        super(world);
        this.addImage(image);
        shape1 = new SolidFixture(this,PlayerShape);
        facingLeft = true;
    }

    // Defining a method named "playerEnlarge()" that destroys "shape1", adds "image2" to the player, and creates a new "SolidFixture" named "shape2".
    public void playerEnlarge(){
        shape1.destroy();
        this.removeAllImages();
        this.addImage(image2);
        shape2 = new SolidFixture(this, PlayerShape2);
    }

    // Overriding the startWalking() method from the superclass to update the facingLeft
    // boolean based on the direction of movement.
    @Override
    public void startWalking(float speed){
        super.startWalking(speed);

        if (speed<0){
            facingLeft = true;
        }
        else if (speed>0){
            facingLeft = false;
        }
    }

    // Defining a method named "shoot()" to create and shoot a fireball in the direction the player is facing.
    public void shoot(){
        // Creating a new DynamicBody object to represent the fireball.
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));

        // Creating a new ProjectileImpact object to handle collisions between the fireball and other objects in the game.
        ProjectileImpact impact = new ProjectileImpact();
        projectile.addCollisionListener(impact);

        // Adding the appropriate image to the fireball based on the direction the player is facing,
        // and setting its position and velocity accordingly.
        if(facingLeft){
            projectile.addImage(fireballLeft);
            projectile.setPosition((new Vec2(this.getPosition().x - 2, this.getPosition().y)));
            projectile.setLinearVelocity(new Vec2(-20,0));
        }
        else {
            projectile.addImage(fireballRight);
            projectile.setPosition((new Vec2(this.getPosition().x + 2, this.getPosition().y)));
            projectile.setLinearVelocity(new Vec2( 20,0));
        }
    }


    // Declaring three public static integer variables.
    public static int poundCount;
    public static int damageCount;
    public static int mushroomCount;
    public static int pipeTopCount;

    public static int fireballCount;

    public static int flagCount;

    public static int lavaCount;

    // Defining three methods that return the values of the static integer variables.
    public int getPounds() {
        return poundCount;
    }
    public int getDamageCount() {
        return damageCount;
    }
    public int getMushroomCount() {
        return mushroomCount;
    }

    public int getPipeTopCount() {
        return pipeTopCount;
    }

    public int getFireballCount() {
        return fireballCount;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public int getLavaCount() {
        return lavaCount;
    }
    
}

