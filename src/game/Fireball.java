package game;

import city.cs.engine.*;

/**
 * fireball to attack the enemy
 */

// Define the Fireball class which extends StaticBody
public class Fireball extends StaticBody {

    //Define a private static variable BoxShape which is a BoxShape with dimensions of 0.75f x 0.75f
    private static final Shape BoxShape = new BoxShape(0.75f, 0.75f);

    //Define a private static variable image which is a BodyImage
    private static final BodyImage image = new BodyImage("data/fireball.png", 2.2f);

    //A public constructor for the Fireball class that takes in a World object as a parameter.
    public Fireball(World world) {
        super(world, BoxShape);//Calls the superclass constructor with the World and the BoxShape object as arguments
        this.addImage(image);//Adds the image to the fireball
    }

    private int fireballCount;

    // Define a static method to set the number of fireball collected and print a message
    public static void setFireballs(int fireballCount){
        // Set the fireball count to the given value
        Player.fireballCount = fireballCount;
        //Print a message to the console indicating how many fireballs have been collected
        System.out.println("Fireball Collected = " + fireballCount);
    }

    // Define a public method to get the number of fireballs collected
    public int getPounds(){
        return fireballCount;
    }
}