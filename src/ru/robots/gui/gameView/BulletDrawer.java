package ru.robots.gui.gameView;

import ru.robots.game.gameObjects.Bullet;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static ru.robots.gui.gameView.Drawer.*;

public class BulletDrawer {
    public void drawBullet(Graphics2D g, Bullet bullet) {
        double direction = bullet.getDirection();
        int bulletCenterX = round(bullet.getX());
        int bulletCenterY = round(bullet.getY());
        AffineTransform t = AffineTransform.getRotateInstance(direction, bulletCenterX, bulletCenterY);
        g.setTransform(t);
        bulletCenterX -= round(bullet.getWidth()/2);
        bulletCenterY -= round(bullet.getHeight()/2);

        fillHitBox(g, bulletCenterX, bulletCenterY, round(bullet.getWidth()), round(bullet.getHeight()));
        g.setColor(Color.BLACK);
        drawHitBox(g, bulletCenterX, bulletCenterY, round(bullet.getWidth()), round(bullet.getHeight()));
        g.setColor(Color.BLACK);

    }
}
