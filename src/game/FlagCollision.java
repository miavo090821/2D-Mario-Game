package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class FlagCollision implements CollisionListener {

    // Load winSound audio file and assign to static variable
    static SoundClip winSound;
    static{
        try {
            winSound = new SoundClip("data/sounds/win.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // Fields to hold the player and game level and game instances
    private Player player;
    private GameLevel level;
    private Game g;


    // Constructor to initialize the player and game level and game fields
    public FlagCollision(Player p, GameLevel level, Game game){
        this.player = p;
        this.level = level;
        this.g=game;
    }


    @Override
    public void collide(CollisionEvent e) {
        // Check if the other body in the collision is an instance of Flag
        if (e.getOtherBody() instanceof Flag) {
            // Set the flag to indicate that the player has touched the flag
            Flag.setFlag(1);
            // Stop the game sound and play the win sound
            Game.gameSound.stop();
            winSound.play();
            // If the level is complete, move to the next level
            if (level.isComplete()){
                g.goToNextLevel();
            }
        }
    }
}