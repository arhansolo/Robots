package ru.robots.game.constants;

import ru.robots.game.gameObjects.Robot;

import javax.annotation.Nullable;

import static ru.robots.game.constants.Gun.*;

public class RobotTypes {

//    public static Robot PLAYER = new Robot(100, 100, 0, 30, 20, 100,true, SHOTGUN);
//    public static Robot NOOB = new Robot(0, 0, 0, 30, 20, 100,false, PISTOL);
//    public static Robot PUSHER = new Robot(0, 0, 0, 30, 20, 150,false, SHOTGUN);
//    public static Robot SNIPER =  new Robot(0, 0, 0, 30, 20, 80,false, SNIPER_RIFLE);
//
//    public static int NOOB_LEVEL = 1;
//    public static int PUSHER_LEVEL = 2;
//    public static int SNIPER_LEVEL = 3;

    public static final int MAX_PLAYER_HP = 100;
    public static final int MAX_NOOB_HP = 50;
    public static final int MAX_PUSHER_HP = 150;
    public static final int MAX_SNIPER_HP = 80;

    public Robot getPlayer(){
        return new Robot(100, 100, 0, 30, 20, MAX_PLAYER_HP,true, PISTOL);
    }


    private Robot getNoob() {
        return new Robot(0, 0, 0, 30, 20, MAX_NOOB_HP,false, PISTOL);
    }

    private Robot getPusher() {
        return new Robot(0, 0, 0, 30, 20, MAX_PUSHER_HP,false, SHOTGUN);
    }

    private Robot getSniper() {
        return new Robot(0, 0, 0, 30, 20, MAX_SNIPER_HP,false, SNIPER_RIFLE);
    }

    @Nullable
    public Robot getRobot(int level){
        switch (level) {
            case 1 -> {
                return getNoob();
            }
            case 2 -> {
                return getPusher();
            }
            case 3 -> {
                return getSniper();
            }
        }
        return null;
    }
}
