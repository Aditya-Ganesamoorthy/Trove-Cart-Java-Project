import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

//import pack1.Address;

class AddressForm extends JFrame implements ActionListener {
    JPanel Panel3;
    
    JLabel doorNoLabel = new JLabel("DOOR NO :");
    JLabel streetNameLabel = new JLabel("STREET NAME :");
    JLabel townLabel = new JLabel("TOWN :");
    JLabel districtLabel = new JLabel("DISTRICT :");
    JLabel stateLabel = new JLabel("STATE :");
    JLabel pincodeLabel = new JLabel("PINCODE :");

    JTextField doorNoTextField = new JTextField();
    JTextField streetNameTextField = new JTextField();
    JTextField townTextField = new JTextField();
    JTextField districtTextField = new JTextField();
    JTextField stateTextField = new JTextField();
    JTextField pincodeTextField = new JTextField();
        
    
    JButton saveAddressButton = new JButton("SAVE");
    private JLabel imageLabel4;
    boolean saved = false;
   

    AddressForm() {
        setTitle("Adress Form");
        setSize(820, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel3 = new JPanel(null);
        Panel3.setBackground(Color.black);
        
        doorNoLabel.setBounds(230, 395, 180, 30);
        doorNoLabel.setFont(new Font("Times new Roman", Font.BOLD, 15));
        doorNoLabel.setForeground(Color.WHITE);
        
        streetNameLabel.setBounds(230, 435, 180, 30);
        streetNameLabel.setFont(new Font("Times new Roman", Font.BOLD, 15));
        streetNameLabel.setForeground(Color.WHITE);
        
        townLabel.setBounds(230, 475, 180, 30);
        townLabel.setFont(new Font("Times new Roman", Font.BOLD, 15));
        townLabel.setForeground(Color.WHITE);
        
        districtLabel.setBounds(230, 515, 180, 30);
        districtLabel.setFont(new Font("Times new Roman", Font.BOLD, 15));
        districtLabel.setForeground(Color.WHITE);
        
        stateLabel.setBounds(230, 555, 180, 30);
        stateLabel.setFont(new Font("Times new Roman", Font.BOLD, 15));
        stateLabel.setForeground(Color.WHITE);
        
        pincodeLabel.setBounds(230, 595, 180, 30);
        pincodeLabel.setFont(new Font("Times new Roman", Font.BOLD, 14));
        pincodeLabel.setForeground(Color.WHITE);
        
        doorNoTextField.setBounds(430, 395, 200, 26);
        doorNoTextField.setFont(new Font("Times new Roman", Font.BOLD,15));
        doorNoTextField.setForeground(Color.DARK_GRAY);
        
        streetNameTextField.setBounds(430, 435, 200, 26);
        streetNameTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        streetNameTextField.setForeground(Color.DARK_GRAY);
        
        townTextField.setBounds(430, 475, 200, 26);
        townTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        townTextField.setForeground(Color.DARK_GRAY);
        
        districtTextField.setBounds(430, 515, 200, 26);
        districtTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        districtTextField.setForeground(Color.DARK_GRAY);
        
        
        stateTextField.setBounds(430, 555, 200, 26);
        stateTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        stateTextField.setForeground(Color.DARK_GRAY);
        
        pincodeTextField.setBounds(430, 595, 200, 26);
        pincodeTextField.setFont(new Font("Times new Roman", Font.BOLD,14));
        pincodeTextField.setForeground(Color.DARK_GRAY);
               
        
        saveAddressButton.setBounds(360, 645, 100, 30);

        Panel3.add(doorNoLabel);
        Panel3.add(streetNameLabel);
        Panel3.add(townLabel);
        Panel3.add(stateLabel);
        Panel3.add(districtLabel);
        Panel3.add(pincodeLabel);
        
        Panel3.add(doorNoTextField);
        Panel3.add(streetNameTextField);
        Panel3.add(townTextField);
        Panel3.add(districtTextField);
        Panel3.add(stateTextField);
        Panel3.add(pincodeTextField);
      
        
        Panel3.add(saveAddressButton);

        saveAddressButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
        saveAddressButton.setForeground(Color.BLACK);
        saveAddressButton.setBackground(Color.RED); 
        saveAddressButton.setEnabled(true);
        saveAddressButton.setBorder(BorderFactory.createLineBorder(Color.orange, 4)); // Add border
    
        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQFUL7MZs6kxlQ/feedshare-shrink_800/0/1700679489037?e=1703721600&v=beta&t=Q_SEzO4-vC4zC7C7rKW4SJvIpeAe7GDN-fkOe04DT0g");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel4 = new JLabel(imageIcon);
            imageLabel4.setBounds(17, 0, 800, 380);
            Panel3.add(imageLabel4);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

          
        add(Panel3);
        saveAddressButton.addActionListener(this);
        setVisible(true);
        
    }
    
    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveAddressButton)
        {
            // Code for login functionality after successful sign-up
            String doorno = doorNoTextField.getText();
            String streetname = streetNameTextField.getText();
            String town = townTextField.getText();
            String district = districtTextField.getText();
            String state = stateTextField.getText();
            String pincode = pincodeTextField.getText(); 
            
            // Implement login logic here after user signs up
            // Example: Check credentials against a database after signup
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Login_2 (doorno, streetname, town, district, state, pincode) VALUES ( ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, doorno);
                stmt.setString(2, streetname);
                stmt.setString(3, town);
                stmt.setString(4, district);
                stmt.setString(5, state);
                stmt.setString(6, pincode);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Address Saved Successfully!");
                    System.out.println("Address Detail(s) was inserted successfully!");
                    saved = true;
                    saveAddressButton.setEnabled(true); // Disable sign-up button after successful sign-up
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


public class Address{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new AddressForm();
        });
    }  
}