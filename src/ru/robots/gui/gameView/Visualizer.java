//package ru.robots.gui.gameView;
//
//import ru.robots.presenter.GamePresenter;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.function.Consumer;
//
//public class Visualizer extends JPanel {
//
//    protected final java.util.Timer timer = initTimer();
//    protected final GamePresenter gamePresenter;
//    protected static java.util.Timer initTimer() {
//        return new Timer("events generator", true);
//    }
//
//    public Visualizer() {
//        gamePresenter = new GamePresenter(this);
//
//        setFocusable(true);
//        requestFocusInWindow();
//        setDoubleBuffered(true);
//    }
//
//    public void addTaskOnUpdatePanel(TimerTask task){
//        timer.schedule(task,0,10);
//    }
//
//    public void addMouseEventListener(Consumer<MouseEvent> listener){
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                listener.accept(e);
//            }
//        });
//    }
//
//    public void addMouseMotionEventListener(Consumer<MouseEvent> listener){
//        addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                listener.accept(e);
//            }
//        });
//    }
//
//    public void addKeyPressedEventListener(Consumer<KeyEvent> listener){
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                listener.accept(e);
//            }
//        });
//    }
//
//    public void addKeyReleasedEventListener(Consumer<KeyEvent> listener){
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                listener.accept(e);
//            }
//        });
//    }
//    protected void onRedrawEvent() {
//        EventQueue.invokeLater(this::repaint);
//    }
//
//}
