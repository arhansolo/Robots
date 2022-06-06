package ru.robots.game.handlers;

import ru.robots.game.gameObjects.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.MoveBulletCommand;
import ru.robots.game.gameObjects.Robot;
import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BulletHandler implements MoveBulletCommand {
    private final GameState gameState;
    public BulletHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        ArrayList<Bullet> bulletArrayList = gameObjectData.getBulletArrayList();
        MouseParams mouseParams = gameState.getMouseParams();

        synchronized (bulletArrayList){
            for (int i = 0; i<bulletArrayList.size(); i++){
                Bullet bullet = bulletArrayList.get(i);

                if (bullet.isOutOfDistanceOfAction() || isHit(bullet, gameObjectData) || bullet.isOutOfBorders()){
                    bulletArrayList.remove(bullet);
                }
                moveBullet(bullet, mouseParams);
            }
        }
    }
    public boolean isHit(Bullet bullet, GameObjectData gameObjectData){
        ArrayList<Robot> bots = gameObjectData.getBotArrayList();
        Shape bulletBounds = bullet.getGameObjectHitBox().getBounds2D();
        Robot player = gameObjectData.getPlayer();

        synchronized (bots){
            for (Iterator<Robot> it = bots.iterator(); it.hasNext(); ) {
                Robot bot = it.next();

                if (isEnemyIntersection(bot, bullet, bulletBounds)){
                    bot.setHp(bot.getHp() - bullet.getBulletDamage());
                    return true;
                }
            }

            if (isEnemyIntersection(player, bullet, bulletBounds)){
                player.setHp(player.getHp() - bullet.getBulletDamage());
                return true;
            }
        }
        return false;
    }
    public boolean isEnemyIntersection (Robot robot, Bullet bullet, Shape bulletBounds) {
            return  bulletBounds.intersects(robot.getGameObjectHitBox().getBounds2D())
                    && !(bullet.getBulletSender().equals(robot));
    }
}