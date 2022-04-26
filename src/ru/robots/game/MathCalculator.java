package ru.robots.game;

public class MathCalculator {
    public static double asNormalizedRadians(double angle) {
        while (angle < 0) {
            angle += 2*Math.PI;
        }
        while (angle >= 2*Math.PI) {
            angle -= 2*Math.PI;
        }
        return angle;
    }

    public static double applyLimits(double value, double min, double max) {
        if (value < min)
        {
            return min;
        }

        return Math.min(value, max);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double diffX = x1 - x2;
        double diffY = y1 - y2;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public static double angleTo(double fromX, double fromY, double toX, double toY) {
        double diffX = toX - fromX;
        double diffY = toY - fromY;

        return asNormalizedRadians(Math.atan2(diffY, diffX));
    }

    public static double[] computeVelocities(Robot robot, double m_targetPositionX, double m_targetPositionY)
    {
        double m_robotPositionX = robot.getM_robotPositionX();
        double m_robotPositionY = robot.getM_robotPositionY();
        double m_robotDirection = robot.getM_robotDirection();

        double distance = MathCalculator.distance(m_targetPositionX, m_targetPositionY,
                m_robotPositionX, m_robotPositionY);
        if (distance < 0.5) {
            return null;
        }

        double velocity = robot.getMaxVelocity();
        double maxAngularVelocity = robot.getMaxAngularVelocity();

        double angleToTarget = MathCalculator.angleTo(m_robotPositionX, m_robotPositionY, m_targetPositionX, m_targetPositionY);
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
