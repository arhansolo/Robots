package ru.robots.gui.gameView;

import ru.robots.game.Bullet;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static ru.robots.gui.gameView.Drawer.*;

public class BulletDrawer {
    public void drawBullet(Graphics2D g, int x, int y, double direction, Bullet bullet) {
        int bulletCenterX = round(bullet.getM_bulletPositionX());
        int bulletCenterY = round(bullet.getM_bulletPositionY());
        AffineTransform t = AffineTransform.getRotateInstance(direction, bulletCenterX, bulletCenterY);
        g.setTransform(t);
        g.setColor(Color.BLACK);
        fillOval(g, bulletCenterX, bulletCenterY, 10, 5);
        g.setColor(Color.BLACK);
        drawOval(g, bulletCenterX, bulletCenterY, 10, 5);
        g.setColor(Color.BLACK);
    }
}