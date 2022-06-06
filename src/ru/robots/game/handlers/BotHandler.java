package ru.robots.game.handlers;

import ru.robots.game.gameObjects.GameObjectData;
import ru.robots.game.GameObjectGenerator;
import ru.robots.game.GameState;
import ru.robots.game.commands.MoveCommand;
import ru.robots.game.gameObjects.Robot;
import static ru.robots.game.MathCalculator.*;
import static ru.robots.game.constants.GameConstants.*;
import static ru.robots.game.constants.RobotTypes.*;

import java.util.ArrayList;

public class BotHandler implements MoveCommand {
    private final GameState gameState;
    private final static double ANGLE_OF_VIEW = Math.PI/18;
    public BotHandler(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void handleCommand(GameObjectData gameObjectData) {
        ArrayList<Robot> bots = gameObjectData.getBotArrayList();
        Robot player = gameState.getGameObjectData().getPlayer();
        GameObjectGenerator gameObjectGenerator = new GameObjectGenerator(gameState);

        synchronized (bots){
            for (int i = 0; i < bots.size();i++){
                Robot bot = bots.get(i);
                if (bot.getHp() <= 0){
                    player.setHp(MAX_PLAYER_HP);
                    gameState.increaseKillsCount();
                    bots.remove(bot);
                }
                bot.setVelocities(0.05, 0.003);
                if (isReadyToShoot(player, bot)){
                    gameObjectGenerator.generateShot(bot, gameState.getGameObjectData().getBulletArrayList());
                    gameState.getHandlerMap().put(BULLET_HANDLER_NAME, new BulletHandler(gameState));
                }
                if (bot.isOutOfBorders()) {
                    bots.remove(bot);
                }
                moveRobot(bot, player.getX(), player.getY(), 10);
            }
        }
    }

    public boolean isReadyToShoot(Robot player, Robot bot){
        double distance = distance(bot.getX(), bot.getY(), player.getX(), player.getY());
        double angle = angleTo(bot.getX(), bot.getY(), player.getX(), player.getY());
        boolean isGoodDirection = bot.getDirection() > (angle - ANGLE_OF_VIEW) && bot.getDirection() < (angle + ANGLE_OF_VIEW);
        int dtl = bot.getGun().getDtl();
        return distance <= dtl && isGoodDirection;
    }
}
