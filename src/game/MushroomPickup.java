package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//Declare the MushroomPickup class, which implements the CollisionListener interface.
public class MushroomPickup implements CollisionListener {

    //Declares an instance variable player of type Player
    private Player player;

    /*Constructor for the class that takes a Player object as an argument
    and sets the instance variable player to the value of the argument*/
    public MushroomPickup(Player p){
        this.player = p;
    }

    /*Collide method - if the other body involved in the collision is an instance of the Mushroom class,
    the static setMushrooms method of the Mushroom class is called with the argument player.getMushrooms()+1,
    which increments the mushroom count by 1. Then the Mushroom gets removed and the playerEnlarge method from
    the player class is called which increases the size of the player. The mushroomSound is also played.*/
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Mushroom) {
            Mushroom.setMushrooms(player.getMushroomCount() + 1);
            e.getOtherBody().destroy();
            player.playerEnlarge();
            Mushroom.mushroomSound.play();
        }
    }
}