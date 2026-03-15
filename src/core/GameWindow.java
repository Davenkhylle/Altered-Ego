package core;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Altered Ego");
        setSize(720, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void changeWindow(JPanel newWindow) {
        getContentPane().removeAll();
        getContentPane().add(newWindow);
        revalidate();
        repaint();
    }
}
