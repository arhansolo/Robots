package ru.robots.game.handlers;

import ru.robots.game.gameObjects.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.KeyboardCommand;
import ru.robots.game.inputDevicesHandlers.KeyboardParams;
import ru.robots.game.gameObjects.Robot;

public class PlayerHandler implements KeyboardCommand {
    private final GameState gameState;
    public PlayerHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        Robot robot = gameObjectData.getPlayer();
        KeyboardParams keyboardParams = gameState.getKeyboardParams();
        robot.setVelocities(1, 0.001);
        if (robot.isOutOfBorders()) {
            robot.setPosition(100,100);
            robot.setDirection(0);
            robot.setVelocities(0, 0);
        }
        moveRobotUsingKeyboard(robot, keyboardParams);
    }
}
