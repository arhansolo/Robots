package ru.robots.gui.gameView;

import java.awt.*;

public class Drawer {
    public static int round(double value) {
        return (int)(value + 0.5);
    }

    public static void fillOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
        g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }

    public static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
        g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }

    public static void fillHitBox(Graphics g, int x, int y, int w, int h){
        g.fillRect(x, y, w, h);
    }

    public static void drawHitBox(Graphics g, int x, int y, int w, int h) {
        g.drawRect(x, y, w, h);
    }

    public static void drawLine(Graphics2D g, int x, int y, int x1, int y1, int stroke){
        g.setStroke(new BasicStroke(stroke));
        g.drawLine(x, y, x1, y1);
        g.setStroke(new BasicStroke(1));
    }
}
