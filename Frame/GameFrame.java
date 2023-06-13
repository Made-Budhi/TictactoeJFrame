package NewTictactoe.Frame;

import NewTictactoe.Frame.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameFrame {
    
    // Frame Instansiate
    JFrame gameFrame = new JFrame();
    // Panel Instansiate
    JPanel infoPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    // Label Instansiate
    JLabel info = new JLabel();
    // Button Instansiate
    JButton[] buttons = new JButton[9];

    public GameFrame() {
        MenuFrame.menuFrame.setVisible(false);

        // Frame
        gameFrame.setSize(800, 800);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().setBackground(Color.BLACK);

        // Panel
        infoPanel.setBounds(0, 0, 800, 200);
        infopanel.setBackground(Color.BLACK);
        infoPanel.setLayout(new BorderLayout());

        // Label
        info.setText();

        // Adding
        gameFrame.add(infoPanel);
    }

}
