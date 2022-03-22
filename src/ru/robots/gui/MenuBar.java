package ru.robots.gui;

import ru.robots.log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JFrame {

    MainApplicationFrame mainApplicationFrame;

    public JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu lookAndFeelMenu = generateLookAndFeelMenu();
        JMenu testMenu = generateTestMenu();

        addItemToTestMenu(testMenu);
        addItemToLookAndFeelMenu(lookAndFeelMenu);

        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);
        return menuBar;
    }

    private JMenu generateLookAndFeelMenu ()
    {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");
        return lookAndFeelMenu;
    }

    private JMenu generateTestMenu ()
    {
        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription("Тестовые команды");
        return testMenu;
    }

    private void addItemToLookAndFeelMenu (JMenu lookAndFeelMenu) {

        JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            mainApplicationFrame.invalidate();
        });


        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            mainApplicationFrame.invalidate();
        });

        lookAndFeelMenu.add(systemLookAndFeel);
        lookAndFeelMenu.add(crossplatformLookAndFeel);
    }

    private void addItemToTestMenu (JMenu testMenu) {
        JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
        addLogMessageItem.addActionListener((event) -> {
            Logger.debug("Новая строка");
        });
        testMenu.add(addLogMessageItem);
    }


    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(mainApplicationFrame);
        }
        catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // just ignore
        }
    }
}