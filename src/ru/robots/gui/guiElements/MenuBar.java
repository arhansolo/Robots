package ru.robots.gui.guiElements;

import ru.robots.log.Logger;
import static ru.robots.gui.guiElements.GUIConstants.*;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JFrame {

    MainApplicationFrame mainApplicationFrame;

    public JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu lookAndFeelMenu = generateMenu(NAME_OF_LAF_MENU, KeyEvent.VK_V, DESCRIPTION_OF_LAF_MENU);
        JMenu testMenu = generateMenu(NAME_OF_TEST_MENU, KeyEvent.VK_T, DESCRIPTION_OF_TEST_MENU);

        addItemToTestMenu(testMenu);
        addItemToLookAndFeelMenu(lookAndFeelMenu);

        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);
        return menuBar;
    }

    private JMenu generateMenu(String nameOfMenu, int keyEventCode, String accessibleDescription)
    {
        JMenu menu = new JMenu(nameOfMenu);
        menu.setMnemonic(keyEventCode);
        menu.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        return menu;
    }

    private void addItemToLookAndFeelMenu (JMenu lookAndFeelMenu) {

        JMenuItem systemLookAndFeel = new JMenuItem(SYS_SCHEME, KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            mainApplicationFrame.invalidate();
        });


        JMenuItem crossplatformLookAndFeel = new JMenuItem(UNI_SCHEME, KeyEvent.VK_S);
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