package ru.robots.game;

import java.util.ArrayList;
import java.util.Iterator;

public class BulletHandler implements ShootCommand{

    private final GameState gameState;

    public BulletHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(ArrayList<Bullet> bulletArrayList) {
        MouseParams mouseParams = gameState.getMouseParams();

        for (Iterator<Bullet> it = bulletArrayList.iterator(); it.hasNext(); ) {
            Bullet bullet = it.next();
            if (bullet.isOutOfDistanceOfAction()){
                it.remove();
            }
            shoot(bullet, mouseParams, gameState.getPlayer());
        }
    }
}

