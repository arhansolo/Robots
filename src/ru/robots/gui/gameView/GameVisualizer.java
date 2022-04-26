package ru.robots.gui.gameView;

import ru.robots.game.Robot;
import ru.robots.presenter.GamePresenter;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class  GameVisualizer extends JPanel
{
    private final Timer m_timer = initTimer();
    private final GamePresenter gamePresenter;
    private static Timer initTimer() {
        return new Timer("events generator", true);
    }

    RobotDrawer robotDrawer = new RobotDrawer();

    public GameVisualizer() {
        gamePresenter = new GamePresenter(this);
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 10);

        setFocusable(true);
        requestFocusInWindow();
        setDoubleBuffered(true);
    }

    public void addTaskOnUpdatePanel(TimerTask task){
        m_timer.schedule(task,0,10);
    }

    public void addMouseEventListener(Consumer<MouseEvent> listener){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.accept(e);
                repaint();
            }
        });
    }

    public void addMouseMotionEventListener(Consumer<MouseEvent> listener){
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                listener.accept(e);
            }
        });
    }

    public void addKeyPressedEventListener(Consumer<KeyEvent> listener){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                listener.accept(e);
            }
        });
    }

    public void addKeyReleasedEventListener(Consumer<KeyEvent> listener){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                listener.accept(e);
            }
        });
    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }
    
    private static int round(double value) {
        return (int)(value + 0.5);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        Robot player = gamePresenter.getPlayer();
        Robot bot = gamePresenter.getBot();

        robotDrawer.drawRobot(g2d, round(player.getM_robotPositionX()), round(player.getM_robotPositionY()), player.getM_robotDirection(), player);
        robotDrawer.drawRobot(g2d, round(bot.getM_robotPositionX()), round(bot.getM_robotPositionY()), bot.getM_robotDirection(), bot);

    }
}
