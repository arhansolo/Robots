package ru.robots.game.commands;

import ru.robots.game.inputDevicesHandlers.KeyboardParams;
import ru.robots.game.gameObjects.Robot;

public interface KeyboardCommand extends Command{

    default void moveRobotUsingKeyboard(Robot player, KeyboardParams keyboardParams){
        double newX = player.getX();
        double newY = player.getY();
        double direction = player.getDirection();
        double playerVelocity = player.getMaxVelocity();
        double dashDistance = (direction <= Math.PI) ? player.getDashDistance()*-1 : player.getDashDistance();

        if (keyboardParams.isLeft()) {
            if (keyboardParams.dashIsOk()){
                keyboardParams.setAlreadyDashed(true);
                newX += dashDistance*Math.sin(direction);
                newY -= dashDistance*Math.cos(direction);
            }
            else newX -= playerVelocity;
        }
        if (keyboardParams.isRight()) {
            if (keyboardParams.dashIsOk()){
                keyboardParams.setAlreadyDashed(true);
                newX -= dashDistance*Math.sin(direction);
                newY += dashDistance*Math.cos(direction);
            }
            else newX += playerVelocity;
        }
        if (keyboardParams.isDown()){
            if (keyboardParams.dashIsOk()){
                keyboardParams.setAlreadyDashed(true);
                newX += dashDistance*Math.cos(direction);
                newY += dashDistance*Math.sin(direction);
            }
            else newY -= playerVelocity;
        }
        if (keyboardParams.isUp()){
            if (keyboardParams.dashIsOk()){
                keyboardParams.setAlreadyDashed(true);
                newX -= dashDistance*Math.cos(direction);
                newY -= dashDistance*Math.sin(direction);
            }
            else newY += playerVelocity;
        }
        if (keyboardParams.dashIsOk()) {
            keyboardParams.setAlreadyDashed(true);
            newX += player.getDashDistance()*Math.cos(direction);
            newY += player.getDashDistance()*Math.sin(direction);
        }

        player.setPosition(newX, newY);
    }

    private void moveLeft(double newX, double newY, double direction, double distance, Robot player){
        newX += distance*Math.sin(direction);
        newY -= distance*Math.cos(direction);
        player.setPosition(newX, newY);
    }

    private void moveRight(double newX, double newY, double direction, double distance, Robot player){
        newX -= distance*Math.sin(direction);
        newY += distance*Math.cos(direction);
        player.setPosition(newX, newY);
    }

    private void moveDown(double newX, double newY, double direction, double distance, Robot player){
        newX += distance*Math.cos(direction);
        newY += distance*Math.sin(direction);
        player.setPosition(newX, newY);
    }

    private void moveUp(double newX, double newY, double direction, double distance, Robot player){
        newX -= distance*Math.cos(direction);
        newY -= distance*Math.sin(direction);
        player.setPosition(newX, newY);
    }
}
