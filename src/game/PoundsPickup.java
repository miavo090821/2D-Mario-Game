package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PoundsPickup implements CollisionListener {

    // reference to a Player object
    private Player player;

    // reference to a GameLevel object
    private GameLevel level;

    // reference to a Game object
    private Game g;

    // SoundClip object for the sound effect played when a pound is collected
    static SoundClip coinSound;

    // static initializer block to create and load the coinSound object
    static{
        try {
            coinSound = new SoundClip("data/sounds/coin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // constructor for the CoinsPickup class that takes a Player object, a GameLevel object, and a Game object
    public PoundsPickup(Player p, GameLevel level, Game game){
        this.player = p;
        this.level = level;
        this.g=game;
    }

    // implementation of the collide method from the CollisionListener interface
    @Override
    public void collide(CollisionEvent e) {
        // check if the other body involved in the collision is an instance of the Pound class
        if (e.getOtherBody() instanceof Pound) {
            // increment the number of coins collected by the player
            Pound.setPounds(player.getPounds()+1);
            // destroy the pound object
            e.getOtherBody().destroy();
            // play the pound sound effect
            coinSound.play();
            // check if the current level is complete, and if so, move to the next level
            if (level.isComplete()){
                g.goToNextLevel();
            }
        }
    }
}
