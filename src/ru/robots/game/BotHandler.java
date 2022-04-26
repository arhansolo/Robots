package ru.robots.game;

public class BotHandler implements MoveCommand{

    private final GameState gameState;

    public BotHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(Robot robot) {
        Robot player = gameState.getPlayer();

        robot.setVelocities(0.05, 0.001);
        if (robot.isOutOfBorders()) {
            robot.setRobotPosition(50,50,0);
            robot.setVelocities(0, 0);
        }
        moveRobot(robot, player.getM_robotPositionX(), player.getM_robotPositionY(), 10);
    }
}
