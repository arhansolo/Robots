package ru.robots.gui.guiElements;

import ru.robots.gui.gameView.visualizers.GameInfVisualizer;
import ru.robots.gui.gameView.visualizers.GameVisualizer;

import java.awt.*;

import static ru.robots.gui.guiElements.GUIConstants.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame
{
    private final GameVisualizer gameVisualizer;
    //private final GameInfVisualizer gameInfVisualizer;

    public GameWindow() {
        super(NAME_OF_GAME_WINDOW, true, true, true, true);
        gameVisualizer = new GameVisualizer();
        //gameInfVisualizer = new GameInfVisualizer();
        JPanel panel = new JPanel(new BorderLayout());

       // panel.add(gameInfVisualizer, BorderLayout.NORTH);
        panel.add(gameVisualizer, BorderLayout.CENTER);


        getContentPane().add(panel);
        pack();
    }
}
