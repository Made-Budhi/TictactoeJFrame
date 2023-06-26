package Authentication;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Frame.MenuFrame;

public class Authentication {

    GetDatabase database = new GetDatabase();

    public Authentication(JFrame loginFrame, String username, String password) {

        boolean verified = validator(username, password);

        if (verified) {
            loginFrame.dispose();
            new MenuFrame();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password.");
        }

    }

    public boolean validator(String username, String password) {

        boolean isValid = false;

        for (int i = 0; i < database.username.size(); i++) {
            
            if (database.username.get(i).equals(username) &&
                database.password.get(i).equals(password)) {

                isValid = true;
                break;

            }

        }

        return isValid;

    }

}
