package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import java.util.Timer;
import java.util.TimerTask;

//Declares a class called PipeTopContact that implements the CollisionListener interface
public class PipeTopContact implements CollisionListener {

    //Declares an instance variable player of type Player
    private Player player;

    //Declares instance variables level and g of type GameLevel and Game respectively
    private GameLevel level;
    private Game g;


    //constructor
    public PipeTopContact(Player p, GameLevel level, Game game) {
        this.player = p;
        this.level = level;
        this.g = game;
    }


    //Overrides the collide method of the CollisionListener interface
    @Override
    public void collide(CollisionEvent e) {
        //Checks if the other body in the collision is an instance of PipeTop
        if (e.getOtherBody() instanceof PipeTop) {
            //Plays a sound when the collision occurs
            PipeTop.pipeSound.play();
            //Creates a new Timer object called timer and schedules a TimerTask to be run after 100 milliseconds
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // code to be executed after 2 seconds delay
                    //Checks if the player has collected all 6 pounds
                    if(player.getPounds() == 6) {
                        //Resets the PipeTop count to 1 and destroys the PipeTop object
                        PipeTop.setPipeTopCount(1);
                        e.getOtherBody().destroy();
                    }
                }
            }, 100);
            //Creates a new Timer object called timer2 and schedules a TimerTask to be run after 1000 milliseconds
            Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                @Override
                public void run() {
                    // code to be executed after 2 seconds delay
                    //Checks if the level is complete and if so, moves on to the next level
                    if (level.isComplete()) {
                        g.goToNextLevel();
                    }
                }
            }, 1000);
        }
    }
}