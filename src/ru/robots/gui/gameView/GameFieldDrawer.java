package ru.robots.gui.gameView;

import java.awt.*;
import static ru.robots.game.constants.GameParams.*;
import static ru.robots.gui.gameView.Drawer.*;


public class GameFieldDrawer {

    public void drawGameField (Graphics2D g2d){
        int strokeSize = 10;
        drawLine(g2d, (int)minFieldCoordinateX, (int)minFieldCoordinateY + 5, (int)maxFieldCoordinateX, (int)minFieldCoordinateY + 5, strokeSize);
        drawLine(g2d, (int)minFieldCoordinateX + 5, (int)minFieldCoordinateY, (int)minFieldCoordinateX + 5, (int)maxFieldCoordinateY, strokeSize);
        drawLine(g2d, (int)maxFieldCoordinateX, (int)maxFieldCoordinateY, (int)maxFieldCoordinateX, (int)minFieldCoordinateY, strokeSize);
        drawLine(g2d, (int)maxFieldCoordinateX, (int)maxFieldCoordinateY, (int)minFieldCoordinateX, (int)maxFieldCoordinateY, strokeSize);
    }

}
