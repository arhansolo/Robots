package ru.robots.game;

import ru.robots.game.gameObjects.Robot;

import java.util.ArrayList;
import static ru.robots.game.constants.GameParams.*;

public class GameObjectGenerator {

    public ArrayList<Robot> generateBots(){
        ArrayList<Robot> bots = new ArrayList<Robot>();
        for (int i = 0; i < 3; i++){
            bots.add(getRobotWithRandomCoordinates());
        }

        return bots;
    }

    public Robot getRobotWithRandomCoordinates() {
        double x = Math.random()*maxFieldCoordinateX;
        double y = Math.random()*maxFieldCoordinateY;
        double direction = Math.random()*Math.PI;
        return new Robot(x, y, direction, 30, 20, false);
    }

}
