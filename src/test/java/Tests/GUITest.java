package Tests;

import Programm.GUI;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
public class GUITest {
    @Mock
    GUI gui = new GUI();
    @Test
    public void printResult() throws AWTException {

        Robot bot = new Robot();
        gui.main();
        System.out.println(gui.buttons.get(1).getText());
        bot.mouseMove(250, 100);
        bot.delay(2000);
        bot.mouseMove(gui.buttons.get(1).getX() + gui.buttonsPanel.getX() + 20, gui.buttons.get(1).getY() + gui.buttonsPanel.getY() + 40);
        bot.delay(3000);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      //  bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(3000);
        bot.mouseMove(gui.buttons.get(2).getX() + gui.buttonsPanel.getX() + 35 , gui.buttons.get(2).getY() + gui.buttonsPanel.getY() + 40);
        bot.delay(3000);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(3000);
        JTextField result = GUI.result;

        Assert.assertEquals(result, GUI.result );



    }
}
