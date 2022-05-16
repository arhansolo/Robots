package ru.robots.game.gameObjects;

import static ru.robots.game.constants.GameParams.*;
import static ru.robots.game.constants.GameParams.minFieldCoordinateY;

abstract public class GameObject {
    private double gameObjectPositionX;
    private double gameObjectPositionY;
    private double gameObjectDirection;

    public GameObject (double x, double y, double direction){
        this.gameObjectPositionX = x;
        this.gameObjectPositionY = y;
        this.gameObjectDirection = direction;
    }

    public void setPosition(double x, double y){
        this.gameObjectPositionX = x;
        this.gameObjectPositionY = y;
    }

    public void setDirection(double direction){
        this.gameObjectDirection = direction;
    }

    public double getX() {
        return gameObjectPositionX;
    }

    public double getY() {
        return gameObjectPositionY;
    }

    public double getDirection() {
        return gameObjectDirection;
    }

    public boolean isOutOfBorders ()
    {
        return gameObjectPositionX > maxFieldCoordinateX || gameObjectPositionY > maxFieldCoordinateY
                || gameObjectPositionX < minFieldCoordinateX || gameObjectPositionY < minFieldCoordinateY;
    }
}
