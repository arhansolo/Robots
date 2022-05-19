package ru.robots.game.gameObjects;

public class Bullet extends GameObject{
    private double bulletVelocity = 10;
    private final double distanceToLive = 500;

    private Robot bulletSender;

    private String typeOfBullet;
    private double coveredDistance;

    public Bullet (double x, double y, double direction, double w, double h, Robot bulletSender) {
        super(x, y, direction, w, h);
        this.bulletSender = bulletSender;
    }

    public double getBulletVelocity() {
        return bulletVelocity;
    }

    public double getCoveredDistance() {
        return coveredDistance;
    }

    public Robot getBulletSender() {
        return bulletSender;
    }

    public double getDistanceToLive() {
        return distanceToLive;
    }

    public void setCoveredDistance(double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public boolean isOutOfDistanceOfAction (){
        return coveredDistance > distanceToLive;
    }
}