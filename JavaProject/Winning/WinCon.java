package Winning;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class WinCon {
 
    public void checkWinning(JButton[] buttons, String symbol, JLabel text) {


        // Checking horizontal winning condition
        for (int i = 0; i < buttons.length; i+=3) {
            
            if (buttons[i].getText().equals(symbol) && 
                buttons[i+1].getText().equals(symbol) && 
                buttons[i+2].getText().equals(symbol)) {

                System.out.println(symbol + " win");
                
                JButton[] winButton = {buttons[i], buttons[i+1], buttons[i+2]};
                win(winButton, buttons, text, symbol); 
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
            }

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

}
