package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//Declare the Mushroom class, which extends the DynamicBody class.
public class Mushroom extends DynamicBody{

    //Declare a static final variable MushroomShape which is a CircleShape object
    private static final Shape MushroomShape = new CircleShape(0.65f);

    //Declare a static final variable representing the image of the mushroom
    private static final BodyImage image = new BodyImage("data/mushroom.png", 1.25f);

    // SoundClip object for the sound effect played when a collided with mushroom
    static SoundClip mushroomSound;

    // static initializer block to create and load the mushroomSound object
    static{
        try {
            mushroomSound = new SoundClip("data/sounds/mushroom-sound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }


    //Constructor for the Mushroom class that takes a World object as an argument
    public Mushroom(World world){
        super(world, MushroomShape); //Calls the superclass constructor with the World and the MushroomShape object
        this.addImage(image);//Adds the image to the mushroom
    }

    // Define a private static variable to hold the number of mushroom collected
    private int mushroomCount;

    // Define a static method to set the number of mushroom collected and print a message
    public static void setMushrooms(int mushroomCount){
        // Set the mushroom count to the given value
        Player.mushroomCount = mushroomCount;
        //Print a message to the console indicating how many mushroom have been collected
        System.out.println("Mushrooms Collected = " + mushroomCount);
    }

    // Define a public method to get the number of mushroom collected
    public int getMushrooms(){
        return mushroomCount;
    }
}
