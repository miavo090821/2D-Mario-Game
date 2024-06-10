package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class BlockDestroy implements CollisionListener {

    // reference to a Player object
    private Player player;

    // reference to a GameLevel object
    private GameLevel gameLevel;

    // constructor for the BlockDestroy class that takes a Player object and a GameLevel object
    public BlockDestroy(Player p, GameLevel gameLevel){
        this.player = p;
        this.gameLevel = gameLevel;
    }

    // implementation of the collide method from the CollisionListener interface
    @Override
    public void collide(CollisionEvent e) {
        // check if the other body involved in the collision is an instance of the Block class
        if (e.getOtherBody() instanceof Block) {
            // destroy the block using the destroy method
            e.getOtherBody().destroy();
            // create a new Mushroom object
            Mushroom mushroom = new Mushroom(gameLevel);
            // set the position of the mushroom using the setPosition() method
            mushroom.setPosition(new Vec2(9.5f,-2.3f));
            // set the gravity scale of the mushroom
            mushroom.setGravityScale(3f);
        }
    }
}
