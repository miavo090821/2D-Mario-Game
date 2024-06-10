package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class GameView extends UserView {

    // Declare a Player and Image variable
    private Player player;
    private Image background, background2,background3, background4, heart, pipe;

    // Declare a Timer variable and two integers to track time
    private Timer timer;
    private int seconds = 0;
    private int milliseconds = 0;

    // Method to get the total elapsed time
    public String getTotalTime() {
        return seconds + "."+ milliseconds;
    }

    // Game completion times file path
    public final static String fileName = "data/GameCompletionTimes.txt";

    String timeText;

    // GameView constructor
    public GameView(GameLevel w, int width, int height, Player p) {
        // Call UserView constructor to set dimensions of view
        super(w, width, height);
        // Load images for the background and foreground
        background = new ImageIcon("data/background.png").getImage();
        background2 = new ImageIcon("data/background2.png").getImage();
        background3 = new ImageIcon("data/background3.png").getImage();
        background4 = new ImageIcon("data/background4.png").getImage();
        heart = new ImageIcon("data/heart.png").getImage();
        pipe = new ImageIcon("data/pipe.png").getImage();
        player = p; //Set the player variable to the given Player object

        // Start the timer
        start();
    }

    // Method to start the timer
    public void start() {
        // Create a new timer and schedule it to run every millisecond
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                milliseconds++;
                // If one second has passed, increment the seconds variable and reset the milliseconds variable
                if (milliseconds == 1000) {
                    seconds++;
                    milliseconds = 0;
                }
            }
        }, 0, 1);
    }

    // Method to stop the timer
    public void stop() {
        timer.cancel();
    }

    // Override the method for painting the background of the view
    @Override
    protected void paintBackground(Graphics2D g) {
        // Draw the background image
        if (Game.getCurrentLevel() instanceof Level1){
            g.drawImage(background, 0, 0, this);
        } else if (Game.getCurrentLevel() instanceof Level2){
            g.drawImage(background, 0, 0, this);
        } else if (Game.getCurrentLevel() instanceof Level3) {
            g.drawImage(background2, 0, 0, this);
        } else if (Game.getCurrentLevel() instanceof Level4) {
            g.drawImage(background3, 0, 0, this);
        } else if (Game.getCurrentLevel() instanceof Level5) {
            g.drawImage(background4, 0, 0, this);
        }
    }


    // Override the method for painting the foreground of the view
    @Override
    protected void paintForeground(Graphics2D g) {
        // Draw the pipe on level 2
        if (Game.getCurrentLevel() instanceof Level2) {
            int pipeWidth = 120;
            int pipeHeight = 115;
            g.drawImage(pipe, 640, 471, pipeWidth, pipeHeight, this);
        }

        /* Draw hearts to represent the lives left - when a life is lost as a result of
        damage going up by one, one heart is removed*/
        if (player.getDamageCount() <= 2) {
            g.drawImage(heart, 150, 20, this);
        }
        if (player.getDamageCount() <= 1) {
            g.drawImage(heart, 210, 20, this);
        }
        if (player.getDamageCount() <= 0) {
            g.drawImage(heart, 270, 20, this);
        }
        // Draw text showing the number of coins collected
        g.setFont(new Font("Ariel", Font.BOLD,25));
        g.setColor(Color.white);
        String text = ("Pound");
        g.drawString(text, 10,50);
        String ccount = Integer.toString(player.getPounds());
        g.drawString(ccount,90,50);

        // Check if the game is over (if the player has lost all their lives and has collected no mushrooms)
        if (player.getMushroomCount() == 0 && player.getDamageCount() == 3){
            // Display "Game Over!" on the screen
            g.setFont(new Font("Ariel", Font.BOLD,80));
            String lost = ("Game Over!");
            g.drawString(lost, 180,350);
            stop(); // Stop the timer
            getWorld().stop(); // Stop the world
        }

        // Check if the player has collected all the coins and reached the flag
        if (player.getPounds() == 12 && player.getFlagCount() == 1) {
            // Display "Winner!" on the screen
            g.setFont(new Font("Ariel", Font.BOLD, 100));
            String won = ("Winner!");
            g.drawString(won, 220, 350);
            stop();// Stop the timer
            // Create a new timer to delay the world from stopping for 1 seconds
            java.util.Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    getWorld().stop();
                }
            }, 1000);

        }

        // Format the elapsed time as text with one decimal place
        timeText = String.format("%d.%01d seconds\n", seconds, milliseconds/100);

        // Draw the elapsed time as text
        g.setFont(new Font("Ariel", Font.BOLD, 25));
        g.setColor(Color.white);
        g.drawString("Time: ",360,50);
        g.drawString(timeText, 430, 50);

    }
}
