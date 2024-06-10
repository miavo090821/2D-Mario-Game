package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GamingPlatform extends StaticBody implements StepListener {

    // Declare constants for the shape and initial position of the moving platform
    private static final Shape GamingPlatFormShape = new BoxShape(4, 0.5f);
    private Vec2 startPosition;

    // Declare variables to keep track of the top and bottom positions of the moving platform,
    // the distance it should travel, and the speed at which it should move
    private float top, bottom;
    private float delta;

    // Constructor for GamingPlatform class that takes a World object, a Vec2 startPosition, a float distance,
    // and a BodyImage object as parameters
    public GamingPlatform(World world, Vec2 startPosition, float distance, BodyImage image) {
        // Call the superclass constructor with the world and shape parameters
        super(world, GamingPlatFormShape);
        this.addImage(image); // Add the specified image to the moving platform
        // Set the initial position and calculate the top and bottom positions
        this.startPosition = startPosition;
        bottom = startPosition.y;
        this.top = startPosition.y+distance;
        // Set the initial movement speed of the platform
        delta=0.15f;
        // Add the GamingPlatform object as a step listener to the world
        world.addStepListener(this);
    }

    // Override the preStep method from the StepListener interface
    @Override
    public void preStep(StepEvent stepEvent) {
        // Check if the platform has reached the bottom, and if so, reset its position and reverse its direction
        if (getPosition().y < bottom){
            this.setPosition(startPosition);
            delta*=-1;
        }
        // Check if the platform has reached the top, and if so, reverse its direction
        if (getPosition().y > top){
            delta*=-1;
        }
        // Move the platform by the specified speed in the y direction
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));
    }

    // Override the postStep method from the StepListener interface
    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
