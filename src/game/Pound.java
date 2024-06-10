package game;

import city.cs.engine.*;

/**
 * pounds set up
 */

//Declare the Pound class, which extends the DynamicBody class.
public class Pound extends DynamicBody{

    //Declare a static final variable PoundShape which is a CircleShape object
    private static final Shape PoundShape = new CircleShape(1);

    //Declare a static final variable representing the image of the pound
    private static final BodyImage image = new BodyImage("data/pound.gif", 2f);

    //Constructor for the Pound class that takes a World object as an argument
    public Pound(World world){
        super(world, PoundShape);//Calls the superclass constructor with the World and the PoundShape object as arguments
        this.addImage(image);//Adds the image to the pound
    }

    // Define a private static variable to hold the number of pounds collected
    private int poundCount;

    // Define a static method to set the number of pounds collected and print a message
    public static void setPounds(int poundCount){
        // Set the pound count to the given value
        Player.poundCount = poundCount;
        //Print a message to the console indicating how many pounds have been collected
        System.out.println("Pounds Collected = " + poundCount);
    }

    // Define a public method to get the number of pounds collected
    public int getPounds(){
        return poundCount;
    }
}
