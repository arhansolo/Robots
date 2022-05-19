package ru.robots.game;

import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;

import java.util.ArrayList;

public class GameObjectData {
    private final Robot player;
    private final ArrayList<Robot> bots;
    private final ArrayList<Bullet> bulletArrayList;

    public GameObjectData (Robot player, ArrayList<Robot> bots, ArrayList<Bullet> bulletArrayList){
        this.player = player;
        this.bots = bots;
        this.bulletArrayList = bulletArrayList;
    }

    public Robot getPlayer() {
        return player;
    }

    public ArrayList<Robot> getBotArrayList() {
        return bots;
    }

    public ArrayList<Bullet> getBulletArrayList() {
        return bulletArrayList;
    }
}
