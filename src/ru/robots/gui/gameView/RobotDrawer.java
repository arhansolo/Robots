package ru.robots.gui.gameView;

import ru.robots.game.gameObjects.Robot;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static ru.robots.gui.gameView.Drawer.*;

public class RobotDrawer{

    public void drawRobot(Graphics2D g, Robot robot) {
        double direction = robot.getDirection();
        int robotCenterX = round(robot.getX());
        int robotCenterY = round(robot.getY());
        AffineTransform t = AffineTransform.getRotateInstance(direction, robotCenterX, robotCenterY);
        g.setTransform(t);

        Color robotColor = (robot.isPlayer()) ? Color.CYAN : Color.MAGENTA;
        g.setColor(robotColor);
        fillHitBox(g, robotCenterX - round(robot.getWidth()/2), robotCenterY - round(robot.getHeight()/2), round(robot.getWidth()), round(robot.getHeight()));
        g.setColor(Color.BLACK);
        drawHitBox(g, robotCenterX - round(robot.getWidth()/2), robotCenterY - round(robot.getHeight()/2), round(robot.getWidth()), round(robot.getHeight()));

        g.setColor(Color.WHITE);
        fillOval(g, robotCenterX, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, robotCenterX, robotCenterY, 5, 5);

    }
}
