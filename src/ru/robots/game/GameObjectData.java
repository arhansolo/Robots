package ru.robots.game;

import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;

import java.util.ArrayList;

public class GameObjectData {
    private final Robot player;
    private final Robot bot;
    private final ArrayList<Bullet> bulletArrayList;

    public GameObjectData (Robot player, Robot bot, ArrayList<Bullet> bulletArrayList){
        this.player = player;
        this.bot = bot;
        this.bulletArrayList = bulletArrayList;
    }

    public Robot getPlayer() {
        return player;
    }

    public Robot getBot() {
        return bot;
    }

    public ArrayList<Bullet> getBulletArrayList() {
        return bulletArrayList;
    }
}
