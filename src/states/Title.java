package states;

import graphics.GraphicManager;
import utils.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Title extends JPanel implements State {
    private final StateManager stateManager;
    private GraphicManager graphics;

    private BufferedImage[] titleScreen;

    public Title(StateManager stateManager) {
        this.stateManager = stateManager;
        setLayout(null);
        setGraphics();
        createButtons();
    }

    @Override
    public void setGraphics() {
        graphics = new GraphicManager();
        graphics.setBounds(0, 0, 800, 800);
        graphics.loadAnimation("/title_screen_sprite.png", 8, 1024, 1024);

        add(graphics);
    }

    @Override
    public void createLabels() {

    }

    @Override
    public void createButtons() {
        JButton playButton = new JButton();
        playButton.setBounds(150, 452, 150, 50);
        playButton.setBackground(Color.WHITE);
        playButton.setForeground(Color.BLACK);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateManager.changeState(GameState.GAME_MODE_SCREEN);
                System.out.println("Selected Play");
            }
        });

        add(playButton);

        JButton exitButton = new JButton("");
        exitButton.setBounds(425, 452, 150, 50);
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected Exit");
                System.exit(0);
            }
        });

        add(exitButton);
    }
}
