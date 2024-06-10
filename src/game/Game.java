package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static game.GameView.fileName;

/**
 * Main game entry point
 */
public class Game {

    // Declare static variable to keep track of current game level
    static GameLevel currentLevel;

    // Declare instance variables for the game view, player controller and player object
    GameView view;
    PlayerController controller;
    Player player;

    // Declare static SoundClip object for game sound
    static SoundClip gameSound;

    // Static initialization block to load game sound
    static{
        try {
            gameSound = new SoundClip("data/sounds/themeSong.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // Getter method for current level
    public static GameLevel getCurrentLevel() {
        return currentLevel;
    }

    /** Initialise a new Game. */
    public Game() {
        //1. Set current level to Level1
        currentLevel = new Level1(this);

        // Set the game sound volume and loop it
        gameSound.setVolume(0.4f);
        gameSound.loop();


        //2. make a view to look into the game world
        view = new GameView(currentLevel, 800, 600, currentLevel.getPlayer());
        view.addMouseListener(new GiveFocus(view));

        // Create a new PlayerController object and pass the current player object from the world to it
        controller = new PlayerController(currentLevel.getPlayer());
        // Add the player controller as a key listener to the view
        view.addKeyListener(controller);


        //3. Create a new JFrame and add the game view and control panel to it
        final JFrame frame = new JFrame("Moving_Platform_Mia_Game");
        frame.add(view);

        ControlPanel controlPanel = new ControlPanel(view);
        frame.add(controlPanel.mainPanel, BorderLayout.SOUTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);


        // Start the current game level
        currentLevel.start();

        // Get the current player object
        player = currentLevel.getPlayer();

    }

    // Method to go to the next game level
    public void goToNextLevel(){
        // Check the current level and load the appropriate next level
        if (currentLevel instanceof Level1){
            System.out.println("Level 1");
            currentLevel.stop();
            currentLevel = new Level2(this);
            view.setWorld(currentLevel);
            controller.updatePlayer(currentLevel.getPlayer());
            currentLevel.start();
        } else if (currentLevel instanceof Level2) {
            System.out.println("Level 2");
            currentLevel.stop();
            currentLevel = new Level3(this);
            view.setWorld(currentLevel);
            controller.updatePlayer(currentLevel.getPlayer());
            currentLevel.start();
        } else if (currentLevel instanceof Level3) {
            System.out.println("Level 3");
            currentLevel.stop();
            currentLevel = new Level4(this);
            view.setWorld(currentLevel);
            controller.updatePlayer(currentLevel.getPlayer());
            currentLevel.start();
        } else if (currentLevel instanceof Level4) {
            System.out.println("Level 4");
            currentLevel.stop();
            currentLevel = new Level5(this);
            view.setWorld(currentLevel);
            controller.updatePlayer(currentLevel.getPlayer());
            currentLevel.start();
        } else if (currentLevel instanceof Level5) {
            System.out.println("Game Finished");
            if (player.getFlagCount() == 1) { // if the player has touched one flag
                CompletionTimeWriter writer = new CompletionTimeWriter(fileName); // create a CompletionTimeWriter instance
                try {
                    writer.writeHighScore(view.getTotalTime()); // write the high score to the file
                } catch (IOException e) {
                    System.out.println("missing high score"); // if an error occurs while writing, print an error message
                    e.printStackTrace();
                }
            }
        }
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

}
