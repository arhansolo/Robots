package ru.robots.presenter;

import ru.robots.game.*;
import ru.robots.game.constants.Gun;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;
import ru.robots.game.handlers.BotHandler;
import ru.robots.game.handlers.BulletHandler;
import ru.robots.game.handlers.PlayerHandler;
import static ru.robots.game.constants.GameConstants.*;
import static ru.robots.game.constants.Gun.*;

import ru.robots.game.inputDevicesHandlers.KeyboardParams;
import ru.robots.game.inputDevicesHandlers.MouseParams;
import ru.robots.gui.gameView.GameVisualizer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import static ru.robots.game.MathCalculator.angleTo;

public class GamePresenter {

    public GamePresenter(GameVisualizer visualizer){
        visualizer.addMouseMotionEventListener(this::setNewRobotDirection);
        visualizer.addMouseEventListener(this::setNewMouseClicked);
        visualizer.addKeyPressedEventListener(this::setNewKeyPressed);
        visualizer.addKeyReleasedEventListener(this::setNewKeyReleased);
        visualizer.addTaskOnUpdatePanel(new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        });
    }

    private final GameState gameState = new GameState();

    public void updateModel(){
        gameState.updateGameState();
    }

    public void setNewKeyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        setNewRobotMovingDirection(keyCode, true);
        setNewGun(keyCode);

        gameState.getHandlerMap().put(PLAYER_HANDLER_NAME, new PlayerHandler(gameState));
    }

    public void setNewKeyReleased(KeyEvent event){
        int keyCode = event.getKeyCode();
        setNewRobotMovingDirection(keyCode, false);

        gameState.getHandlerMap().put(PLAYER_HANDLER_NAME, new PlayerHandler(gameState));
    }

    public void setNewMouseClicked (MouseEvent event){
        GameObjectGenerator gameObjectGenerator = new GameObjectGenerator(gameState);
        gameObjectGenerator.generateShot(getPlayer(), getBulletArrayList());

        gameState.getHandlerMap().put(BULLET_HANDLER_NAME, new BulletHandler(gameState));
    }

    private void setNewRobotMovingDirection(int keyCode, boolean status){
        KeyboardParams keyboardParams = getKeyboardParams();
        switch (keyCode) {
            case 68 -> keyboardParams.setRight(status);
            case 65 -> keyboardParams.setLeft(status);
            case 83 -> keyboardParams.setUp(status);
            case 87 -> keyboardParams.setDown(status);
            case 16 -> keyboardParams.setDash(status);
        }
        gameState.setKeyboardParams(keyboardParams);
    }

    private void setNewGun(int keyCode){
        switch (keyCode) {
            case 49 -> getPlayer().setGun(PISTOL);
            case 50 -> getPlayer().setGun(SHOTGUN);
            case 51 -> getPlayer().setGun(SNIPER_RIFLE);
        }
    }

    public void setNewRobotDirection(MouseEvent event){
        Point mousePosition = event.getPoint();
        Robot player = getPlayer();
        double angle = angleTo(player.getX(), player.getY(), mousePosition.x, mousePosition.y);
        player.setDirection(angle);

        gameState.getHandlerMap().put(BOT_HANDLER_NAME, new BotHandler(gameState));
    }

    public boolean gameIsFinished(){
        return getPlayer().getHp() <= 0;
    }

    public String getWavesCount(){
        return String.valueOf(gameState.getRoundNumber());
    }

    public Robot getPlayer(){
        return gameState.getGameObjectData().getPlayer();
    }

    public ArrayList<Bullet> getBulletArrayList() {
        return gameState.getGameObjectData().getBulletArrayList();
    }

    public KeyboardParams getKeyboardParams(){
        return gameState.getKeyboardParams();
    }

    public MouseParams getMouseParams () {
        return gameState.getMouseParams();
    }

    public ArrayList<Robot> getBotArrayList(){
        return gameState.getGameObjectData().getBotArrayList();
    }
}
