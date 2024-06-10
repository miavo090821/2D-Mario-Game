package game;

import city.cs.engine.*;

// Define a new class called "Pipe" which extends the "StaticBody" class
public class Pipe extends StaticBody{


    // Define three PolygonShape objects to represent the left, bottom, and right sides of the pipe
    PolygonShape left = new PolygonShape( -1.9f,1.92f, -1.91f,-1.86f, -1.78f,-1.85f, -1.79f,1.93f);
    PolygonShape bottom = new PolygonShape(-1.84f,-1.86f, 1.78f,-1.88f, 1.79f,-1.68f, -1.85f,-1.67f);
    PolygonShape right = new PolygonShape(1.88f,1.9f, 1.9f,-1.88f, 1.75f,-1.88f, 1.74f,1.9f);

    //Declare a static final variable representing the image of the pipe
    private static final BodyImage image = new BodyImage("data/pipe.png",6);


    // Define a constructor method for the "Pipe" class that takes a World object as an argument
    public Pipe(World world){
        // Call the super constructor of the "StaticBody" class with the "world" parameter
        super(world);
        // Create three solid fixtures for the pipe using the defined PolygonShape objects
        SolidFixture l = new SolidFixture(this, left);
        SolidFixture b = new SolidFixture(this, bottom);
        SolidFixture r = new SolidFixture(this, right);
        // Add the image of the pipe to the object
        this.addImage(image);
    }
}
