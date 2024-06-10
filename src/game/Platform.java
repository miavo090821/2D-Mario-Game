package game;

import city.cs.engine.*;

//Declare the Mushroom class, which extends the DynamicBody class.
public class Platform extends StaticBody{

    //Declare a static final variable PlatformShape which is a BoxShape object
    private static final Shape PlatformShape = new BoxShape(3, 0.5f);

    //Declare a static final variable representing the image of the platform
    private static final BodyImage image = new BodyImage("data/platform.png",1f);

    //Constructor for the Platform class that takes a World object as an argument
    public Platform(World world){
        super(world, PlatformShape);//Calls the superclass constructor with the World and the PlatformShape object
        this.addImage(image);//Adds the image to the platform
    }
}
