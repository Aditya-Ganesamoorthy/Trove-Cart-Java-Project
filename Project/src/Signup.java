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


//import pack1.Address;

class SignUpForm extends JFrame implements ActionListener {
    JPanel Panel2;
    JLabel userNameLabel = new JLabel("USER NAME :");
    JLabel userIdLabel = new JLabel("USER ID :");
    JLabel dobLabel = new JLabel("DOB :");
    JLabel genderLabel = new JLabel("GENDER :");
    JLabel emailLabel_s1 = new JLabel("EMAIL :");
    JLabel passwordLabel_s1 = new JLabel("PASSWORD :");
    JLabel rePasswordLabel_s1 = new JLabel("RE-ENTER PASSWORD :");
    JLabel phoneNumberLabel = new JLabel("PHONE NO :");

    JTextField userNameTextField = new JTextField();
    JTextField userIdTextField = new JTextField();
    JTextField dobTextField = new JTextField();
    JTextField genderTextField = new JTextField();
    JTextField emailTextField_s1 = new JTextField();
    JPasswordField passwordField_s1 = new JPasswordField();
    JPasswordField rePasswordField_s1 = new JPasswordField();
    JTextField phoneNumberTextField = new JTextField();
    
    JButton signUpButton = new JButton("SIGN UP");
    private JLabel imageLabel3;
    boolean signedUp2 = false;
    
 
    SignUpForm() {
        setTitle("Sign Up Form");
        setSize(820, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBackground(Color.BLACK);

        userNameLabel.setBounds(220, 320, 180, 30);
        userNameLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        userNameLabel.setForeground(Color.WHITE);
        
        userIdLabel.setBounds(220, 360, 180, 30);
        userIdLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        userIdLabel.setForeground(Color.WHITE);
        
        dobLabel.setBounds(220, 400, 180, 30);
        dobLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        dobLabel.setForeground(Color.WHITE);
        
        genderLabel.setBounds(220, 440, 180, 30);
        genderLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        genderLabel.setForeground(Color.WHITE);
        
        emailLabel_s1.setBounds(220, 480, 180, 30);
        emailLabel_s1.setFont(new Font("Times new Roman", Font.BOLD, 16));
        emailLabel_s1.setForeground(Color.WHITE);
        
        passwordLabel_s1.setBounds(220, 520, 180, 30);
        passwordLabel_s1.setFont(new Font("Times new Roman", Font.BOLD, 16));
        passwordLabel_s1.setForeground(Color.WHITE);
        
        rePasswordLabel_s1.setBounds(220, 560, 200, 30);
        rePasswordLabel_s1.setFont(new Font("Times new Roman", Font.BOLD, 15));
        rePasswordLabel_s1.setForeground(Color.WHITE);
       
        phoneNumberLabel.setBounds(220, 600, 180, 30);
        phoneNumberLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        phoneNumberLabel.setForeground(Color.WHITE);
  
        userNameTextField.setBounds(440, 320, 230, 26);
        userNameTextField.setFont(new Font("Times new Roman", Font.BOLD,16));
        userNameTextField.setForeground(Color.DARK_GRAY);
        
        userIdTextField.setBounds(440, 360, 230, 26);
        userIdTextField.setFont(new Font("Times new Roman", Font.BOLD,15));
        userIdTextField.setForeground(Color.DARK_GRAY);
        
        dobTextField.setBounds(440, 400, 230, 26);
        dobTextField.setFont(new Font("Times new Roman", Font.BOLD,15));
        dobTextField.setForeground(Color.DARK_GRAY);
        
        genderTextField.setBounds(440, 440, 230, 26);
        genderTextField.setFont(new Font("Times new Roman", Font.BOLD,15));
        genderTextField.setForeground(Color.DARK_GRAY);
        
        emailTextField_s1.setBounds(440, 480, 230, 26);
        emailTextField_s1.setFont(new Font("Times new Roman", Font.BOLD,15));
        emailTextField_s1.setForeground(Color.DARK_GRAY);
        
        passwordField_s1.setBounds(440, 520, 230, 26);
        passwordField_s1.setFont(new Font("Times new Roman", Font.BOLD,15));
        passwordField_s1.setForeground(Color.DARK_GRAY);
        
        rePasswordField_s1.setBounds(440, 560, 230, 26);
        rePasswordField_s1.setFont(new Font("Times new Roman", Font.BOLD,15));
        rePasswordField_s1.setForeground(Color.DARK_GRAY);
        
        phoneNumberTextField.setBounds(440, 600, 230, 26);
        phoneNumberTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        phoneNumberTextField.setForeground(Color.DARK_GRAY);
 
        
        signUpButton.setBounds(360, 645, 100, 30);

        Panel2.add(userNameLabel);
        Panel2.add(userIdLabel);
        Panel2.add(dobLabel);
        Panel2.add(emailLabel_s1);
        Panel2.add(genderLabel);
        Panel2.add(passwordLabel_s1);
        Panel2.add(rePasswordLabel_s1);
        Panel2.add(phoneNumberLabel);
        
        Panel2.add(userNameTextField);
        Panel2.add(userIdTextField);
        Panel2.add(dobTextField);
        Panel2.add(genderTextField);
        Panel2.add(emailTextField_s1);
        Panel2.add(passwordField_s1);
        Panel2.add(rePasswordField_s1);
        Panel2.add(phoneNumberTextField);
        
        Panel2.add(signUpButton);

        signUpButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
        signUpButton.setForeground(Color.BLACK);
        signUpButton.setBackground(Color.RED); 
        signUpButton.setEnabled(true);
        signUpButton.setBorder(BorderFactory.createLineBorder(Color.orange, 4)); // Add border
    
        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQEz0goLDZSr3w/feedshare-shrink_2048_1536/0/1700670694032?e=1703721600&v=beta&t=76YT3-kAoeKe8PJmDSxLgqbwjffTifj4WNOJvtV5ANU");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel3 = new JLabel(imageIcon);
            imageLabel3.setBounds(-50, -20, 900, 337);
            Panel2.add(imageLabel3);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }
 
        add(Panel2);
        signUpButton.addActionListener(this);
        setVisible(true);
        
        setPlaceholder_s1(passwordField_s1, "Create your Trove Password");
        setPlaceholder_s2(rePasswordField_s1,"Re-enter your Trove password");
    }
    
    // Method to set placeholder in password field
    private void setPlaceholder_s1(JPasswordField passwordField_s1, String text) {
        passwordField_s1.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
        
        passwordField_s1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField_s1.getPassword()).equals(text)) {
                    passwordField_s1.setText(""); // Clear the placeholder text when field is focused
                    passwordField_s1.setEchoChar('*'); // Set the echo char to password character
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField_s1.getPassword()).equals("")) {
                    passwordField_s1.setText(text); // Set the placeholder text if no text was entered
                    passwordField_s1.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
                }
            }
        });
        
        passwordField_s1.setText(text); // Set initial text as the placeholder
        passwordField_s1.setForeground(Color.DARK_GRAY); // Set the color of the placeholder text
    }
        // Method to set placeholder in password field
    private void setPlaceholder_s2(JPasswordField rePasswordField_s1, String text) {
        rePasswordField_s1.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
        
       rePasswordField_s1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(rePasswordField_s1.getPassword()).equals(text)) {
                    rePasswordField_s1.setText(""); // Clear the placeholder text when field is focused
                    rePasswordField_s1.setEchoChar('*'); // Set the echo char to password character
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(rePasswordField_s1.getPassword()).equals("")) {
                    rePasswordField_s1.setText(text); // Set the placeholder text if no text was entered
                    rePasswordField_s1.setEchoChar((char)0); // Set echo char to 0 for displaying plain text
                }
            }
        });
        
        rePasswordField_s1.setText(text); // Set initial text as the placeholder
        rePasswordField_s1.setForeground(Color.DARK_GRAY); // Set the color of the placeholder text
    }

    

    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton)
        {
            // Code for login functionality after successful sign-up
            String username = userNameTextField.getText();
            String userid = userIdTextField.getText();
            String dob = dobTextField.getText();
            String gender = genderTextField.getText();
            String email = emailTextField_s1.getText();
            String password = new String(passwordField_s1.getPassword());
            String reEnteredPassword = new String(rePasswordField_s1.getPassword());
            if (!password.equals(reEnteredPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
                return;
            }
            String phoneno = phoneNumberTextField.getText(); 
            // Implement login logic here after user signs up
            // Example: Check credentials against a database after signup
            
            String to = email; // Get the email from the signup form
                    String subject = "Welcome to Trove Cart - Your New Shopping Destination!";
                    String message = "Dear " + username + ",\n\nWelcome to Trove Cart - Your gateway to a seamless shopping experience!\nWe're thrilled to have you on board. Thank you for choosing us to be your shopping companion. With Trove Cart, get ready to explore a world of exquisite products, unbeatable deals, and a hassle-free checkout experience. Stay tuned for exclusive offers, latest arrivals, and personalized recommendations curated just for you. \nOur team is here to ensure that your journey with us is nothing short of exceptional. Should you have any queries or need assistance, don't hesitate to reach out to our dedicated support team. \n\nHappy shopping!"+"\n\nBest regards, \nTrove Cart Team";

                    // Email sending code (similar to your Email class)
                    final String emailUsername = "71762233001@cit.edu.in"; // Replace with your email
                    final String emailPassword = "Adityagan29.cit.2023"; // Replace with your password

                    Properties emailProps = new Properties();
                    emailProps.put("mail.smtp.auth", "true");
                    emailProps.put("mail.smtp.starttls.enable", "true");
                    emailProps.put("mail.smtp.host", "smtp.gmail.com");
                    emailProps.put("mail.smtp.port", "587");

                    Session emailSession = Session.getInstance(emailProps,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(emailUsername, emailPassword);
                                }
                            });

                    try {
                        Message emailMessage = new MimeMessage(emailSession);
                        emailMessage.setFrom(new InternetAddress(emailUsername));
                        emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                        emailMessage.setSubject(subject);
                        emailMessage.setText(message);

                        Transport.send(emailMessage);
                        System.out.println("Email sent successfully!");
                    } catch (MessagingException ex) {
                        System.out.println("Error sending email: " + ex.getMessage());
                    }
            
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Login_1 (Username, Userid, Dob, Gender, Email, Password, Phoneno) VALUES (?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, username);
                stmt.setString(2, userid);
                stmt.setString(3, dob);
                stmt.setString(4, gender);
                stmt.setString(5, email);
                stmt.setString(6, password);
                stmt.setString(7, phoneno);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Sign Up Successful!");
                    System.out.println("Sign Up Detail(s) was inserted successfully!");
                    signedUp2 = true;
                    signUpButton.setEnabled(true); // Disable sign-up button after successful sign-up
                    getContentPane().removeAll();
                    revalidate();
                    repaint();                    
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            
            
            // Username copying using Primary key ********
           /*  Start
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Login_2 (Username) VALUES (?)");
                stmt.setString(1, username);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Username referred Successfully!");
                    System.out.println("A new user was inserted successfully!");
                    signedUp2 = true;
                    signUpButton.setEnabled(true); // Disable sign-up button after successful sign-up
                    
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }        end    */ 
}
}
}

public class Signup{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new SignUpForm();
        });
    }  
}