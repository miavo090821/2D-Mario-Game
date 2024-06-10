package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class EnemyCollision implements CollisionListener {

    // Fields to hold the player and game level instances
    private Player player;
    private GameLevel gameLevel;

    // Field to hold the SoundClip for the game over sound
    static SoundClip gameOverSound;

    // Static initializer to load the game over sound file and handle any potential errors
    static{
        try {
            gameOverSound = new SoundClip("data/sounds/gameOver.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // Constructor to initialize the player and game level fields
    public EnemyCollision(Player p, GameLevel gameLevel) {
        this.player = p;
        this.gameLevel = gameLevel;
    }

    // Method to handle collision events
    @Override
    public void collide(CollisionEvent e) {
        // If the player has no mushrooms and the other body involved in the collision is an Enemy object
        if (player.getMushroomCount() == 0 && e.getOtherBody() instanceof Enemy) {
            // Increase the damage count, destroy the enemy object and play turtle sound
            Enemy.setDamageCount(player.getDamageCount() + 1);
            player.setLinearVelocity(new Vec2(-5f,0));
            e.getOtherBody().destroy();
            Enemy.turtleSound.play();
        }


        // If the player has one mushroom and the other body involved in the collision is an Enemy object
        else if (player.getMushroomCount() == 1 && e.getOtherBody() instanceof Enemy) {
            // Do not increase the damage counts but destroy the enemy object and play turtle sound
            Enemy.setDamageCount(player.getDamageCount() + 0);
            player.setLinearVelocity(new Vec2(-5f,0));
            e.getOtherBody().destroy();
            Enemy.turtleSound.play();
        }

        // If the player has taken three hits from enemies and the other body involved in the collision is an Enemy object
        if (player.getDamageCount() == 3 && e.getOtherBody() instanceof Enemy) {
            // Stop the game music and play the game over sound
            Game.gameSound.stop();
            gameOverSound.play();
        }
    }
}