package game;

import city.cs.engine.*;


/**
 * Game level transitioning
 */
public abstract class GameLevel extends World {

    // Declare the instance variables
    private Player player;
    private Game game;
    GameLevel currentLevel;

    public GameLevel(Game game){

        // Set the instance variable game to the parameter game
        this.game = game;

        // Create a new Player object and set its gravity scale to 8
        player = new Player(this);
        player.setGravityScale(8);

        // Add collision listeners for various types of game objects
        PoundsPickup pickup = new PoundsPickup(player, this, game);
        player.addCollisionListener(pickup);

        EnemyCollision epickup = new EnemyCollision(player, currentLevel);
        player.addCollisionListener(epickup);

        MushroomPickup mpickup = new MushroomPickup(player);
        player.addCollisionListener(mpickup);

        BlockDestroy bDestroy = new BlockDestroy(player, this);
        player.addCollisionListener(bDestroy);

        PipeTopContact pipeTopContact = new PipeTopContact(player, this, game);
        player.addCollisionListener(pipeTopContact);

        FireballCollect fireballCollect = new FireballCollect(player, this, game);
        player.addCollisionListener(fireballCollect);

        FlagCollision flagCollision = new FlagCollision(player, this, game);
        player.addCollisionListener(flagCollision);

        LavaCollision lavaCollision = new LavaCollision(player, this, game);
        player.addCollisionListener(lavaCollision);
    }

    // Create a method to get the player object
    public Player getPlayer(){
        return player;
    }

    // Create an abstract method to check if the level is complete
    public abstract boolean isComplete();
}
