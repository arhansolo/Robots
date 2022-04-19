package ru.robots.game;

import java.awt.*;
import static ru.robots.game.GameParams.*;

public class Target {
    private volatile int m_targetPositionX = 100;
    private volatile int m_targetPositionY = 100;

    public void setTargetPosition(int x, int y)
    {
        this.m_targetPositionX = x;
        this.m_targetPositionY = y;
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
