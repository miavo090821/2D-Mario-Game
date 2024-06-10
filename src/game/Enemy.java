package game;

import city.cs.engine.*;
import game.Player;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Enemy management
 */
// Define a class named "Enemy" that extends the "Walker" class and implements "StepListener" interface
public class Enemy extends Walker implements StepListener{

    // Define a static constant shape for the enemy
    private static final Shape enemyShape = new PolygonShape(
            0.848f,-0.732f, -0.267f,-0.719f, -0.274f,0.222f, 0.04f,0.549f, 0.774f,0.85f, 0.948f,0.736f, 0.994f,0.309f, 0.954f,-0.245f
    );

    // Define a static constant image for the enemy
    private static final BodyImage enemyImage = new BodyImage("data/enemy.png", 2.5f);

    // Define a private instance variable to hold the speed of the enemy
    private final int SPEED = 15;

    // Define private instance variables to hold the left and right bounds of the enemy's range
    private float left, right;

    // Define a private instance variable to hold the range of the enemy's movement
    private final int range = 3;

    // SoundClip object for the sound effect played when a collided with turtle (enemy)
    static SoundClip turtleSound;

    // static initializer block to create and load the turtleSound object
    static{
        try {
            turtleSound = new SoundClip("data/sounds/turtleSound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // Define a constructor for the Enemy class that takes a "World" object as an argument
    public Enemy(World world) {
        // Call the superclass constructor with the "World" object and enemy shape as arguments
        super(world, enemyShape);
        // Add the enemy image to the enemy body
        addImage(enemyImage);
        // Add this Enemy instance as a step listener to the world
        world.addStepListener(this);
        // Start the enemy walking at its designated speed
        startWalking(SPEED);
    }

    // Override the setPosition() method to update the left and right bounds of the enemy's range
    @Override
    public void setPosition(Vec2 position) {
        // Call the superclass's setPosition() method with the given position
        super.setPosition(position);
        // Update the left and right bounds of the enemy's range based on its position
        left = position.x-range;
        right = position.x+range;
    }

    // Override the preStep() method from the StepListener interface
    @Override
    public void preStep(StepEvent stepEvent) {
        // If the enemy has reached the right bound of its range, start walking in the opposite direction
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        // If the enemy has reached the left bound of its range, start walking in the opposite direction
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }

    // Override the postStep() method from the StepListener interface
    @Override
    public void postStep(StepEvent stepEvent) {

    }

    // Define a private static variable to hold the number of damages made to the player
    private int damageCount;

    // Define a static method to set the number of damages and print a message
    public static void setDamageCount(int damageCount){
        // Set the enemy count to the given value
        Player.damageCount = damageCount;
        // Print a message to the console to indicate the number of damages
        System.out.println("Damage = " + damageCount);
    }

    // Define a public method to get the number of damages
    public int getDamageCount(){
        return damageCount;
    }

}
