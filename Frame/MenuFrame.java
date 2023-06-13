package NewTictactoe.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuFrame implements ActionListener {

    public static JFrame menuFrame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JLabel title = new JLabel();
    JButton playButton = new JButton();
    JButton exitButton = new JButton();

    public MenuFrame() {
        // Frame
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 800);
        menuFrame.getContentPane().setBackground(new Color(10,10,10));
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setVisible(true);

        // Panel Start

            // Title Panel
                titlePanel.setBounds(0, 50, 800, 400);
                titlePanel.setBackground(new Color(240, 240, 240));
                titlePanel.setLayout(new BorderLayout());

            // Content Panel
                contentPanel.setBounds(0, 0, 600, 400);
                contentPanel.setLayout(new GridLayout(2, 1));

        // Panel End

        // Label
        title.setText("TIC-TAC-TOE");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 64));

        // Button Start

            // Play Button
            playButton.setText("Play!");
            playButton.setFont(new Font("Monospace", Font.BOLD, 32));
            playButton.setBounds(0, 0, 200, 100);
            playButton.setBackground(new Color(240, 240, 240));
            playButton.addActionListener(this);

            // Exit Button
            exitButton.setText("Exit");
            exitButton.setFont(new Font("Monospace", Font.BOLD, 32));
            exitButton.setForeground(new Color(255, 10, 10));
            exitButton.setBounds(0, 0, 200, 100);
            exitButton.setBackground(new Color(240, 240, 240));
            exitButton.addActionListener(this);

        // Button End

        // Adding 
        titlePanel.add(title);
        contentPanel.add(playButton);
        contentPanel.add(exitButton);
        menuFrame.add(contentPanel, BorderLayout.CENTER);
        menuFrame.add(titlePanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            System.out.println("tes");
            new GameFrame();
        }

        if (e.getSource() == exitButton) {
            System.out.println("exit");
        }
    }

}