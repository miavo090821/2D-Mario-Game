package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JButton playButton;
    private JButton pauseButton;
    private JButton quitButton;
    public JPanel mainPanel;

    GameView view;

    public ControlPanel(GameView gameView) {
        this.view = gameView;

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getWorld().stop();
                view.stop();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getWorld().start();
                view.start();
            }
        });
    }
}
