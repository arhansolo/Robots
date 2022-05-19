package ru.robots.game.commands;

import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;

public interface ShootCommand extends Command{

    default void shoot (Bullet bullet, MouseParams mouseParams, Robot player){

        double newX = bullet.getX();
        double newY = bullet.getY();

        newX += bullet.getBulletVelocity()*Math.cos(bullet.getDirection());
        newY += bullet.getBulletVelocity()*Math.sin(bullet.getDirection());
        bullet.setCoveredDistance(bullet.getCoveredDistance() + bullet.getBulletVelocity());

        bullet.setPosition(newX, newY);
    }
}
