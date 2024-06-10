package game;

import city.cs.engine.*;

// Define the Lava class which extends StaticBody
public class Lava extends StaticBody {

    //Define a private static variable Lava which is a BoxShape with dimensions of 0.75f x 0.75f
    private static final Shape Lava = new BoxShape(30, 0f);


    //A public constructor for the Lava class that takes in a World object as a parameter.
    public Lava(World world) {
        super(world, Lava);//Calls the superclass constructor with the World and the Lava object as arguments
    }

    //Define a private static variable to hold the number of lava collisions
    public static int lavaCount;

    // Define a static method to set the number of lava collisions and print a message
    public static void setLava(int lavaCount){
        // Set the lava count to the given value
        Player.lavaCount = lavaCount;
        //Print a message to the console indicating lava collisions
        System.out.println("Lava Collided = " + lavaCount);
    }

    // Define a public method to get the number of lava collisions
    public static int getLavaCount(){
        return lavaCount;
    }
}