package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FireballCollect implements CollisionListener {

    // fields for the player, level, and game
    private Player player;
    private GameLevel level;
    private Game g;

    // constructor for the class
    public FireballCollect(Player p, GameLevel level, Game game){
        this.player = p;
        this.level = level;
        this.g=game;
    }

    // method that gets called when a collision occurs
    @Override
    public void collide(CollisionEvent e) {
        // if the other body involved in the collision is a Fireball object
        if (e.getOtherBody() instanceof Fireball) {
            // Increase the fireball count and destroy the fireball object
            Fireball.setFireballs(1);
            e.getOtherBody().destroy();
        }
    }
}
