// First Welcome to TROVE [PANEL 0]
// Choose Login or Signup [PANEL 0]
// If Login --> Login page [PANEL 1]
// If Signup --> Signup page [PANEL 2]
// Sign up continued by Address page --> [PANEL 3]


// LOGIN BUTTON CLICK --> HOME PAGEc[PANEL 4]
// SIGN UP BUTTON CLICK --> LOGIN PAGE

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

//import pack1.Address;

class WelcomePage extends JFrame implements ActionListener {
    JPanel Panel0;
    
    JLabel welcomeLabel1 = new JLabel("     HELLO USER ! ");
    JLabel welcomeLabel2 = new JLabel(" Welcome to Trove Cart !" );
    JLabel welcomeLabel3 = new JLabel("                Discover a world of shopping delights within Trove Cart");
    JLabel welcomeLabel4 = new JLabel("your ultimate destination for all things e-commerce !");
    JLabel welcomeLabel5 = new JLabel("Sign up or log in to unlock a treasure trove of shopping experiences ! ");

    JButton LoginButton1 = new JButton("LOGIN");
    JButton SignUpButton1 = new JButton("SIGN UP");
    private JLabel imageLabel;
    boolean logedIn1 = false;
    boolean signedup1 = false; 
   

    WelcomePage() {
        setTitle("Welcome page");
        setSize(820, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel0 = new JPanel(null);
        Panel0.setBackground(Color.black);
        
        welcomeLabel1.setBounds(312, 410, 700, 50);
        welcomeLabel1.setFont(new Font("Times new Roman", Font.BOLD, 20));
        welcomeLabel1.setForeground(Color.WHITE);
        
        welcomeLabel2.setBounds(160, 445, 700, 50);
        welcomeLabel2.setFont(new Font("Times new Roman", Font.ITALIC, 17));
        welcomeLabel2.setForeground(Color.WHITE);
        
        welcomeLabel3.setBounds(275, 445, 700, 50);
        welcomeLabel3.setFont(new Font("Times new Roman", Font.ITALIC, 17));
        welcomeLabel3.setForeground(Color.WHITE);
        
        welcomeLabel4.setBounds(160, 468, 700, 50);
        welcomeLabel4.setFont(new Font("Times new Roman", Font.ITALIC, 17));
        welcomeLabel4.setForeground(Color.WHITE);
       
        welcomeLabel5.setBounds(160, 600, 700, 50);
        welcomeLabel5.setFont(new Font("Times new Roman", Font.ITALIC, 17));
        welcomeLabel5.setForeground(Color.WHITE);
        
        LoginButton1.setBounds(280, 550, 100, 30);
        SignUpButton1.setBounds(420, 550, 100, 30);
    
        Panel0.add(welcomeLabel1);
        Panel0.add(welcomeLabel2);
        Panel0.add(welcomeLabel3);
        Panel0.add(welcomeLabel4);
        Panel0.add(welcomeLabel5);
        
        Panel0.add(LoginButton1);
        Panel0.add(SignUpButton1);
        

        LoginButton1.setFont(new Font("Times new Roman", Font.BOLD, 16));
        LoginButton1.setForeground(Color.BLACK);
        LoginButton1.setBackground(Color.RED); 
        LoginButton1.setEnabled(true);
        LoginButton1.setBorder(BorderFactory.createLineBorder(Color.orange, 4)); // Add border
    
        SignUpButton1.setFont(new Font("Times new Roman", Font.BOLD, 16));
        SignUpButton1.setForeground(Color.BLACK);
        SignUpButton1.setBackground(Color.RED); 
        SignUpButton1.setEnabled(true);
        SignUpButton1.setBorder(BorderFactory.createLineBorder(Color.orange, 4)); // Add border
    
        
        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQF6jQTiMOx8Vg/feedshare-shrink_800/0/1700947729644?e=1703721600&v=beta&t=ANvXoY09STazc8QXNCA7RQ0XNBmcrf1if9fE-jgQJ5c");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(-15, 0, 850, 375);
            Panel0.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }


          
        add(Panel0);
        LoginButton1.addActionListener(this);
        SignUpButton1.addActionListener(this);
        setVisible(true);
        
    }
    
    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginButton1)
        {
            logedIn1= true;
            LoginButton1.setEnabled(true); // Disable sign-up button after successful sign-up
            getContentPane().removeAll();
            revalidate();
            repaint();                   
               
        }
        if (e.getSource() == SignUpButton1)
        {
            signedup1= true;
            SignUpButton1.setEnabled(true); // Disable sign-up button after successful sign-up
            getContentPane().removeAll();
            revalidate();
            repaint();                   
               
        }
        }
}


public class Welcome{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new WelcomePage();
        });
    }  
}

  