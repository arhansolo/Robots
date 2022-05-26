package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.ShootCommand;
import ru.robots.game.gameObjects.Robot;
import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class BulletHandler implements ShootCommand {
    private final GameState gameState;

    public BulletHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        ArrayList<Bullet> bulletArrayList = gameObjectData.getBulletArrayList();
        MouseParams mouseParams = gameState.getMouseParams();

        for (int i = 0; i<bulletArrayList.size(); i++){
            Bullet bullet = bulletArrayList.get(i); //баг с ConcEx

            if (bullet.isOutOfDistanceOfAction() || isHit(bullet, gameObjectData)){
                bulletArrayList.remove(bullet);
            }
            shoot(bullet, mouseParams, gameState.getGameObjectData().getPlayer());
        }
    }

    public boolean isHit(Bullet bullet, GameObjectData gameObjectData){
        ArrayList<Robot> bots = gameObjectData.getBotArrayList();
        //Area bulletArea = new Area(bullet.getGameObjectHitBox());
        Shape bulletBounds = bullet.getGameObjectHitBox().getBounds2D();

        for (Iterator<Robot> it = bots.iterator(); it.hasNext(); ) {
            Robot bot = it.next();

            //bullet.getX() == bot.getX() && bullet.getY() == bot.getY()
            //bulletArea.intersect(new Area(bot.getGameObjectHitBox())); //bulletArea.isEmpty()
            //посмотреть другие способы отслеживания регистрации попадания

            if (bulletBounds.intersects(bot.getGameObjectHitBox().getBounds2D())
                    && !(bullet.getBulletSender() == bot)){
                bot.setHp(bot.getHp() - bullet.getBulletDamage());
                return true;
            }
        }
        return false;
    }
}