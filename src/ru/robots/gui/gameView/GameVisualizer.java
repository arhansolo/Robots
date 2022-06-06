package ru.robots.gui.gameView;

import ru.robots.game.gameObjects.Bullet;
import ru.robots.game.gameObjects.Robot;
import ru.robots.presenter.GamePresenter;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class GameVisualizer extends JPanel
{
    private final Timer timer = initTimer();
    private final GamePresenter gamePresenter;
    private static Timer initTimer() {
        return new Timer("events generator", true);
    }

    RobotDrawer robotDrawer = new RobotDrawer();
    BulletDrawer bulletDrawer = new BulletDrawer();
    GameFieldDrawer gameFieldDrawer = new GameFieldDrawer();

    public GameVisualizer() {
        gamePresenter = new GamePresenter(this);
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 10);

        setFocusable(true);
        requestFocusInWindow();
        setDoubleBuffered(true);
    }

    public void addTaskOnUpdatePanel(TimerTask task){
        timer.schedule(task,0,10);
    }

    public void addMouseEventListener(Consumer<MouseEvent> listener){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.accept(e);
            }
        });
    }

    public void addMouseMotionEventListener(Consumer<MouseEvent> listener){
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                listener.accept(e);
            }
        });
    }

    public void addKeyPressedEventListener(Consumer<KeyEvent> listener){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                listener.accept(e);
            }
        });
    }

    public void addKeyReleasedEventListener(Consumer<KeyEvent> listener){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                listener.accept(e);
            }
        });
    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    private void printGameOverText(Graphics g){
        super.paintComponent(g);
        Font font = new Font("", Font.BOLD, 30);
        g.drawString(getAttributedString("GAME OVER", font).getIterator(), 400, 400);
        g.drawString(getAttributedString("Пройдено волн: " + gamePresenter.getWavesCount(), font).getIterator(), 370, 450);
    }

    private AttributedString getAttributedString(String str, Font font){
        AttributedString aString = new AttributedString(str);
        aString.addAttribute(TextAttribute.FONT, font);
        return aString;
    }


    @Override
    public void paint(Graphics g) {
        if (isGameFinished()){
            timer.cancel();
            this.removeAll();
            printGameOverText(g);
            return;
        }

        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        Robot player = gamePresenter.getPlayer();
        ArrayList<Robot> bots = gamePresenter.getBotArrayList();
        ArrayList<Bullet> bulletArrayList = gamePresenter.getBulletArrayList();

//        Shape hb = player.getGameObjectHitBox();
//        g2d.setColor(Color.BLACK);
//        g2d.fill(hb);
//        g2d.draw(hb); //Checking HitBox drawing

//        File file = new File("asset/player.png");
//        BufferedImage image = ImageIO.read(file);
//        g2d.drawImage(image, null, (int)player.getX(), (int)player.getY());

        gameFieldDrawer.drawGameField(g2d);
        synchronized (bulletArrayList){
            for (Bullet bullet: bulletArrayList){
                bulletDrawer.drawBullet(g2d, bullet);
            }
        }

        synchronized (bots){
            for (Robot bot: bots){
                robotDrawer.drawRobot(g2d, bot);
            }
        }
        robotDrawer.drawRobot(g2d, player);
    }

    public boolean isGameFinished(){
        return gamePresenter.gameIsFinished();
    }
}
