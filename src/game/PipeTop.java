package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//Declare the PipeTop class, which extends the StaticBody class.
public class PipeTop extends StaticBody{

    //Declare a static final variable PipeShape which is a BoxShape object
    private static final Shape PipeShape = new BoxShape(1f, 0f);

    // SoundClip object for the sound effect played when a collided with the top part of the pipe
    static SoundClip pipeSound;

    // static initializer block to create and load the pipe sound object
    static{
        try {
            pipeSound = new SoundClip("data/sounds/pipe.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    //Constructor for the Platform class that takes a World object as an argument
    public PipeTop(World world){
        super(world, PipeShape);
    }

    // Define a private static variable to hold the number of contacts with the pipe
    private int pipeTopCount;

    // Define a static method to set the number of pipe contacts
    public static void setPipeTopCount(int pipeTopCount){
        // Set the pipe count to the given value
        Player.pipeTopCount = pipeTopCount;
        //Print a message to the console indicating number of pipe contacts
        System.out.println("PipeTop Collected = " + pipeTopCount);
    }

    // Define a public method to get the number of pipe contacts
    public int getPipeTop(){
        return pipeTopCount;
    }
}

