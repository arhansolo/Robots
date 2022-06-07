//package ru.robots.gui.gameView.visualizers;
//
//import java.awt.*;
//import java.awt.font.TextAttribute;
//import java.text.AttributedString;
//import java.util.TimerTask;
//
//public class GameInfVisualizer extends Visualizer{
//
//    public GameInfVisualizer() {
//        timer.schedule(new TimerTask()
//        {
//            @Override
//            public void run()
//            {
//                onRedrawEvent();
//            }
//        }, 0, 10);
//    }
//
//
//    @Override
//    public void paintComponent(Graphics g){
//        printGameStat(g);
//    }
//
//    private void printGameStat(Graphics g){
//        super.paintComponent(g);
//        Font font = new Font("", Font.BOLD, 14);
//        g.drawString(getAttributedString("Здоровье: " + gamePresenter.getPlayer().getHp(), font).getIterator(), 0, 10);
//        g.drawString(getAttributedString("Тип оружия: " + gamePresenter.getPlayer().getGun().getTypeOfGun(), font).getIterator(), 200, 10);
//    }
//
//    private AttributedString getAttributedString(String str, Font font){
//        AttributedString aString = new AttributedString(str);
//        aString.addAttribute(TextAttribute.FONT, font);
//        return aString;
//    }
//}
