package ru.robots.game.gameObjects;

public class Bullet extends GameObject{
    private double m_bulletVelocity = 10;
    private final double distanceToLive = 500;
    private String typeOfBullet;
    private double coveredDistance;

    public Bullet (double x, double y, double direction) {
        super(x, y, direction);
    }

    public double getM_bulletVelocity() {
        return m_bulletVelocity;
    }

    public double getCoveredDistance() {
        return coveredDistance;
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