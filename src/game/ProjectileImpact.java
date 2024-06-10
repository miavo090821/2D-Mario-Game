package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProjectileImpact implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {
        // Destroy the projectile when it collides with other bodies
        collisionEvent.getReportingBody().destroy();
        // Check if the other body involved in the collision is an instance of the Enemy class.
        if(collisionEvent.getOtherBody() instanceof Enemy){
            // If it is, destroy the Enemy body as well.
            collisionEvent.getOtherBody().destroy();
        }

    }
}
