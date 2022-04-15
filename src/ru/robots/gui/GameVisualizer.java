package ru.robots.gui;

import ru.robots.game.Robot;
import ru.robots.game.Target;
import ru.robots.gui.gameView.RobotDrawer;
import ru.robots.gui.gameView.TargetDrawer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GameVisualizer extends JPanel
{
    private final Timer m_timer = initTimer();

    private static Timer initTimer() {
        return new Timer("events generator", true);
    }

    volatile Robot robot = new Robot();
    volatile Target target = new Target();
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
        }, 0, 50);
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onModelUpdateEvent();
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
        setDoubleBuffered(true);
    }

    
    protected void onRedrawEvent()
    {
        EventQueue.invokeLater(this::repaint);
    }

    protected void onModelUpdateEvent()
    {
        double[] velocities = robot.computeVelocities(target.getM_targetPositionX(), target.getM_targetPositionY());
        if (velocities == null) {
            return;
        }

        if (robot.isOutOfBorders())
        {
            robot.setDefaultPosition();
            target.setDefaultTargetPosition();
        }
        robot.moveRobot(velocities[0], velocities[1], 10);
    }

    
    private static int round(double value) {
        return (int)(value + 0.5);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        robotDrawer.drawRobot(g2d, round(robot.getM_robotPositionX()), round(robot.getM_robotPositionY()), robot.getM_robotDirection(), robot);
        targetDrawer.drawTarget(g2d, target.getM_targetPositionX(), target.getM_targetPositionY());
    }
}
// перенести рисование в отдельный класс
// mvp
// составить план на 6 тасков
// presenter события, отрисовка
