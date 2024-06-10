package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class LavaCollision implements CollisionListener {

    // instance variables
    private Player player;
    private GameLevel level;
    private Game g;

    // static variable for the game over sound clip
    static SoundClip gameOverSound;

    // static initializer to load the game over sound clip
    static{
        try {
            gameOverSound = new SoundClip("data/sounds/gameOver.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // constructor
    public LavaCollision(Player p, GameLevel level, Game game){
        this.player = p;
        this.level = level;
        this.g=game;
    }


    @Override
    public void collide(CollisionEvent e) {
        // check if the other body in the collision is an instance of Lava
        if (e.getOtherBody() instanceof Lava) {
            //increase damage count for the player and lava count for the lava object
            Enemy.setDamageCount(player.getDamageCount()+1);
            Lava.setLava(player.getLavaCount()+1);
            // if the player's damage count is not 3, reset their position to (-18,2)
            if (player.getDamageCount() != 3){
                player.setPosition(new Vec2(-18,2));
                // if the player's damage count is 3, stop the game sound and play the game over sound
            } else if (player.getDamageCount() == 3) {
                Game.gameSound.stop();
                gameOverSound.play();
            }
        }
    }
}