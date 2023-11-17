import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;


class LoginForm extends JFrame implements ActionListener {
    JPanel Panel1;
    
    JLabel emailLabel = new JLabel("EMAIL :");
    JLabel passwordLabel = new JLabel("PASSWORD :");

    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    
    JButton logInButton2 = new JButton("LOG IN");
    private JLabel imageLabel;
    boolean logedIn2 = false;
    
 
    LoginForm() {
        setTitle("Log In Form");
        setSize(820, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Panel1 = new JPanel(null);
        Panel1.setBackground(Color.BLACK);
        
        emailLabel.setBounds(220, 520, 180, 30);
        emailLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        emailLabel.setForeground(Color.WHITE);
        
        passwordLabel.setBounds(220, 560, 180, 30);
        passwordLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);
        
        
        emailTextField.setBounds(440, 520, 230, 26);
        emailTextField.setFont(new Font("Times new Roman", Font.BOLD,15));
        emailTextField.setForeground(Color.DARK_GRAY);
        
        passwordField.setBounds(440, 560, 230, 26);
        passwordField.setFont(new Font("Times new Roman", Font.BOLD,15));
        passwordField.setForeground(Color.DARK_GRAY);
        
        
        logInButton2.setBounds(345, 630, 100, 30);

        Panel1.add(emailLabel);
        Panel1.add(passwordLabel);
        Panel1.add(emailTextField);
        Panel1.add(passwordField);
        
        Panel1.add(logInButton2);

        logInButton2.setFont(new Font("Times new Roman", Font.BOLD, 16));
        logInButton2.setForeground(Color.BLACK);
        logInButton2.setBackground(Color.RED); 
        logInButton2.setEnabled(true);
        logInButton2.setBorder(BorderFactory.createLineBorder(Color.orange, 4)); // Add border
    
        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQEN8unxEA6WIw/feedshare-shrink_1280/0/1700989406574?e=1703721600&v=beta&t=lfmiDbcOUEGs1wcoQXLkmNm58dM4Vefri-g1jyZe6Qs");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(-10, 0, 858, 400);
            Panel1.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }
 
        add(Panel1);
        logInButton2.addActionListener(this);
        setVisible(true);
        
        setPlaceholder(passwordField, "Enter your Trove Password");
    }
    
    // Method to set placeholder in password field
    private void setPlaceholder(JPasswordField passwordField, String text) {
        passwordField.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
        
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(text)) {
                    passwordField.setText(""); // Clear the placeholder text when field is focused
                    passwordField.setEchoChar('*'); // Set the echo char to password character
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("")) {
                    passwordField.setText(text); // Set the placeholder text if no text was entered
                    passwordField.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
                }
            }
        });
        
        passwordField.setText(text); // Set initial text as the placeholder
        passwordField.setForeground(Color.DARK_GRAY); // Set the color of the placeholder text
    }
    

    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton2)
        {
            String email = emailTextField.getText();
            String password = new String(passwordField.getPassword());
            
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Login (Email, Password) VALUES ( ?, ?)");
                stmt.setString(1, email);
                stmt.setString(2, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Log In Successful!");
                    System.out.println("Log In Detail(s) was inserted successfully!");
                    logedIn2 = true;
                    logInButton2.setEnabled(true); // Disable sign-up button after successful sign-up
                    getContentPane().removeAll();
                    revalidate();
                    repaint();                    
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
}
}
}

public class Login{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new LoginForm();
        });
    }  
}