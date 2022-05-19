package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.ShootCommand;
import ru.robots.game.gameObjects.Robot;
import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;

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

        for (Iterator<Bullet> it = bulletArrayList.iterator(); it.hasNext(); ) {
            Bullet bullet = it.next();

            if (bullet.isOutOfDistanceOfAction() || isHit(bullet, gameObjectData)){
                it.remove();
            }
            shoot(bullet, mouseParams, gameState.getGameObjectData().getPlayer());
        }
    }

    public boolean isHit(Bullet bullet, GameObjectData gameObjectData){
        ArrayList<Robot> bots = gameObjectData.getBotArrayList();
        Area bulletArea = new Area(bullet.getGameObjectHitBox());

        for (Iterator<Robot> it = bots.iterator(); it.hasNext(); ) {
            Robot bot = it.next();

            //bullet.getX() == bot.getX() && bullet.getY() == bot.getY()
            bulletArea.intersect(new Area(bot.getGameObjectHitBox())); //bulletArea.isEmpty()
            //посмотреть другие способы отслеживания регистрации попадания + баг с ConcEx

            if (bullet.getGameObjectHitBox().getBounds2D().intersects(bot.getGameObjectHitBox().getBounds2D())){
                bot.setHp(bot.getHp() - 50);
                return true;
            }
        }
        return false;
    }
}