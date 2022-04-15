package ru.robots.game;

import java.awt.*;

public class Target {
    private volatile int m_targetPositionX;
    private volatile int m_targetPositionY;

    public void setDefaultTargetPosition()
    {
        m_targetPositionX = 0;
        m_targetPositionY = 0;
    }

    public int getM_targetPositionX() {
        return m_targetPositionX;
    }

    public int getM_targetPositionY() {
        return m_targetPositionY;
    }

    public void setTargetPosition(Point p) {
        m_targetPositionX = p.x;
        m_targetPositionY = p.y;
    }
}
