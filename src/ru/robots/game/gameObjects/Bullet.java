package ru.robots.game.gameObjects;

public class Bullet extends GameObject{
    private final double bulletVelocity;
    private final double distanceToLive;

    private Robot bulletSender;

    private double coveredDistance;

    private final int bulletDamage;

    private final int shotDelayMs;

    public Bullet (double x, double y, double direction, double w, double h, double bulletVelocity, double distanceToLive, int bulletDamage, int shotDelayMs) {
        super(x, y, direction, w, h);
        this.bulletVelocity = bulletVelocity;
        this.distanceToLive = distanceToLive;
        this.bulletDamage = bulletDamage;
        this.shotDelayMs = shotDelayMs;
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

    public void setBulletSender(Robot bulletSender) {
        this.bulletSender = bulletSender;
    }

    public void setCoveredDistance(double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public boolean isOutOfDistanceOfAction (){
        return coveredDistance > distanceToLive;
    }
}