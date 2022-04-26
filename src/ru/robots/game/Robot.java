package ru.robots.game;
import static ru.robots.game.GameParams.*;

public class Robot{

    protected double m_robotPositionX;
    protected double m_robotPositionY;
    protected double m_robotDirection;

    protected double maxVelocity;
    protected double maxAngularVelocity;

    public Robot(double x, double y, double direction) {
        this.m_robotPositionX = x;
        this.m_robotPositionY = y;
        this.m_robotDirection = direction;
    }

    public void setRobotPosition(double x, double y, double direction)
    {
        this.m_robotPositionX = x;
        this.m_robotPositionY = y;
        this.m_robotDirection = direction;
    }

    public void setVelocities (double velocity, double angularVelocity){
        this.maxVelocity = velocity;
        this.maxAngularVelocity = angularVelocity;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public double getMaxAngularVelocity() {
        return maxAngularVelocity;
    }

    public double getM_robotPositionX() {
        return m_robotPositionX;
    }

    public double getM_robotPositionY() {
        return m_robotPositionY;
    }

    public double getM_robotDirection() {
        return m_robotDirection;
    }

    public boolean isOutOfBorders ()
    {
        return m_robotPositionX > maxFieldCoordinateX || m_robotPositionY > maxFieldCoordinateY
                || m_robotPositionX < minFieldCoordinateX || m_robotPositionY < minFieldCoordinateY;
    }
}
