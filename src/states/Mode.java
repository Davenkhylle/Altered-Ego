package states;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.GameState;

public class Mode extends JPanel implements State {
    private final StateManager stateManager;

    public Mode(StateManager stateManager) {
        this.stateManager = stateManager;
        setLayout(null);
        createButtons();
    }

    @Override
    public void setGraphics() {

    }

    @Override
    public void createLabels() {

    }

    @Override
    public void createButtons() {
        JLabel label = new JLabel("Select Game Mode", SwingConstants.CENTER);
        label.setBounds(100, 120, 500, 100);
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        add(label);

        JButton pvpButton = new JButton("PLayer vs PLayer");
        pvpButton.setBounds(250, 250, 200, 40);
        pvpButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
        pvpButton.setBackground(Color.WHITE);
        pvpButton.setForeground(Color.BLACK);

        pvpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected PVP");
            }
        });

        add(pvpButton);

        JButton pveButton = new JButton("PLayer vs Computer");
        pveButton.setBounds(250, 300, 200, 40);
        pveButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
        pveButton.setBackground(Color.WHITE);
        pveButton.setForeground(Color.BLACK);

        pveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected PVE");
            }
        });

        add(pveButton);

        JButton arcadeButton = new JButton("Arcade");
        arcadeButton.setBounds(250, 350, 200, 40);
        arcadeButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
        arcadeButton.setBackground(Color.WHITE);
        arcadeButton.setForeground(Color.BLACK);

        arcadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected Arcade");
            }
        });

        add(arcadeButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 400, 200, 40);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateManager.changeState(GameState.TITTLE_SCREEN);
            }
        });

        add(backButton);
    }
}
