package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.Command;
import ru.robots.game.commands.MoveCommand;
import ru.robots.game.gameObjects.GameObject;
import ru.robots.game.gameObjects.Robot;

import static ru.robots.game.commands.MoveCommand.moveRobot;

public class BotHandler extends Handler {
    //private final GameState gameState;

    public BotHandler(GameState gameState) {
        super(gameState);
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        Robot robot = gameObjectData.getBot();
        Robot player = gameState.getGameObjectData().getPlayer();

        robot.setVelocities(0.05, 0.001);
        if (robot.isOutOfBorders()) {
            robot.setPosition(50,50);
            robot.setDirection(0);
            robot.setVelocities(0, 0);
        }

        moveRobot(robot, player.getX(), player.getY(), 10);
    }
}
