package game;

import city.cs.engine.*;

// Define the Block class which extends StaticBody (a static object in the physics world)
public class Block extends StaticBody {

    //Define a private static variable BoxShape which is a BoxShape with dimensions of 0.75f x 0.75f
    private static final Shape BoxShape = new BoxShape(0.75f, 0.75f);

    //Define a private static variable image which is a BodyImage
    private static final BodyImage image = new BodyImage("data/question.png", 1.5f);

    //A public constructor for the Block class that takes in a World object as a parameter.
    public Block(World world) {
        super(world, BoxShape);//Calls the superclass constructor with the World and the CoinShape object as arguments
        this.addImage(image);//Adds the image to the block
    }
}