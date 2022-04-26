package ru.robots.game;

import static ru.robots.game.MathCalculator.*;

public interface MoveCommand {
    void handleCommand(Robot robot);

    default void moveRobot(Robot robot, double m_targetPositionX, double m_targetPositionY, double duration) {
        double[] velocities = computeVelocities(robot, m_targetPositionX, m_targetPositionY);
        if (velocities == null) {
            return;
        }
        double velocity = velocities[0];
        double angularVelocity = velocities[1];
        velocity = MathCalculator.applyLimits(velocity, 0, robot.getMaxVelocity());
        angularVelocity = MathCalculator.applyLimits(angularVelocity, -robot.getMaxAngularVelocity(), robot.getMaxAngularVelocity());
        double newX = robot.getM_robotPositionX() + velocity / angularVelocity *
                (Math.sin(robot.getM_robotDirection()  + angularVelocity * duration) -
                        Math.sin(robot.getM_robotDirection()));
        if (!Double.isFinite(newX)) {
            newX = robot.getM_robotPositionX() + velocity * duration * Math.cos(robot.getM_robotDirection());
        }
        double newY = robot.getM_robotPositionY() - velocity / angularVelocity *
                (Math.cos(robot.getM_robotDirection()  + angularVelocity * duration) -
                        Math.cos(robot.getM_robotDirection()));
        if (!Double.isFinite(newY)) {
            newY = robot.getM_robotPositionY() + velocity * duration * Math.sin(robot.getM_robotDirection());
        }
        double newDirection = MathCalculator.asNormalizedRadians(robot.getM_robotDirection() + angularVelocity * duration);
        robot.setRobotPosition(newX, newY, newDirection);
    }
}
//перенести CV, сделать private + сделать data class