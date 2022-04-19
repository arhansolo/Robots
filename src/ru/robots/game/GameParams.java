package ru.robots.game;

import java.util.HashMap;
import java.util.Map;

public class GameParams {

    public static final double maxFieldCoordinateX = 500;

    public static final double maxFieldCoordinateY = 500;

    public static final double minFieldCoordinateX = 0;

    public static final double minFieldCoordinateY = 0;

//    public static final int targetStartPositionX = 100;
//
//    public static final int targetStartPositionY = 100;

    public static final Map<Integer, Integer> moveDirectionMap = new HashMap<>();

    public GameParams(){
        moveDirectionMap.put(65, -10);
        moveDirectionMap.put(68, 10);
        moveDirectionMap.put(83, -10);
        moveDirectionMap.put(87, 10);
    }
}
