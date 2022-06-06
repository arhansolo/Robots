//package ru.robots.gui.gameView;
//
//import ru.robots.presenter.GamePresenter;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.font.TextAttribute;
//import java.text.AttributedString;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class GameInfVisualizer extends Visualizer {
//
////    private final java.util.Timer timer = initTimer();
////    private final GamePresenter gamePresenter;
////
////    private static java.util.Timer initTimer() {
////        return new Timer("events generator", true);
////    }
//
//    public GameInfVisualizer(){
//        timer.schedule(new TimerTask()
//        {
//            @Override
//            public void run()
//            {
//                onRedrawEvent();
//            }
//        }, 0, 10);
//
//        setFocusable(true);
//        requestFocusInWindow();
//        setDoubleBuffered(true);
//    }
//
//
//    @Override
//    public void paintComponent(Graphics g){
//        printGameOverText(g);
//    }
//
//    private void printGameOverText(Graphics g){
//        super.paintComponent(g);
//        Font font = new Font("", Font.BOLD, 30);
//        g.drawString(getAttributedString("GAME OVER", font).getIterator(), 50, 50);
//    }
//
//    private AttributedString getAttributedString(String str, Font font){
//        AttributedString aString = new AttributedString(str);
//        aString.addAttribute(TextAttribute.FONT, font);
//        return aString;
//    }
//}
