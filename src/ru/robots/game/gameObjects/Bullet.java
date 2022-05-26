package ru.robots.game.gameObjects;

public class Bullet extends GameObject{
    private final double bulletVelocity;
    private final double distanceToLive;

    private final Robot bulletSender;

    private String typeOfBullet;
    private double coveredDistance;

    private final int bulletDamage;

    public Bullet (double x, double y, double direction, double w, double h, Robot bulletSender, double bulletVelocity, double distanceToLive, int bulletDamage) {
        super(x, y, direction, w, h);
        this.bulletSender = bulletSender;
        this.bulletVelocity = bulletVelocity;
        this.distanceToLive = distanceToLive;
        this.bulletDamage = bulletDamage;
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

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void setCoveredDistance(double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public boolean isOutOfDistanceOfAction (){
        return coveredDistance > distanceToLive;
    }
}