package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class MovingPlatformHorizontal extends StaticBody implements StepListener{

    // Create a static box shape for the platform
    private static final Shape GamingPlatFormShape = new BoxShape(3, 0.5f);
    // Store the start position of the platform
    private Vec2 startPosition;
    // Store the left and right limits of the platform's movement
    private float left, right;
    // Store the speed and direction of the platform's movement
    private float delta;


    public MovingPlatformHorizontal(World world, Vec2 startPosition, float distance, BodyImage image) {
        // Call the superclass constructor with the world and shape parameters
        super(world, GamingPlatFormShape);
        // Add an image to the platform
        this.addImage(image);
        // Set the initial position and calculate the left and right positions
        this.startPosition = startPosition;
        left = startPosition.x;
        this.right = startPosition.x+distance;
        // Set the speed and direction of the platform's movement
        delta=0.09f;
        // Add this object as a step listener to the world
        world.addStepListener(this);
    }


    @Override
    public void preStep(StepEvent stepEvent) {
        // If the platform is at the left limit of movement, reset its position and change its direction
        if (getPosition().x < left){
            this.setPosition(startPosition);
            delta*=-1;
        }
        // If the platform is at the right limit of movement, change its direction
        if (getPosition().x > right){
            delta*=-1;
        }
        // Move the platform by delta in the x-direction
        this.setPosition(new Vec2(this.getPosition().x+delta, this.getPosition().y));
    }

    // Override the postStep method from the StepListener interface
    @Override
    public void postStep(StepEvent stepEvent) {

    }

}
