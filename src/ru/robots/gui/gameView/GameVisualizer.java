package ru.robots.gui.gameView;

import ru.robots.game.Robot;
import ru.robots.game.Target;
import ru.robots.presenter.GamePresenter;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class  GameVisualizer extends JPanel
{
    private final Timer m_timer = initTimer();

    private static Timer initTimer() {
        return new Timer("events generator", true);
    }

    private final GamePresenter gamePresenter = new GamePresenter();
    private final Robot player = gamePresenter.getPlayer();
    private final Robot bot = gamePresenter.getBot();
    private final Target target = gamePresenter.getTarget();

    RobotDrawer robotDrawer = new RobotDrawer();
    TargetDrawer targetDrawer = new TargetDrawer();


    public GameVisualizer() {
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 10);
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                gamePresenter.onModelUpdateEvent();
            }
        }, 0, 10);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                target.setTargetPosition(e.getPoint());
                repaint();
        }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //gamePresenter.moveRobotUsingKeyboard(e.getKeyCode());
            }
        });

        setFocusable(true);
        requestFocusInWindow();
        setDoubleBuffered(true);
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
        robotDrawer.drawRobot(g2d, round(player.getM_robotPositionX()), round(player.getM_robotPositionY()), player.getM_robotDirection(), player);
        robotDrawer.drawRobot(g2d, round(bot.getM_robotPositionX()), round(bot.getM_robotPositionY()), bot.getM_robotDirection(), bot);
        targetDrawer.drawTarget(g2d, target.getM_targetPositionX(), target.getM_targetPositionY());
    }
}
