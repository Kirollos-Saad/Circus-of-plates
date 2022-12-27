package Controller;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenuBar extends JMenuBar { //TODO Builder Design Pattern

    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;

    public GameMenuBar() {
        JMenu menu = new JMenu("File");
        pauseMenuItem = new JMenuItem("Pause");
        resumeMenuItem = new JMenuItem("Resume");
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        this.add(menu);

    }

    public void setActionListeners(GameController gameController) {

        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });

    }

}
