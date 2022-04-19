package ru.robots.presenter;

import ru.robots.game.Bot;
import ru.robots.game.Player;
import ru.robots.game.Robot;
import ru.robots.game.Target;

import java.awt.event.KeyEvent;

import static ru.robots.game.GameParams.moveDirectionMap;

public class GamePresenter {

    private final Robot player = new Player();
    private final Target target = new Target();
    private final Robot bot = new Bot();

    public Robot getPlayer() {
        return player;
    }

    public Robot getBot() {
        return bot;
    }

    public Target getTarget() {
        return target;
    }

    public void onModelUpdateEvent() {
        player.setVelocities(0.1, 0.001);
        bot.setVelocities(0.05, 0.001);

        if (player.isOutOfBorders()) {
            player.setRobotPosition(100,100,0);
            player.setVelocities(0, 0);
            target.setTargetPosition(100,100);
        }
        if (bot.isOutOfBorders()) {
            bot.setRobotPosition(50,50,0);
            bot.setVelocities(0, 0);
        }
        player.moveRobot(target.getM_targetPositionX(), target.getM_targetPositionY(), 10);
        bot.moveRobot(player.getM_robotPositionX(), player.getM_robotPositionY(), 10);
    }

    public void moveRobotUsingKeyboard (int keyCode){
        switch (keyCode) {
            case 68 -> {
                player.setRobotPosition(player.getM_robotPositionX() + 3, player.getM_robotPositionY(), 0);
            }
            case 65 -> {
                player.setRobotPosition(player.getM_robotPositionX() - 3, player.getM_robotPositionY(), 0);
            }
            case 83 -> {
                player.setRobotPosition(player.getM_robotPositionX(), player.getM_robotPositionY() + 3, 0);
            }
            case 87 -> {
                player.setRobotPosition(player.getM_robotPositionX(), player.getM_robotPositionY() - 3, 0);
            }
        }
    }
}
