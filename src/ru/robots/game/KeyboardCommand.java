package ru.robots.game;

public interface KeyboardCommand {
    void handleCommand(Robot robot);

    default void moveRobotUsingKeyboard(Robot player, KeyboardParams keyboardParams){

        double newX = player.getM_robotPositionX();
        double newY = player.getM_robotPositionY();
        double direction = player.getM_robotDirection();

        if (keyboardParams.isLeft()) newX -= 1;
        if (keyboardParams.isRight()) newX += 1;
        if (keyboardParams.isDown()) newY -= 1;
        if (keyboardParams.isUp()) newY += 1;

        player.setRobotPosition(newX, newY, direction);
    }
}
