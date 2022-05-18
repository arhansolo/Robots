package ru.robots.game.commands;

import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;

public class ShootCommand{

    public static void shoot (Bullet bullet, MouseParams mouseParams, Robot player){

        double newX = bullet.getX();
        double newY = bullet.getY();

        newX += bullet.getM_bulletVelocity()*Math.cos(bullet.getDirection());
        newY += bullet.getM_bulletVelocity()*Math.sin(bullet.getDirection());
        bullet.setCoveredDistance(bullet.getCoveredDistance() + bullet.getM_bulletVelocity());

        bullet.setPosition(newX, newY);
    }
}
