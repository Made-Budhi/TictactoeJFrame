package Turn;

import javax.swing.JLabel;

public class TakeTurn {

    /**
     * Encapsulation implemented
     */
    private int turn = 0;
    private char currentSymbol;

    public char getCurrentSymbol(JLabel text) {
        if (turn % 2 == 0) {
            currentSymbol = 'O';
            turn++;
            text.setText("X - Turn");
        } else {
            currentSymbol = 'X';
            turn++;
            text.setText("O - Turn");
        }

        return currentSymbol;
    }    

    public void setCurrentSymbol(char currentSymbol) {
        this.currentSymbol = currentSymbol;
    }

}
