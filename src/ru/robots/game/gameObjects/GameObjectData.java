package ru.robots.game.gameObjects;

import java.util.ArrayList;

public class GameObjectData {
    private Robot player;
    private ArrayList<Robot> bots;
    private ArrayList<Bullet> bulletArrayList;

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

    public void setPlayer(Robot player) {
        this.player = player;
    }

    public void setBots(ArrayList<Robot> bots) {
        this.bots = bots;
    }

    public void setBulletArrayList(ArrayList<Bullet> bulletArrayList) {
        this.bulletArrayList = bulletArrayList;
    }
}
