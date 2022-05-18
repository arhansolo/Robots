package ru.robots.game.gameObjects;

public class Robot extends GameObject{

    private double maxVelocity;
    private double maxAngularVelocity;

    private int hp;
    private int abilityCharge;

    private final double dashDistance = 40;

    public Robot(double x, double y, double direction) {
        super(x, y, direction);
        this.hp = 100;
        this.abilityCharge = 3;
    }

    public void setVelocities (double velocity, double angularVelocity){
        this.maxVelocity = velocity;
        this.maxAngularVelocity = angularVelocity;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setAbilityCharge (int abilityCharge){
        this.abilityCharge = abilityCharge;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public double getMaxAngularVelocity() {
        return maxAngularVelocity;
    }

    public int getHp() {
        return hp;
    }

    public int getAbilityCharge() {
        return abilityCharge;
    }

    public double getDashDistance() {
        return dashDistance;
    }
}
