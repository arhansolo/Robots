package ru.robots.presenter;

import ru.robots.game.*;
import ru.robots.game.Robot;
import ru.robots.gui.gameView.GameVisualizer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

import static ru.robots.game.MathCalculator.angleTo;

public class GamePresenter {

    public GamePresenter(GameVisualizer visualizer){
        visualizer.addMouseMotionEventListener(this::setNewRobotDirection);
        visualizer.addKeyPressedEventListener(this::setNewKeyDir);
        visualizer.addKeyReleasedEventListener(this::cancelNewKeyDir);
        visualizer.addTaskOnUpdatePanel(new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        });
    }

    private GameState gameState = new GameState();

    public void updateModel(){
        gameState.updateGameState();
    }

    public void setNewKeyDir(KeyEvent event){
        int keyCode = event.getKeyCode();
        setNewRobotMovingDirection(keyCode, true);
        gameState.setPlayerCommand(new PlayerHandler(gameState));
    }

    public void cancelNewKeyDir(KeyEvent event){
        int keyCode = event.getKeyCode();
        setNewRobotMovingDirection(keyCode, false);
        gameState.setPlayerCommand(new PlayerHandler(gameState));
    }

    private void setNewRobotMovingDirection(int keyCode, boolean status){
        KeyboardParams keyboardParams = getKeyboardParams();
        switch (keyCode) {
            case 68 -> keyboardParams.setRight(status);
            case 65 -> keyboardParams.setLeft(status);
            case 83 -> keyboardParams.setUp(status);
            case 87 -> keyboardParams.setDown(status);
        }
        gameState.setKeyboardParams(keyboardParams);
    }

    public void setNewRobotDirection(MouseEvent event){
        Point mousePosition = event.getPoint();
        Robot player = getPlayer();
        double angle = angleTo(player.getM_robotPositionX(), player.getM_robotPositionY(), mousePosition.x, mousePosition.y);
        player.setRobotPosition(player.getM_robotPositionX(), player.getM_robotPositionY(), angle);
        gameState.setBotCommand(new BotHandler(gameState));
    }

    public Robot getPlayer(){
        return gameState.getPlayer();
    }

    public KeyboardParams getKeyboardParams(){
        return gameState.getKeyboardParams();
    }

    public Robot getBot(){
        return gameState.getBot();
    }
}
