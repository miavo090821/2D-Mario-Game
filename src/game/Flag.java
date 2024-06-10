package game;

import city.cs.engine.*;

/**
 * Winning flag
 */

//Declare the Flag class, which extends the DynamicBody class.
public class Flag extends StaticBody{

    //Declare a static final variable flag which is a BoxShape object
    private static final Shape flag = new BoxShape(0, 10f);


    //Constructor for the Flag class that takes a World object as an argument
    public Flag(World world){
        super(world, flag);//Calls the superclass constructor with the World and the flag object as arguments
    }

    // Define a private static variable to hold the number of flags collected
    private int flagCount;

    // Define a static method to set the number of flags collected and print a message
    public static void setFlag(int flagCount){
        // Set the flag count to the given value
        Player.flagCount = flagCount;
        //Print a message to the console indicating how many flags have been collided with
        System.out.println("Flag Collided = " + flagCount);
    }

    // Define a public method to get the number of flags collided
    public int getFlagCount(){
        return flagCount;
    }


}