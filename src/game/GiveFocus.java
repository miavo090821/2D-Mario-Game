package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Defining the "GiveFocus" class, which implements the MouseListener interface.
public class GiveFocus implements MouseListener {

    // Declaring a private variable of type "GameView" named "view".
    private GameView view;

    // Defining a constructor that takes an argument of type "GameView" and assigns it to the "view" variable.
    public GiveFocus(GameView v){
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent m) {

    }

    @Override
    public void mousePressed(MouseEvent m) {

    }

    @Override
    public void mouseReleased(MouseEvent m) {

    }

    @Override
    public void mouseEntered(MouseEvent m) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent m) {

    }
}