package Authentication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class SignUp {
    
    GetDatabase database = new GetDatabase();;

    public SignUp(String username, String password) {

        boolean identicValidator = identicUsername(username);

        if (identicValidator) {

            JOptionPane.showMessageDialog(null, "Username taken! Please provide another username.");
            
        } else {
            
            addNewAccount(username, password);
            JOptionPane.showMessageDialog(null, "Account successfully signed.");

        }

    }

    /**
     * Checking identical username from database
     * 
     * @param username
     * @return
     */
    public boolean identicUsername(String username) {

        boolean identic = false;

        for (int i = 0; i < database.username.size(); i++) {
            
            if (database.username.get(i).equals(username)) {
                identic = true;
                break;
            }

        }

        return identic;

    }

    /**
     * Writing new account to database
     * 
     * @param username
     * @param password
     */
    public void addNewAccount(String username, String password) {

        try {

            FileWriter writer = new FileWriter(database.location);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < database.username.size(); i++) {
                
                bufferedWriter.write(database.username.get(i) + "," + database.password.get(i));
                bufferedWriter.newLine();

            }

            bufferedWriter.write(username + "," + password);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }

    }

}
