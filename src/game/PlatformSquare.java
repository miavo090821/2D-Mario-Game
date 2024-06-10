package game;

import city.cs.engine.*;

//Declare the PlatformSquare class, which extends the StaticBody class.
public class PlatformSquare extends StaticBody{

    //Declare a static final variable PlatformShape which is a BoxShape object
    private static final Shape PlatformShape = new BoxShape(1.1f, 1.2f);

    //Declare a static final variable representing the image of the platform
    private static final BodyImage image = new BodyImage("data/platform-square.png",2.5f);

    //Constructor for the PlatformSquare class that takes a World object as an argument
    public PlatformSquare(World world){
        super(world, PlatformShape);//Calls the superclass constructor with the World and the PlatformShape object
        this.addImage(image);//Adds the image to the platform
    }
}
