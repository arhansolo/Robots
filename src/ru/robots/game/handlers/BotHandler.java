package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.MoveCommand;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;

import java.util.ArrayList;
import java.util.Iterator;

public class BotHandler implements MoveCommand{
    private final GameState gameState;

    public BotHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        ArrayList<Robot> bots = gameObjectData.getBotArrayList();
        Robot player = gameState.getGameObjectData().getPlayer();

        for (int i = 0; i < bots.size();i++){
            Robot bot = bots.get(i);

            if (bot.getHp() <= 0){
                bots.remove(bot);
            }

            bot.setVelocities(0.05, 0.001);
            if (bot.isOutOfBorders()) {
                bot.setPosition(50,50);
                bot.setDirection(0);
                bot.setVelocities(0, 0);
            }
            moveRobot(bot, player.getX(), player.getY(), 10);
        }
    }
}
