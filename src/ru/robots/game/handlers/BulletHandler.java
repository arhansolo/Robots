package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.game.gameObjects.Bullet;

import java.util.ArrayList;
import java.util.Iterator;

import static ru.robots.game.commands.ShootCommand.shoot;

public class BulletHandler extends Handler {
    //private final GameState gameState;

    public BulletHandler(GameState gameState) {
        super(gameState);
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        ArrayList<Bullet> bulletArrayList = gameObjectData.getBulletArrayList();
        MouseParams mouseParams = gameState.getMouseParams();

        for (Iterator<Bullet> it = bulletArrayList.iterator(); it.hasNext(); ) {
            Bullet bullet = it.next();
            if (bullet.isOutOfDistanceOfAction()){
                it.remove();
            }
            shoot(bullet, mouseParams, gameState.getGameObjectData().getPlayer());
        }
    }
}