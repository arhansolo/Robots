package ru.robots.game.gameObjects;
import ru.robots.game.constants.Gun;

import java.util.Timer;
import java.util.TimerTask;

public class Robot extends GameObject{
    private final boolean isPlayer;

    private double maxVelocity;
    private double maxAngularVelocity;

    private int hp;
    private Gun gun;
    private boolean onReload;

    private final double dashDistance = 40;

    private Timer timer = new Timer("Shot delay", true);

    public Robot(double x, double y, double direction, double w, double h, int hp, boolean isPlayer, Gun gun) {
        super(x, y, direction, w, h);
        this.gun = gun;
        this.hp = hp;
        this.isPlayer = isPlayer;
        this.onReload = false;
    }

    public void setVelocities (double velocity, double angularVelocity){
        this.maxVelocity = velocity;
        this.maxAngularVelocity = angularVelocity;
    }

    private TimerTask setReloadTask() {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                setOnReload(false);
            }
        };
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
        setTimer();
    }

    private void setTimer() {
        timer.cancel();
        timer = new Timer("Shot delay", true);
        timer.schedule(setReloadTask(), 0, getGun().getShotDelay());
    }

    public void setOnReload(boolean onReload) {
        this.onReload = onReload;
    }

    public boolean isOnReload() {
        return onReload;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public Timer getTimer() {
        return timer;
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

    public Gun getGun() {
        return gun;
    }

    public double getDashDistance() {
        return dashDistance;
    }
}
