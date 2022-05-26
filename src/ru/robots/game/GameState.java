package ru.robots.game;

import ru.robots.game.commands.Command;
import ru.robots.game.gameObjects.Bullet;
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

    private KeyboardParams keyboardParams;
    private MouseParams mouseParams;

    public GameState(){
        GameObjectGenerator gameObjectGenerator = new GameObjectGenerator();

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
    }

    public Map<String, Command> getHandlerMap() {
        return handlerMap;
    }

    public GameObjectData getGameObjectData() {
        return gameObjectData;
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
