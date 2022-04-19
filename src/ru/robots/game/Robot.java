package ru.robots.game;
import static ru.robots.game.GameParams.*;

public abstract class Robot {

    protected double m_robotPositionX;
    protected double m_robotPositionY;
    protected double m_robotDirection;

    protected double maxVelocity;
    protected double maxAngularVelocity;

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

    public abstract void moveRobot(double m_targetPositionX, double m_targetPositionY, double duration);

    protected static double asNormalizedRadians(double angle) {
        while (angle < 0) {
            angle += 2*Math.PI;
        }
        while (angle >= 2*Math.PI) {
            angle -= 2*Math.PI;
        }
        return angle;
    }

    protected static double applyLimits(double value, double min, double max) {
        if (value < min)
        {
            return min;
        }

        return Math.min(value, max);
    }

    protected static double distance(double x1, double y1, double x2, double y2) {
        double diffX = x1 - x2;
        double diffY = y1 - y2;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    protected static double angleTo(double fromX, double fromY, double toX, double toY) {
        double diffX = toX - fromX;
        double diffY = toY - fromY;

        return asNormalizedRadians(Math.atan2(diffY, diffX));
    }

    protected double[] computeVelocities(double m_targetPositionX, double m_targetPositionY)
    {
        double distance = distance(m_targetPositionX, m_targetPositionY,
                m_robotPositionX, m_robotPositionY);
        if (distance < 0.5) {
            return null;
        }

        double velocity = maxVelocity;
        double angleToTarget = angleTo(m_robotPositionX, m_robotPositionY, m_targetPositionX, m_targetPositionY);
        double angularVelocity = 0;

        if (angleToTarget > m_robotDirection) {
            angularVelocity = maxAngularVelocity;
        }
        if (angleToTarget < m_robotDirection) {
            angularVelocity = -maxAngularVelocity;
        }

        return new double[] {velocity, angularVelocity};
    }
}
//создать интерфейс robotCommand, на вход которому  метод Handle будет поступать Robot
