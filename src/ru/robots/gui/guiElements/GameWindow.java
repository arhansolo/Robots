package ru.robots.gui.guiElements;

import ru.robots.gui.gameView.GameVisualizer;

import java.awt.*;

import static ru.robots.gui.guiElements.GUIConstants.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame
{
    private final GameVisualizer m_visualizer;

    public GameWindow() {
        super(NAME_OF_GAME_WINDOW, true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
