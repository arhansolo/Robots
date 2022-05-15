package ru.robots.game;

import java.util.ArrayList;

public class GameState {
    private final Robot player;
    private final Robot bot;

    private final ArrayList<Bullet> bulletArrayList;

    private BotHandler botHandler;
    private PlayerHandler playerHandler;
    private BulletHandler bulletHandler;

    private KeyboardParams keyboardParams;
    private MouseParams mouseParams;

    public GameState(){
        player = new Robot(100, 100, 0);
        bot = new Robot(0, 0, 0);
        bulletArrayList = new ArrayList<Bullet>();
        keyboardParams = new KeyboardParams(false, false, false, false);
        //mouseParams = new MouseParams(false);
    }

    public void updateGameState(){
        if(botHandler != null) {
            botHandler.handleCommand(bot);
        }
        if(playerHandler != null) {
            playerHandler.handleCommand(player);
        }
        if (bulletHandler != null) {
            bulletHandler.handleCommand(bulletArrayList);
        }
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

    public MouseParams getMouseParams() {
        return mouseParams;
    }

    public KeyboardParams getKeyboardParams() {
        return keyboardParams;
    }

    public void setPlayerCommand(PlayerHandler playerHandler){
        this.playerHandler = playerHandler;
    }

    public void setBotCommand(BotHandler botHandler){
        this.botHandler = botHandler;
    }

    public void setBulletCommand(BulletHandler bulletHandler) {
        this.bulletHandler = bulletHandler;
    }

    public void setKeyboardParams(KeyboardParams keyboardParams) {
        this.keyboardParams = keyboardParams;
    }

    public void setMouseParams(MouseParams mouseParams){
        this.mouseParams = mouseParams;
    }
}
