package ru.robots.game;

import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;
import static ru.robots.game.constants.BulletList.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static ru.robots.game.constants.GameParams.*;

public class GameObjectGenerator {

    public ArrayList<Robot> generateBots(){
        ArrayList<Robot> bots = new ArrayList<Robot>();
        for (int i = 0; i < 3; i++){
            bots.add(getRobotWithRandomCoordinates());
        }

        return bots;
    }

    public Robot generatePlayer(){
        Robot player = new Robot(100, 100, 0, 30, 20, true);
        return player;
    }

    public Robot getRobotWithRandomCoordinates() {
        double x = Math.random()*maxFieldCoordinateX;
        double y = Math.random()*maxFieldCoordinateY;
        double direction = Math.random()*Math.PI;
        return new Robot(x, y, direction, 30, 20, false);
    }

    public static ArrayList<Bullet> generateBullets(String typeOfGun){
        ArrayList<Bullet> bullets = new ArrayList<>();

        if (typeOfGun.equals(PISTOL)){
            bullets = generatePistolBullets();
        }

        if (typeOfGun.equals(SHOTGUN)){
            bullets =  generateShotgunBullets();
        }
        return bullets;
    }

    private static ArrayList<Bullet> generatePistolBullets() {
        return new ArrayList<>(Collections.singletonList(new Bullet(0, 0, 0, 6, 3, null, PISTOL_BULLET_VELOCITY, PISTOL_DTL, PISTOL_DAMAGE)));
    }

    private static ArrayList<Bullet> generateShotgunBullets(){
        return new ArrayList<>(Arrays.asList(new Bullet(0, 0, 0, 6, 3, null, SHOTGUN_BULLET_VELOCITY, SHOTGUN_DTL, SHOTGUN_DAMAGE),
                new Bullet(0, 0, SHOTGUN_BULLET_ANGLE, 6, 3, null, SHOTGUN_BULLET_VELOCITY, SHOTGUN_DTL, SHOTGUN_DAMAGE),
                new Bullet(0, 0, -SHOTGUN_BULLET_ANGLE, 6, 3, null, SHOTGUN_BULLET_VELOCITY, SHOTGUN_DTL, SHOTGUN_DAMAGE)));
    }

}
