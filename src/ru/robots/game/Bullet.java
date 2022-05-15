package ru.robots.game;

public class Bullet {
    protected double m_bulletPositionX;
    protected double m_bulletPositionY;
    protected double m_bulletDirection;

    private double m_bulletVelocity = 10;
    private final double distanceToLive = 500;
    private String typeOfBullet;
    private double coveredDistance;

    private double angle;

    public Bullet(double x, double y, double direction) {
        this.m_bulletPositionX = x;
        this.m_bulletPositionY = y;
        this.m_bulletDirection = direction;
    }

    public void setBulletPosition(double x, double y, double direction)
    {
        this.m_bulletPositionX = x;
        this.m_bulletPositionY = y;
        this.m_bulletDirection = direction;
    }

    public void setAngle (double angle){
        this.angle = angle;
    }

    public double getM_bulletVelocity() {
        return m_bulletVelocity;
    }

    public double getM_bulletPositionX() { return m_bulletPositionX; }

    public double getM_bulletPositionY() {
        return m_bulletPositionY;
    }

    public double getM_bulletDirection() {
        return m_bulletDirection;
    }

    public double getAngle() {
        return angle;
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