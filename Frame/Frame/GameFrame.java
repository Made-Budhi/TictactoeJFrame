package Frame;

// Import custom package
import Turn.TakeTurn;
import Winning.WinCon;

// Import java package
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interface implemented.
 */
public class GameFrame extends AbstractFrame implements ActionListener {

    // JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];

    TakeTurn turn = new TakeTurn();
    WinCon win = new WinCon();

    public GameFrame() {

        // Frame Styling
        defaultFrame();
        
        // "Tic Tac Toe" Text
        text.setBackground(new Color(25, 25, 25));
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Ink Free", Font.BOLD, 75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("O Turn");
        text.setOpaque(true);
        
        // ******* PANEL STYLE START *******
        
        // Panel where "Tic Tac Toe" text is placed
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(text);
        
        // Panel where the list of buttons are placed
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.WHITE);
        
        // ******* PANEL STYLE END *******
        
        // List of buttons
        for (int i = 0; i < buttons.length; i++) {
            
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
            // Adding to buttonPanel
            buttonPanel.add(buttons[i]);
            
        }
        
        // Adding to frame
        this.frame.add(titlePanel, BorderLayout.NORTH);
        this.frame.add(buttonPanel);
        this.frame.setVisible(true);
        
    }

    /**
     * Set the symbol's color
     * 
     * @param button
     */
    public void symbolColor(JButton button) {
        if (button.getText().equals("O")) {

            button.setForeground(Color.GREEN);

        } else {

            button.setForeground(Color.RED);

        }
    }

    /**
     * Override interface ActionListener's method
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.length; i++) {
        
            try {
                
                if (e.getSource() == buttons[i]) {

                    if (buttons[i].getText() == "") {

                        String symbol = String.valueOf(turn.getCurrentSymbol(text));

                        buttons[i].setText(symbol);
                        symbolColor(buttons[i]);
                        win.checkWinning(this.frame, buttons, symbol, text);

                    } else {

                        throw new Exception();

                    }
                }

            } catch (Exception msg) {
                
                System.out.println("Taken!");

            }


        }

    }
    
}
