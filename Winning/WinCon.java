package Winning;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Frame.GameFrame;
import Frame.MenuFrame;

public class WinCon {
    
    public void checkWinning(JFrame gameFrame, JButton[] buttons, String symbol, JLabel text) {

        boolean draw = true;

        // Checking horizontal winning condition
        for (int i = 0; i < buttons.length; i+=3) {
            
            if (buttons[i].getText().equals(symbol) && 
                buttons[i+1].getText().equals(symbol) && 
                buttons[i+2].getText().equals(symbol)) {

                System.out.println(symbol + " win");
                
                JButton[] winButton = {buttons[i], buttons[i+1], buttons[i+2]};
                win(winButton, buttons, text, symbol); 
                afterWin(gameFrame);
                draw = false;
            }

        }

        // Checking vertical winning condition
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(symbol) && 
                buttons[i+3].getText().equals(symbol) && 
                buttons[i+6].getText().equals(symbol)) {

                System.out.println(symbol + " win");
                
                JButton[] winButton = {buttons[i], buttons[i+3], buttons[i+6]};
                win(winButton, buttons, text, symbol);
                afterWin(gameFrame);
                draw = false; 
            }
        }

        //Checking diagonal winning condition
        for (int i = 0; i < 3; i+=2) {

            if (buttons[i].getText().equals(symbol) && 
                buttons[4].getText().equals(symbol) && 
                buttons[8-i].getText().equals(symbol)) {
    
                System.out.println(symbol + " win");
                
                JButton[] winButton = {buttons[i], buttons[4], buttons[8-i]};
                win(winButton, buttons, text, symbol);
                afterWin(gameFrame);
                draw = false; 
            }

        }

        // Draw condition
        if (draw) {

            for (int i = 0; i < buttons.length; i++) {
                
                if (buttons[i].getText() == "") {
                    draw = false;
                }
    
            }
        
        }

        // Will execute if draw = true
        if (draw) {
            draw(buttons, text);
            afterWin(gameFrame);
        }

    }

    public void win(JButton[] winButtons, JButton[] disabledButtons, JLabel text, String symbol) {

        // Highlight the win axis
        for (int i = 0; i < winButtons.length; i++) {
            winButtons[i].setBackground(Color.WHITE);
        }

        // Disable all the buttons
        for (int i = 0; i < disabledButtons.length; i++) {
            disabledButtons[i].setEnabled(false);
        }

        text.setText(symbol + " WINS!");

    }
    
    public void draw(JButton[] disabledButtons, JLabel text) {

        // Disable all the buttons
        for (int i = 0; i < disabledButtons.length; i++) {
            disabledButtons[i].setEnabled(false);
        }

        text.setText("DRAW!");

    }

    public void afterWin(JFrame gameFrame) {

        int answer = JOptionPane.showConfirmDialog
        (gameFrame, "Game over, Play again?", "Game Over", JOptionPane.YES_NO_OPTION);

        switch (answer) {

            case 0:
                gameFrame.dispose();
                new GameFrame();
            break;

            case 1: 
                gameFrame.dispose();
                new MenuFrame();
            break;

            default:
                gameFrame.dispose();
                new MenuFrame();
            break;

        }

    }

}
