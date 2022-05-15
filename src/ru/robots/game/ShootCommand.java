package ru.robots.game;

import java.util.ArrayList;

public interface ShootCommand {
    void handleCommand(ArrayList<Bullet> bulletArrayList);

    default void shoot (Bullet bullet, MouseParams mouseParams, Robot player){

        double newX = bullet.getM_bulletPositionX();
        double newY = bullet.getM_bulletPositionY();

        newX += bullet.getM_bulletVelocity()*Math.cos(bullet.getAngle());
        newY += bullet.getM_bulletVelocity()*Math.sin(bullet.getAngle());
        bullet.setCoveredDistance(bullet.getCoveredDistance() + bullet.getM_bulletVelocity());

        bullet.setBulletPosition(newX, newY, bullet.getM_bulletDirection());
    }
}
