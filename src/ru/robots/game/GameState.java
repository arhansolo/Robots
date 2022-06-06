package ru.robots.game;

import ru.robots.game.commands.Command;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.GameObjectData;
import ru.robots.game.gameObjects.Robot;
import static ru.robots.game.constants.GameConstants.*;
import ru.robots.game.inputDevicesHandlers.KeyboardParams;
import ru.robots.game.inputDevicesHandlers.MouseParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    private final GameObjectData gameObjectData;

    private final Map<String, Command> handlerMap;

    private int roundNumber;

    private final GameObjectGenerator gameObjectGenerator = new GameObjectGenerator(this);

    private KeyboardParams keyboardParams;
    private MouseParams mouseParams;

    public GameState(){
        roundNumber = 1;

        Robot player = gameObjectGenerator.generatePlayer();
        ArrayList<Robot> bots = gameObjectGenerator.generateBots();
        ArrayList<Bullet> bulletArrayList = new ArrayList<Bullet>();

        handlerMap = new HashMap<>();
        handlerMap.put(PLAYER_HANDLER_NAME, null);
        handlerMap.put(BOT_HANDLER_NAME, null);
        handlerMap.put(BULLET_HANDLER_NAME, null);

        gameObjectData = new GameObjectData(player, bots, bulletArrayList);
        keyboardParams = new KeyboardParams(false, false, false, false, false);
        //mouseParams = new MouseParams(false);
    }

    public void updateGameState(){
        for (Command handler : handlerMap.values()) {
            if (handler != null){
                handler.handleCommand(gameObjectData);
            }
        }

        nextRound();
    }

    public Map<String, Command> getHandlerMap() {
        return handlerMap;
    }

    public void nextRound(){
        if (gameObjectData.getBotArrayList().size() == 0){
            this.roundNumber++;
            gameObjectData.setBots(gameObjectGenerator.generateBots());
        }
    }

    public GameObjectData getGameObjectData() {
        return gameObjectData;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public MouseParams getMouseParams() {
        return mouseParams;
    }

    public KeyboardParams getKeyboardParams() {
        return keyboardParams;
    }

    public void setKeyboardParams(KeyboardParams keyboardParams) {
        this.keyboardParams = keyboardParams;
    }

    public void setMouseParams(MouseParams mouseParams){
        this.mouseParams = mouseParams;
    }
}
