package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;

// Create a class called PlayerController which implements the KeyListener interface
public class PlayerController implements KeyListener {

    // Declare a constant variable for the walking speed of the player
    private static final float WALKING_SPEED = 10;

    // Declare a private variable of type Player
    private Player player;

    // SoundClip object for the sound effect played when a player jumps
    static SoundClip jumpSound;

    // static initializer block to create and load the jump sound object
    static{
        try {
            jumpSound = new SoundClip("data/sounds/jump.wav");
        } catch (UnsupportedAudioFileException| IOException| LineUnavailableException e){
            System.out.println(e);
        }
    }




    // Create a constructor which initializes the Player variable
    public PlayerController(Player p){
        player = p;
    }

    // Override the KeyListener interface's keyTyped method
    @Override
    public void keyTyped(KeyEvent k) {
    }

    // Override the KeyListener interface's keyPressed method
    @Override
    public void keyPressed(KeyEvent k) {
        // Get the integer code of the pressed key
        int code = k.getKeyCode();
        // Check the code of the pressed key and perform the corresponding action
        if (code == KeyEvent.VK_LEFT) {
            player.startWalking(-WALKING_SPEED); // Make the player walk left
            player.removeAllImages(); // Remove all previous images of the player
            player.addImage(new BodyImage("data/player.png", 4f)); // Add a new image of the player facing left
        } else if (code == KeyEvent.VK_RIGHT) {
            player.startWalking(WALKING_SPEED); // Make the player walk right
            player.removeAllImages(); // Remove all previous images of the player
            player.addImage(new BodyImage("data/player-flipped.png",4f)); // Add a new image of the player facing right
        }

        // Check if the player has collected any mushrooms and perform the corresponding action
        if (code == KeyEvent.VK_LEFT && Player.mushroomCount == 0) {
            player.startWalking(-WALKING_SPEED);// Make the player walk left
            player.removeAllImages();// Remove all previous images of the player
            player.addImage(new BodyImage("data/player.png", 2.5f));//Add a new image of the player facing left with a smaller size
        } else if (code == KeyEvent.VK_RIGHT && Player.mushroomCount == 0) {
            player.startWalking(WALKING_SPEED);// Make the player walk right
            player.removeAllImages();// Remove all previous images of the player
            player.addImage(new BodyImage("data/player-flipped.png",2.5f));// Add a new image of the player facing right with a smaller size
        }

        // Make the player jump when the up arrow key is pressed
        else if (code == KeyEvent.VK_UP){
            player.jump(50);
            jumpSound.play();
        }

        //make the player shoot when the space bar key is pressed
        else if (code == KeyEvent.VK_SPACE && Game.getCurrentLevel() instanceof Level3 && player.getFireballCount() == 1){
            player.shoot();
            Player.fireballSound.play();
        }
    }

    // Override the KeyListener interface's keyReleased method
    @Override
    public void keyReleased(KeyEvent k) {
        int code = k.getKeyCode();
        // Check the code of the released key and perform the corresponding action
        if (code == KeyEvent.VK_LEFT) {
            player.startWalking(0);// Stop the player from walking left
        } else if (code == KeyEvent.VK_RIGHT) {
            player.startWalking(0);// Stop the player from walking right
        }
    }

    public void updatePlayer(Player newPlayer){
        player = newPlayer;
    }
}
