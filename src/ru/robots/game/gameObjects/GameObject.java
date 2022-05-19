package ru.robots.game.gameObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static ru.robots.game.constants.GameParams.*;
import static ru.robots.gui.gameView.Drawer.round;
import static ru.robots.game.constants.GameParams.minFieldCoordinateY;

abstract public class GameObject {
    private double gameObjectPositionX;
    private double gameObjectPositionY;
    private double gameObjectDirection;

    private final double width;
    private final double height;


    public GameObject (double x, double y, double direction, double width, double height){
        this.gameObjectPositionX = x;
        this.gameObjectPositionY = y;
        this.gameObjectDirection = direction;
        this.width = width;
        this.height = height;
    }

    public void setPosition(double x, double y){
        this.gameObjectPositionX = x;
        this.gameObjectPositionY = y;
    }

    public Shape getGameObjectHitBox(){
        double x = gameObjectPositionX - width/2;
        double y = gameObjectPositionY - height/2;
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        Path2D hitBox = new Path2D.Double(rect);
        AffineTransform at = AffineTransform.getRotateInstance(gameObjectDirection, gameObjectPositionX, gameObjectPositionY);

        return hitBox.createTransformedShape(at);
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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isOutOfBorders ()
    {
        return gameObjectPositionX > maxFieldCoordinateX || gameObjectPositionY > maxFieldCoordinateY
                || gameObjectPositionX < minFieldCoordinateX || gameObjectPositionY < minFieldCoordinateY;
    }
}
