package ru.robots.game.gameObjects;
import static ru.robots.game.constants.BulletList.*;

public class Robot extends GameObject{

    private final boolean isPlayer;

    private double maxVelocity;
    private double maxAngularVelocity;

    private int hp;
    private int abilityCharge;
    private String typeOfGun;

    private final double dashDistance = 40;

    public Robot(double x, double y, double direction, double w, double h, boolean isPlayer) {
        super(x, y, direction, w, h);
        this.typeOfGun = PISTOL;
        this.hp = 100;
        this.abilityCharge = 3;
        this.isPlayer = isPlayer;
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

    public void setTypeOfGun(String typeOfGun) {
        this.typeOfGun = typeOfGun;
    }

    public boolean isPlayer() {
        return isPlayer;
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

    public String getTypeOfGun() {
        return typeOfGun;
    }

    public int getAbilityCharge() {
        return abilityCharge;
    }

    public double getDashDistance() {
        return dashDistance;
    }
}
