package ru.robots.game;

import ru.robots.game.constants.RobotTypes;
import ru.robots.game.constants.BulletGeneratorMap;
import ru.robots.game.constants.Gun;
import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;


import java.util.ArrayList;
import java.util.Map;

import static ru.robots.game.constants.GameParams.*;
import static ru.robots.game.constants.Gun.SHOTGUN;

public class GameObjectGenerator {

    private final GameState gameState;
    private final RobotTypes robotTypes = new RobotTypes();

    public GameObjectGenerator(GameState gameState) {
        this.gameState = gameState;
    }

    public ArrayList<Robot> generateBots(){
        ArrayList<Robot> bots = new ArrayList<Robot>();
        int roundDif = gameState.getRoundNumber() * 2;

        while (roundDif >= 0){
            int random = (int )(Math.random() * 3 + 1);
            roundDif -= random;
            Robot bot = robotTypes.getRobot(random);
            bots.add(setRandomCoordinates(bot));
        }
        return bots;
    }

    public Robot generatePlayer(){
        return robotTypes.getPlayer();
    }

    private Robot setRandomCoordinates(Robot robot) {
        double x = Math.random()*maxFieldCoordinateX;
        double y = Math.random()*maxFieldCoordinateY;
        double direction = Math.random()*Math.PI;

        robot.setPosition(x, y);
        robot.setDirection(direction);

        return robot;
    }

    private ArrayList<Bullet> generateBullets(Gun gun){
        ArrayList<Bullet> bullets = new ArrayList<>();
        String typeOfGun = gun.getTypeOfGun();

        Map<Gun, ArrayList<Bullet>> bulletGeneratorMap = new BulletGeneratorMap().getBulletMap();

        for (Gun gun_ : bulletGeneratorMap.keySet()) {
            if (gun_.getTypeOfGun().equals(typeOfGun)){
                bullets = bulletGeneratorMap.get(gun_);
            }
        }
        return bullets;
    }

    public void generateShot(Robot robot, ArrayList<Bullet> bulletArrayList){
        GameObjectGenerator gameObjectGenerator = new GameObjectGenerator(gameState);
        ArrayList<Bullet> bullets = gameObjectGenerator.generateBullets(robot.getGun());

        if (!robot.isOnReload()){
            for (Bullet bullet : bullets){
                bullet.setBulletSender(robot);
                bullet.setPosition(robot.getX(), robot.getY());
                bullet.setDirection(robot.getDirection() + bullet.getDirection());

                bulletArrayList.add(bullet);
            }
            robot.setOnReload(true);
        }
    }
}
