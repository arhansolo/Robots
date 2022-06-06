package ru.robots.game.commands;

import ru.robots.game.MathCalculator;
import ru.robots.game.gameObjects.Robot;

import static ru.robots.game.MathCalculator.*;

public interface MoveCommand extends Command{

    default void moveRobot(Robot robot, double m_targetPositionX, double m_targetPositionY, double duration) {
        double[] velocities = computeVelocities(robot, m_targetPositionX, m_targetPositionY);
        if (velocities == null) {
            return;
        }
        double velocity = velocities[0];
        double angularVelocity = velocities[1];
        velocity = MathCalculator.applyLimits(velocity, 0, robot.getMaxVelocity());
        angularVelocity = MathCalculator.applyLimits(angularVelocity, -robot.getMaxAngularVelocity(), robot.getMaxAngularVelocity());
        double newX = robot.getX() + velocity / angularVelocity *
                (Math.sin(robot.getDirection()  + angularVelocity * duration) -
                        Math.sin(robot.getDirection()));
        if (!Double.isFinite(newX)) {
            newX = robot.getX() + velocity * duration * Math.cos(robot.getDirection());
        }
        double newY = robot.getY() - velocity / angularVelocity *
                (Math.cos(robot.getDirection()  + angularVelocity * duration) -
                        Math.cos(robot.getDirection()));
        if (!Double.isFinite(newY)) {
            newY = robot.getY() + velocity * duration * Math.sin(robot.getDirection());
        }
        double newDirection = MathCalculator.asNormalizedRadians(robot.getDirection() + angularVelocity * duration);
        robot.setPosition(newX, newY);
        robot.setDirection(newDirection);
    }
}