package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuFrame extends AbstractFrame implements ActionListener {

    JPanel titlePanel = new JPanel();
    JPanel menuPanel = new JPanel();

    JLabel title = new JLabel("Tic Tac Toe");

    JButton playButton = new JButton("Play!");
    JButton exitButton = new JButton("Exit");
    
    public MenuFrame() {

        defaultFrame();

        // Panel styling start

            titlePanel.setBounds(0, 0, 800, 200);
            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBackground(Color.WHITE);

            menuPanel.setBounds(0, 0, 800, 600);
            menuPanel.setLayout(null);
            menuPanel.setBackground(Color.BLACK);

        // Panel styling end

        // JLabel
        title.setFont(new Font("Ink Free", Font.BOLD, 120));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.GREEN.darker());

        // Button styling start

            playButton.setBounds(200, 150, 400, 100);
            playButton.setFont(new Font("MV Boli", Font.BOLD, 75));
            playButton.setForeground(Color.WHITE);
            playButton.setBackground(Color.GREEN.darker());
            playButton.setFocusable(false);
            playButton.addActionListener(this);
            
            exitButton.setBounds(200, 350, 400, 100);
            exitButton.setFont(new Font("MV Boli", Font.BOLD, 75));
            exitButton.setForeground(Color.WHITE);
            exitButton.setBackground(Color.RED.darker());
            exitButton.setFocusable(false);
            exitButton.addActionListener(this);

        // Button styling end

        // Adding to panel
        titlePanel.add(title);
        menuPanel.add(playButton, BorderLayout.CENTER);
        menuPanel.add(exitButton, BorderLayout.CENTER);

        // Adding to frame
        this.frame.add(titlePanel, BorderLayout.NORTH);
        this.frame.add(menuPanel, BorderLayout.CENTER);

        // Set frame visibility
        this.frame.setVisible(true);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == playButton) {
            this.frame.dispose();
            System.out.println("User Playing");
            new GameFrame();
        }

        if (e.getSource() == exitButton) {
            this.frame.dispose();
            System.out.println("User Exit");
        }

    }
    
    public static void main(String[] args) {
        new MenuFrame();
    }

}
