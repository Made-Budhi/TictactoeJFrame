package Frame;

import Authentication.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends AbstractFrame implements ActionListener {

    JPanel usernamePanel = new JPanel();
    JPanel passwordPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");

    JTextField usernameInput = new JTextField();
    JPasswordField passwordInput = new JPasswordField();

    JButton login = new JButton("Login");
    JButton signup = new JButton("Sign Up");
    JButton exit = new JButton("Exit");

    public LoginFrame() {

        defaultFrame();
        this.frame.setLayout(new GridLayout(3, 1));

        // Panel styling start

            usernamePanel.setLayout(null);

            passwordPanel.setLayout(null);

        // Panel styling end

        // Label styling start

            username.setBounds(0, 0, 800, 200);
            username.setHorizontalAlignment(JLabel.CENTER);
            username.setFont(new Font("Helvetica", Font.BOLD, 64));
            username.setHorizontalAlignment(JLabel.CENTER);
            username.setForeground(Color.GRAY.darker());
            
            password.setBounds(0, 0, 800, 200);
            password.setHorizontalAlignment(JLabel.CENTER);
            password.setFont(new Font("Helvetica", Font.BOLD, 64));
            password.setHorizontalAlignment(JLabel.CENTER);
            password.setForeground(Color.GRAY.darker());

        // Label styling end

        // Buton styling start

            login.setFont(new Font("Arial", Font.PLAIN, 24));
            login.setBackground(Color.GREEN.darker());
            login.setForeground(Color.WHITE);
            login.setFocusable(false);
            login.addActionListener(this);
            
            signup.setFont(new Font("Arial", Font.PLAIN, 24));
            signup.setBackground(Color.BLUE.darker());
            signup.setForeground(Color.WHITE);
            signup.setFocusable(false);
            signup.addActionListener(this);
            
            exit.setFont(new Font("Arial", Font.PLAIN, 24));
            exit.setBackground(Color.RED.darker());
            exit.setForeground(Color.WHITE);
            exit.setFocusable(false);
            exit.addActionListener(this);

        // Button styling end

        // Input field
        usernameInput.setBounds(200, 150, 400, 50);
        usernameInput.setFont(new Font("Helvetica", Font.PLAIN, 24));
        
        // Password field
        passwordInput.setBounds(200, 150, 400, 50);
        passwordInput.setFont(new Font("Helvetica", Font.PLAIN, 24));
        
        // Adding to panel
        usernamePanel.add(username);
        usernamePanel.add(usernameInput, BorderLayout.SOUTH);
        passwordPanel.add(password);
        passwordPanel.add(passwordInput);
        buttonPanel.add(login);
        buttonPanel.add(signup);
        buttonPanel.add(exit);

        // Adding to frame
        this.frame.add(usernamePanel);
        this.frame.add(passwordPanel);
        this.frame.add(buttonPanel);

        this.frame.setVisible(true);

    }

    public LoginFrame(String username, String password) {

        new Authentication(username, password);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == login) {

            String username = this.usernameInput.getText();
            String password = String.valueOf(this.passwordInput.getPassword());

            new Authentication(username, password);

        }

        if (e.getSource() == signup) {

            
            String username = this.usernameInput.getText();
            String password = String.valueOf(this.passwordInput.getPassword());
            
            try {

                if (username.equals("") || password.equals("")) {

                    throw new Exception("Input required.");

                }

                // Check if there is an Illegal character
                for (int i = 0; i < username.toCharArray().length; i++) {

                    if (username.toCharArray()[i] == ',' ||
                        username.toCharArray()[i] == ' ') {

                        throw new Exception("Illegal character detected.");

                    }

                }

                new SignUp(username, password);

            } catch (Exception msg) {
                JOptionPane.showMessageDialog(null, msg);
            }


        }

        if (e.getSource() == exit) {
            System.out.println("User Exit");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    
}
