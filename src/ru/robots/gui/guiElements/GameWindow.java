package ru.robots.gui.guiElements;

import ru.robots.gui.gameView.GameVisualizer;

import java.awt.*;

import static ru.robots.gui.guiElements.GUIConstants.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame
{
    private final GameVisualizer gameVisualizer;

    public GameWindow() {
        super(NAME_OF_GAME_WINDOW, true, true, true, true);
        gameVisualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(gameVisualizer, BorderLayout.CENTER);
        //panel.add(new GameOverPanel(), BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
