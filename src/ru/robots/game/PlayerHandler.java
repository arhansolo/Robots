package ru.robots.game;

public class PlayerHandler implements KeyboardCommand{
    private final GameState gameState;

    public PlayerHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(Robot robot) {
        KeyboardParams keyboardParams = gameState.getKeyboardParams();
        robot.setVelocities(0.1, 0.001);

        if (robot.isOutOfBorders()) {
            robot.setRobotPosition(100,100,0);
            robot.setVelocities(0, 0);
        }
        moveRobotUsingKeyboard(robot, keyboardParams);
    }
}
