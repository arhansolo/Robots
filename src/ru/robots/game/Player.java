package ru.robots.game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import static ru.robots.game.GameParams.*;
import java.util.Map;

public class Player extends Robot{

    public Player() {
        this.m_robotPositionX = 100;
        this.m_robotPositionY = 100;
        this.m_robotDirection = 0;
    }

    @Override
    public void moveRobot(double m_targetPositionX, double m_targetPositionY, double duration) {
        double[] velocities = computeVelocities(m_targetPositionX, m_targetPositionY);
        if (velocities == null) {
            return;
        }
        double velocity = velocities[0];
        double angularVelocity = velocities[1];
        velocity = applyLimits(velocity, 0, maxVelocity);
        angularVelocity = applyLimits(angularVelocity, -maxAngularVelocity, maxAngularVelocity);
        double newX = m_robotPositionX + velocity / angularVelocity *
                (Math.sin(m_robotDirection  + angularVelocity * duration) -
                        Math.sin(m_robotDirection));
        if (!Double.isFinite(newX)) {
            newX = m_robotPositionX + velocity * duration * Math.cos(m_robotDirection);
        }
        double newY = m_robotPositionY - velocity / angularVelocity *
                (Math.cos(m_robotDirection  + angularVelocity * duration) -
                        Math.cos(m_robotDirection));
        if (!Double.isFinite(newY)) {
            newY = m_robotPositionY + velocity * duration * Math.sin(m_robotDirection);
        }
        m_robotPositionX = newX;
        m_robotPositionY = newY;
        double newDirection = asNormalizedRadians(m_robotDirection + angularVelocity * duration);
        m_robotDirection = newDirection;
    }
}
