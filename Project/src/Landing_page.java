//import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Product {

    private String id;
    private String name;
    private String category;
    private String description;
    private double price;
    private String imageURL;
    private String imageURL2;
    private String imageURL3;

    Product(String id, String name, String category, String description, double price, String imageURL, String imageURL2, String imageURL3) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
        this.imageURL2 = imageURL2;
        this.imageURL3 = imageURL3;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getCategory() {
        return category;
    }

    String getDescription() {
        return description;
    }

    double getPrice() {
        return price;
    }

    String getImageURL() {
        return imageURL;
    }

    String getImageURL2() {
        return imageURL2;
    }

    String getImageURL3() {
        return imageURL3;
    }
}

class ProductDetailsGUI extends JFrame {

    Color customColor1 = new Color(0xEFA965); // Hexadecimal value for Orange

    ProductDetailsGUI(Product product) {
        setTitle("Product Details");
        setSize(750, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel(new FlowLayout());

        try {
            URL imageURL1 = new URL(product.getImageURL());
            URL imageURL2 = new URL(product.getImageURL2());
            URL imageURL3 = new URL(product.getImageURL3());

            BufferedImage img1 = ImageIO.read(imageURL1);
            BufferedImage img2 = ImageIO.read(imageURL2);
            BufferedImage img3 = ImageIO.read(imageURL3);

            JLabel imageLabel1 = new JLabel(new ImageIcon(img1.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
            JLabel imageLabel_l1 = new JLabel(new ImageIcon(img2.getScaledInstance(180, 175, Image.SCALE_SMOOTH)));
            JLabel imageLabel_l2 = new JLabel(new ImageIcon(img3.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));

            imagePanel.add(imageLabel1);
            imagePanel.add(imageLabel_l1);
            imagePanel.add(imageLabel_l2);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        JPanel productInfoPanel = new JPanel();
        productInfoPanel.setLayout(new BoxLayout(productInfoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("           Name: " + product.getName());

        JLabel space1 = new JLabel("                           ");
        JLabel space2 = new JLabel("                           ");
        JLabel space3 = new JLabel("                           ");
        JLabel space4 = new JLabel("                           ");
        JLabel space5 = new JLabel("                           ");

        JLabel categoryLabel = new JLabel("           Category: " + product.getCategory());

        JLabel priceLabel = new JLabel("           Price: " + product.getPrice());

        String fullDescription = product.getDescription();
        int halfLength = fullDescription.length() / 2;
        String part1 = fullDescription.substring(0, halfLength);
        String part2 = fullDescription.substring(halfLength);
        JLabel descriptionLabel1 = new JLabel("           Description: " + part1);
        JLabel descriptionLabel2 = new JLabel("                                    " + part2);

        JButton addToCartButton = new JButton("                                                                     ADD TO CART                                                                                    ");
        // addToCartButton.setBounds(500, 500, 60, 30);
        addToCartButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
        addToCartButton.setForeground(Color.BLACK);
        addToCartButton.setBackground(customColor1);
        addToCartButton.setEnabled(true);
        addToCartButton.setBorder(BorderFactory.createLineBorder(Color.red, 3)); // Add border

        addToCartButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, product.getName() + " added to cart!");
        });

        productInfoPanel.add(space1);
        productInfoPanel.add(nameLabel);
        productInfoPanel.add(space2);

        productInfoPanel.add(categoryLabel);
        productInfoPanel.add(space3);

        productInfoPanel.add(priceLabel);
        productInfoPanel.add(space4);

        productInfoPanel.add(descriptionLabel1);
        productInfoPanel.add(descriptionLabel2);
        productInfoPanel.add(space5);

        productInfoPanel.add(addToCartButton);

        detailsPanel.add(imagePanel, BorderLayout.NORTH);
        detailsPanel.add(productInfoPanel, BorderLayout.CENTER);

        getContentPane().add(detailsPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class EcommerceAppGUI extends JFrame { //implements ActionListener{

    JPanel Panel4, Panel5, Panel6, Panel7, Panel8;

    private JLabel slideImageLabel1, slideImageLabel2, slideImageLabel3, slideImageLabel4;
    private Timer slideshowTimer; // Timer for the slideshow
    private int currentSlide = 0;
    private JLabel imageLabel_l1, imageLabel_l2, imageLabel_l4, imageLabel_l5, imageLabel_l6, imageLabel_l7, imageLabel_l8;

    Color customColor1 = new Color(0xEFA965); // Hexadecimal value for Orange
    Color customColor2 = new Color(0x382399); // Dark light blue

    private List<Product> products1;
    private List<Product> cart1;
    private int currentPage;

    private List<Product> products2;
    private List<Product> cart2;

    private List<Product> products3;
    private List<Product> cart3;

    private List<Product> products4;
    private List<Product> cart4;

    private List<Product> products5;
    private List<Product> cart5;

    EcommerceAppGUI() {

        setTitle("TROVE CART - LANDING PAGE");
        setSize(820, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the application logo as the icon for the title bar
        ImageIcon logoIcon = null; // Declare logoIcon variable
        // Load image from URL
        BufferedImage logoImage = null;
        try {
            URL imageURL = new URL("https://media.licdn.com/dms/image/D5622AQGetGGktFdvAQ/feedshare-shrink_800/0/1701203043604?e=1704326400&v=beta&t=P-t-PRXgNyAcXURb4KI7OhDkljUE5E3dQ157KzZdxsg"); // Replace with your image URL
            logoImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (logoImage != null) {
            logoIcon = new ImageIcon(logoImage);
            setIconImage(logoIcon.getImage());
        }

        Panel4 = new JPanel(null); // Using null layout
        Panel4.setPreferredSize(new Dimension(820, 1200)); // Set the preferred size of the main panel to enable scrolling
        Panel4.setBackground(Color.black);

        Panel5 = new JPanel(null); // Using null layout
        Panel5.setBackground(Color.black);
        Panel5.setPreferredSize(new Dimension(820, 1200));

        Panel6 = new JPanel(null); // Using null layout
        Panel6.setBackground(Color.black);
        Panel6.setPreferredSize(new Dimension(820, 1200));

        Panel7 = new JPanel(null); // Using null layout
        Panel7.setBackground(Color.black);
        Panel7.setPreferredSize(new Dimension(820, 1200));

        ImageIcon logoIcon2 = null; // Declare logoIcon2 variable
        // Load image from URL
        BufferedImage logoImage2 = null;
        try {
            URL imageURL = new URL("https://media.licdn.com/dms/image/D5622AQGetGGktFdvAQ/feedshare-shrink_800/0/1701203043604?e=1704326400&v=beta&t=P-t-PRXgNyAcXURb4KI7OhDkljUE5E3dQ157KzZdxsg"); // Replace with your image URL
            logoImage2 = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (logoImage2 != null) {
            logoIcon2 = new ImageIcon(logoImage2);
            setIconImage(logoIcon2.getImage());
        }

        ImageIcon logoIcon3 = null; // Declare logoIcon3 variable
        // Load image from URL
        BufferedImage logoImage3 = null;
        try {
            URL imageURL = new URL("https://media.licdn.com/dms/image/D5622AQGetGGktFdvAQ/feedshare-shrink_800/0/1701203043604?e=1704326400&v=beta&t=P-t-PRXgNyAcXURb4KI7OhDkljUE5E3dQ157KzZdxsg"); // Replace with your image URL
            logoImage3 = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (logoImage3 != null) {
            logoIcon3 = new ImageIcon(logoImage3);
            setIconImage(logoIcon3.getImage());
        }

        ImageIcon logoIcon4 = null; // Declare logoIcon4 variable
        // Load image from URL
        BufferedImage logoImage4 = null;
        try {
            URL imageURL = new URL("https://media.licdn.com/dms/image/D5622AQGetGGktFdvAQ/feedshare-shrink_800/0/1701203043604?e=1704326400&v=beta&t=P-t-PRXgNyAcXURb4KI7OhDkljUE5E3dQ157KzZdxsg"); // Replace with your image URL
            logoImage4 = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (logoImage4 != null) {
            logoIcon4 = new ImageIcon(logoImage4);
            setIconImage(logoIcon4.getImage());
        }

        // Creating a bar-like panel for the top components
        JPanel topPanel1 = new JPanel();
        topPanel1.setBackground(Color.LIGHT_GRAY);
        topPanel1.setBounds(0, 60, 820, 3); // Adjust the bounds as needed
        add(topPanel1);

        JPanel topPanel2 = new JPanel();
        topPanel2.setBackground(Color.LIGHT_GRAY);
        topPanel2.setBounds(0, 440, 820, 3); // Adjust the bounds as needed
        Panel4.add(topPanel2);

        // MOVING TEXT FOR CATEGORY 
        JLabel dealsLabel1 = new JLabel();
        dealsLabel1.setForeground(customColor1); // Set text color
        dealsLabel1.setFont(new Font("Times new Roman", Font.BOLD, 18)); // Increase font size
        dealsLabel1.setBounds(250, 80, 500, 20);
        Panel4.add(dealsLabel1, BorderLayout.CENTER);
        // "Choose Your Category !!"

        String text1 = "<<<     Choose Your Category !!     >>>                    ";
        int repeatCount1 = 50; // Set the number of times the typewriter effect should repeat
        Timer typeWriterTimer1 = new Timer(150 /*{ Text Speed }*/, new ActionListener() {
            int index = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < repeatCount1) {
                    if (index <= text1.length()) {
                        dealsLabel1.setText(text1.substring(0, index));
                        index++;
                    } else {
                        index = 0;
                        count++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        typeWriterTimer1.start();

        /* JPanel topPanel3 = new JPanel();
        topPanel3.setBackground(Color.DARK_GRAY);
        topPanel3.setBounds(26, 100, 750, 90); // Adjust the bounds as needed
        add(topPanel3); */
        /// MOVING TEXT TOP DEALS 1
        JLabel dealsLabel2 = new JLabel();
        dealsLabel2.setForeground(customColor1); // Set text color
        dealsLabel2.setFont(new Font("Times new Roman", Font.BOLD, 18)); // Increase font size
        dealsLabel2.setBounds(250, 455, 500, 20);
        Panel4.add(dealsLabel2, BorderLayout.CENTER);

        String text2 = "<<<     Top Deals For You !!     >>>                    ";
        int repeatCount2 = 50; // Set the number of times the typewriter effect should repeat
        Timer typeWriterTimer2 = new Timer(150 /*{ Text Speed }*/, new ActionListener() {
            int index = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < repeatCount2) {
                    if (index <= text2.length()) {
                        dealsLabel2.setText(text2.substring(0, index));
                        index++;
                    } else {
                        index = 0;
                        count++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        typeWriterTimer2.start();

        // MOVING TEXT FOR Deals 2
        JLabel dealsLabel3 = new JLabel();
        dealsLabel3.setForeground(customColor1); // Set text color
        dealsLabel3.setFont(new Font("Times new Roman", Font.BOLD, 18)); // Increase font size
        dealsLabel3.setBounds(250, 75, 500, 20);
        Panel5.add(dealsLabel3);

        String text3 = "<<<     TOP DEALS FOR YOU !!     >>>                    ";
        int repeatCount3 = 50; // Set the number of times the typewriter effect should repeat
        Timer typeWriterTimer3 = new Timer(150 /*{ Text Speed }*/, new ActionListener() {
            int index = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < repeatCount3) {
                    if (index <= text3.length()) {
                        dealsLabel3.setText(text3.substring(0, index));
                        index++;
                    } else {
                        index = 0;
                        count++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        typeWriterTimer3.start();

        // MOVING TEXT FOR DEALS 3
        JLabel dealsLabel4 = new JLabel();
        dealsLabel4.setForeground(customColor1); // Set text color
        dealsLabel4.setFont(new Font("Times new Roman", Font.BOLD, 18)); // Increase font size
        dealsLabel4.setBounds(250, 75, 500, 20);
        Panel6.add(dealsLabel4);

        String text4 = "<<<     TOP DEALS FOR YOU !!     >>>                    ";
        int repeatCount4 = 50; // Set the number of times the typewriter effect should repeat
        Timer typeWriterTimer4 = new Timer(150 /*{ Text Speed }*/, new ActionListener() {
            int index = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < repeatCount4) {
                    if (index <= text4.length()) {
                        dealsLabel4.setText(text4.substring(0, index));
                        index++;
                    } else {
                        index = 0;
                        count++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        typeWriterTimer4.start();

        // MOVING TEXT FOR DEALS 4
        JLabel dealsLabel5 = new JLabel();
        dealsLabel5.setForeground(customColor1); // Set text color
        dealsLabel5.setFont(new Font("Times new Roman", Font.BOLD, 18)); // Increase font size
        dealsLabel5.setBounds(250, 75, 500, 20);
        Panel7.add(dealsLabel5);

        String text5 = "<<<     TOP DEALS FOR YOU !!     >>>                    ";
        int repeatCount5 = 50; // Set the number of times the typewriter effect should repeat
        Timer typeWriterTimer5 = new Timer(150 /*{ Text Speed }*/, new ActionListener() {
            int index = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < repeatCount5) {
                    if (index <= text5.length()) {
                        dealsLabel5.setText(text5.substring(0, index));
                        index++;
                    } else {
                        index = 0;
                        count++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        typeWriterTimer5.start();

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQEZq4sBi4QkMA/feedshare-shrink_800/0/1701597896169?e=1704326400&v=beta&t=V44dI_6pk8pC1rRNAJjdA0EL3-Iph1E0rMNCiX_nRMU");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l1 = new JLabel(imageIcon);
            imageLabel_l1.setBounds(80, 115, 70, 90);
            Panel4.add(imageLabel_l1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQF2VsdNjX490Q/feedshare-shrink_800/0/1701276420508?e=1704326400&v=beta&t=KeHnQHXR86Pv8uUiDdOi-xHRB_kRKaUN6CDGO9uLlnc");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l2 = new JLabel(imageIcon);
            imageLabel_l2.setBounds(180, 115, 70, 90);
            Panel4.add(imageLabel_l2);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQHEJFYhqRpWsw/feedshare-shrink_800/0/1701597899346?e=1704326400&v=beta&t=Ks8KZZ7NVA8Zo4RZTSPHeRQIZzV4KIusx9h-zXeipeU");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l4 = new JLabel(imageIcon);
            imageLabel_l4.setBounds(280, 115, 70, 90);
            Panel4.add(imageLabel_l4);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQFA-LEcfSri2Q/feedshare-shrink_800/0/1701597900778?e=1704326400&v=beta&t=-hJIBngZs-0mYLBrWiFFD4AEiy_HPyL3-wPOuNsZFIg");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l5 = new JLabel(imageIcon);
            imageLabel_l5.setBounds(380, 115, 70, 90);
            Panel4.add(imageLabel_l5);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQERn1zkWG0OuQ/feedshare-shrink_800/0/1701597898898?e=1704326400&v=beta&t=JDh8RHGUfx59VDCrWp2Nu-FdUp51DPKTXhtMlcky_KM");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l6 = new JLabel(imageIcon);
            imageLabel_l6.setBounds(480, 115, 70, 90);
            Panel4.add(imageLabel_l6);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQFR0hfyFWK9Uw/feedshare-shrink_800/0/1701597899240?e=1704326400&v=beta&t=hxOss1zdrtaiweJ3A0ean81Ewc-5oMGAckaG-8CvcqI");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l7 = new JLabel(imageIcon);
            imageLabel_l7.setBounds(580, 115, 70, 90);
            Panel4.add(imageLabel_l7);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        try {
            URL imageUrl = new URL("https://media.licdn.com/dms/image/D5622AQFX__AUarYI1w/feedshare-shrink_800/0/1701597902340?e=1704326400&v=beta&t=G-jhqFb0vlDl0Iijdx34ZqS1Zi2fKf5tTnnSquXzAlQ");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel_l8 = new JLabel(imageIcon);
            imageLabel_l8.setBounds(680, 115, 70, 90);
            Panel4.add(imageLabel_l8);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + e.getMessage());
        }

        // Add slide show gallery
        startSlideshow(); // Start the slideshow

        // Left arrow button
        JButton leftArrowButton = new JButton("<");
        leftArrowButton.setBounds(15, 325, 25, 25);
        leftArrowButton.setFont(new Font("Calibra", Font.BOLD, 15));
        leftArrowButton.setEnabled(true);
        leftArrowButton.setBackground(customColor2);
        leftArrowButton.setForeground(Color.black);
        leftArrowButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); // Add border

        leftArrowButton.addActionListener(e -> changeSlide(false)); // Change to the previous slide
        Panel4.add(leftArrowButton);

        // Right arrow button
        JButton rightArrowButton = new JButton(">");
        rightArrowButton.setBounds(770, 325, 25, 25);
        rightArrowButton.setFont(new Font("Calibra", Font.BOLD, 14));
        //rightArrowButton.setForeground(Color.BLACK);
        rightArrowButton.setBackground(customColor2);
        rightArrowButton.setForeground(Color.black);
        rightArrowButton.setEnabled(true);
        rightArrowButton.setBorder(BorderFactory.createLineBorder(Color.black, 4)); // Add border
        rightArrowButton.addActionListener(e -> changeSlide(true)); // Change to the next slide
        Panel4.add(rightArrowButton);

        // Application Logo Image (Placeholder) - Added near the title bar
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 10, 100, 50); // Adjust the bounds as needed
        add(logoLabel);

        // My Account Text with Emoji
        JLabel myAccountLabel = new JLabel("My Account 👤"); // Emoji: 👤
        myAccountLabel.setBounds(620, 10, 82, 30); // Adjust the bounds as needed
        myAccountLabel.setForeground(Color.white);
        myAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Account");
                // Add your action here, like opening the account settings

                // Visual feedback
                myAccountLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myAccountLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(myAccountLabel);

        // My Cart Text with Emoji
        JLabel myCartLabel = new JLabel("My Cart 🛒"); // Emoji: 🛒
        myCartLabel.setBounds(720, 10, 60, 30); // Adjust the bounds as needed
        myCartLabel.setForeground(Color.WHITE);
        myCartLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myCartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Cart
                System.out.println("Clicked on My Cart");
                // Add your action here, like opening the cart

                // Visual feedback
                myCartLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myCartLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(myCartLabel);

        // Application Logo Image (Placeholder) - Added near the title bar
        JLabel logoLabel2 = new JLabel(logoIcon2);
        logoLabel2.setBounds(0, 10, 100, 50); // Adjust the bounds as needed
        Panel5.add(logoLabel2);

        // My Account Text with Emoji
        JLabel myAccountLabel2 = new JLabel("My Account 👤"); // Emoji: 👤
        myAccountLabel2.setBounds(620, 10, 82, 30); // Adjust the bounds as needed
        myAccountLabel2.setForeground(Color.white);
        myAccountLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myAccountLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Account");
                // Add your action here, like opening the account settings

                // Visual feedback
                myAccountLabel2.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myAccountLabel2.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel5.add(myAccountLabel2);

        // My Cart Text with Emoji
        JLabel myCartLabel2 = new JLabel("My Cart 🛒"); // Emoji: 🛒
        myCartLabel2.setBounds(720, 10, 60, 30); // Adjust the bounds as needed
        myCartLabel2.setForeground(Color.WHITE);
        myCartLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myCartLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Cart
                System.out.println("Clicked on My Cart");
                // Add your action here, like opening the cart

                // Visual feedback
                myCartLabel2.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myCartLabel2.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel5.add(myCartLabel2);

        // Search Bar
        JTextField searchField2 = new JTextField();
        searchField2.setBounds(140, 15, 380, 30); // Adjust the bounds as needed
        searchField2.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchField2.setForeground(Color.BLACK); // Set the text color
        searchField2.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Set border color (optional)
        JButton searchButton2 = new JButton("🔍");
        searchButton2.setBounds(520, 15, 47, 30); // Adjust the bounds as needed
        searchButton2.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchButton2.setForeground(Color.BLACK); // Set the text color
        // searchButton2.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        // Adding focus listener to hide/show text
        searchField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField2.getText().equals("Search in Trove")) {
                    searchField2.setText("");
                    searchField2.setForeground(Color.BLACK); // Change text color to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField2.getText().isEmpty()) {
                    searchField2.setForeground(Color.GRAY); // Set text color back to gray
                    searchField2.setText("Search in Trove");
                }
            }
        });

        Panel5.add(searchField2);
        Panel5.add(searchButton2);

        // Application Logo Image (Placeholder) - Added near the title bar
        JLabel logoLabel3 = new JLabel(logoIcon3);
        logoLabel3.setBounds(0, 10, 100, 50); // Adjust the bounds as needed
        Panel6.add(logoLabel3);

        // My Account Text with Emoji
        JLabel myAccountLabel3 = new JLabel("My Account 👤"); // Emoji: 👤
        myAccountLabel3.setBounds(620, 10, 82, 30); // Adjust the bounds as needed
        myAccountLabel3.setForeground(Color.white);
        myAccountLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myAccountLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Account");
                // Add your action here, like opening the account settings

                // Visual feedback
                myAccountLabel3.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myAccountLabel3.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel6.add(myAccountLabel3);

        // My Cart Text with Emoji
        JLabel myCartLabel3 = new JLabel("My Cart 🛒"); // Emoji: 🛒
        myCartLabel3.setBounds(720, 10, 60, 30); // Adjust the bounds as needed
        myCartLabel3.setForeground(Color.WHITE);
        myCartLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myCartLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Cart
                System.out.println("Clicked on My Cart");
                // Add your action here, like opening the cart

                // Visual feedback
                myCartLabel3.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myCartLabel3.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel6.add(myCartLabel3);

        // Search Bar
        JTextField searchField3 = new JTextField();
        searchField3.setBounds(140, 15, 380, 30); // Adjust the bounds as needed
        searchField3.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchField3.setForeground(Color.BLACK); // Set the text color
        searchField3.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Set border color (optional)
        JButton searchButton3 = new JButton("🔍");
        searchButton3.setBounds(520, 15, 47, 30); // Adjust the bounds as needed
        searchButton3.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchButton3.setForeground(Color.BLACK); // Set the text color
        // searchButton3.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        // Adding focus listener to hide/show text
        searchField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField3.getText().equals("Search in Trove")) {
                    searchField3.setText("");
                    searchField3.setForeground(Color.BLACK); // Change text color to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField3.getText().isEmpty()) {
                    searchField3.setForeground(Color.GRAY); // Set text color back to gray
                    searchField3.setText("Search in Trove");
                }
            }
        });

        Panel6.add(searchField3);
        Panel6.add(searchButton3);

        // Application Logo Image (Placeholder) - Added near the title bar
        JLabel logoLabel4 = new JLabel(logoIcon4);
        logoLabel4.setBounds(0, 10, 100, 50); // Adjust the bounds as needed
        Panel7.add(logoLabel4);

        // My Account Text with Emoji
        JLabel myAccountLabel4 = new JLabel("My Account 👤"); // Emoji: 👤
        myAccountLabel4.setBounds(620, 10, 82, 30); // Adjust the bounds as needed
        myAccountLabel4.setForeground(Color.white);
        myAccountLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myAccountLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Account");
                // Add your action here, like opening the account settings

                // Visual feedback
                myAccountLabel4.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myAccountLabel4.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel7.add(myAccountLabel4);

        // My Cart Text with Emoji
        JLabel myCartLabel4 = new JLabel("My Cart 🛒"); // Emoji: 🛒
        myCartLabel4.setBounds(720, 10, 60, 30); // Adjust the bounds as needed
        myCartLabel4.setForeground(Color.WHITE);
        myCartLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myCartLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Cart
                System.out.println("Clicked on My Cart");
                // Add your action here, like opening the cart
                // Visual feedback
                myCartLabel4.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> myCartLabel4.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel7.add(myCartLabel4);

        // Search Bar
        JTextField searchField4 = new JTextField();
        searchField4.setBounds(140, 15, 380, 30); // Adjust the bounds as needed
        searchField4.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchField4.setForeground(Color.BLACK); // Set the text color
        searchField4.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Set border color (optional)
        JButton searchButton4 = new JButton("🔍");
        searchButton4.setBounds(520, 15, 47, 30); // Adjust the bounds as needed
        searchButton4.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchButton4.setForeground(Color.BLACK); // Set the text color
        // searchButton4.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        // Adding focus listener to hide/show text
        searchField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField4.getText().equals("Search in Trove")) {
                    searchField4.setText("");
                    searchField4.setForeground(Color.BLACK); // Change text color to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField4.getText().isEmpty()) {
                    searchField4.setForeground(Color.GRAY); // Set text color back to gray
                    searchField4.setText("Search in Trove");
                }
            }
        });

        Panel7.add(searchField4);
        Panel7.add(searchButton4);

        // Category Grocery Text with Emoji
        JLabel groceryLabel = new JLabel("Grocery 🥕");
        groceryLabel.setBounds(85, 200, 62, 30); // Adjust the bounds as needed
        groceryLabel.setForeground(Color.white);
        groceryLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        groceryLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Grocery");
                // Add your action here, like opening the account settings

                // Visual feedback
                groceryLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> groceryLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(groceryLabel);

        // Category Mobiles Text with Emoji
        JLabel mobileLabel = new JLabel("Mobile 📱");
        mobileLabel.setBounds(192, 200, 54, 30); // Adjust the bounds as needed
        mobileLabel.setForeground(Color.white);
        mobileLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mobileLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Mobiles");
                // Add your action here, like opening the account settings

                // Visual feedback
                mobileLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> mobileLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(mobileLabel);

        // Category Mens Fashion Text with Emoji
        JLabel mensFashionLabel = new JLabel("Men 👕");
        mensFashionLabel.setBounds(297, 200, 40, 30); // Adjust the bounds as needed
        mensFashionLabel.setForeground(Color.white);
        mensFashionLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mensFashionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Mens Fashion");
                // Add your action here, like opening the account settings

                // Visual feedback
                mensFashionLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> mensFashionLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(mensFashionLabel);

        // Category Mens Fashion Text with Emoji
        JLabel womensFashionLabel = new JLabel("Womens 👗");
        womensFashionLabel.setBounds(385, 200, 70, 30); // Adjust the bounds as needed
        womensFashionLabel.setForeground(Color.white);
        womensFashionLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        womensFashionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Womens Fashion");
                // Add your action here, like opening the account settings

                // Visual feedback
                womensFashionLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> womensFashionLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(womensFashionLabel);

        // Category Mens Fashion Text with Emoji
        JLabel electronicLabel = new JLabel("Electronics 🔌");
        electronicLabel.setBounds(480, 200, 80, 30); // Adjust the bounds as needed
        electronicLabel.setForeground(Color.white);
        electronicLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        electronicLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Electronics");
                // Add your action here, like opening the account settings

                // Visual feedback
                electronicLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> electronicLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(electronicLabel);

        // Category Mens Fashion Text with Emoji
        JLabel beautyLabel = new JLabel("Beauty ✨"); //Beauty
        beautyLabel.setBounds(588, 200, 70, 30); // Adjust the bounds as needed
        beautyLabel.setForeground(Color.white);
        beautyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        beautyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Beauty");
                // Add your action here, like opening the account settings

                // Visual feedback
                beautyLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> beautyLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(beautyLabel);

        // Category Mens Fashion Text with Emoji
        JLabel kidsLabel = new JLabel("Kids 🎮"); //Kids
        kidsLabel.setBounds(690, 200, 70, 30); // Adjust the bounds as needed
        kidsLabel.setForeground(Color.white);
        kidsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kidsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Perform action for My Account
                System.out.println("Clicked on My Kids");
                // Add your action here, like opening the account settings

                // Visual feedback
                kidsLabel.setForeground(customColor1); // Change color momentarily
                Timer timer = new Timer(200, actionEvent -> kidsLabel.setForeground(Color.white));
                timer.setRepeats(false);
                timer.start();
            }
        });
        Panel4.add(kidsLabel);

        // Search Bar
        JTextField searchField = new JTextField();
        searchField.setBounds(140, 15, 380, 30); // Adjust the bounds as needed
        searchField.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchField.setForeground(Color.BLACK); // Set the text color
        searchField.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Set border color (optional)
        JButton searchButton = new JButton("🔍");
        searchButton.setBounds(520, 15, 47, 30); // Adjust the bounds as needed
        searchButton.setBackground(Color.LIGHT_GRAY); // Set the background color
        searchButton.setForeground(Color.BLACK); // Set the text color
        // searchButton.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        // Adding focus listener to hide/show text
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search in Trove")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK); // Change text color to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(Color.GRAY); // Set text color back to gray
                    searchField.setText("Search in Trove");
                }
            }
        });

        Panel4.add(searchField);
        Panel4.add(searchButton);

// **************** PRODUCTS LISTING METHODS STARTS ************************   
        // Define the list of product IDs you want to fetch
        List<String> specificProductIDs1 = new ArrayList<>();
        specificProductIDs1.add("1047");
        specificProductIDs1.add("1014");
        //specificProductIDs1.add("1004");

        // Add more product IDs as needed
        // Fetch products based on specific IDs
        products1 = fetchProductsFromDatabase(specificProductIDs1);
        // Rest of your code remains the same...
        cart1 = new ArrayList<>();

        JPanel productsPanel = new JPanel(new GridLayout(0 /*rows*/, 2 /*columns*/, 10 /*Horizontal space */, 10 /*Vertical space */)); // GridLayout for products
        productsPanel.setBackground(Color.black);
        productsPanel.setBounds(15, 490, 770, 155);

        displayProducts(productsPanel, currentPage);
        Panel4.add(productsPanel);
        getContentPane().add(Panel4, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JButton backButton = new JButton("Back");
        backButton.setBounds(290, 653, 100, 30);
        backButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(customColor1);
        backButton.setEnabled(true);
        backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        backButton.addActionListener(new BackButtonActionListener());
        Panel4.add(backButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(415, 653, 100, 30);
        nextButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBackground(customColor1);
        nextButton.setEnabled(true);
        nextButton.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

        nextButton.addActionListener(new NextButtonActionListener());
        Panel4.add(nextButton);

        currentPage = 0;

        add(Panel4);
        setVisible(true);

        // ************ PANEL 5 ********************   
        // Define the list of product IDs you want to fetch
        List<String> specificProductIDs2 = new ArrayList<>();
        specificProductIDs2.add("1068");
        specificProductIDs2.add("1069");
        specificProductIDs2.add("1070");
        specificProductIDs2.add("1071");
        specificProductIDs2.add("1072");
        specificProductIDs2.add("1067");
        // specificProductIDs2.add("1009");
        // specificProductIDs2.add("1009");

        // Add more product IDs as needed
        // Fetch products based on specific IDs
        products2 = fetchProductsFromDatabase2(specificProductIDs2);
        // Rest of your code remains the same...
        cart2 = new ArrayList<>();

        JPanel productsPanel2 = new JPanel(new GridLayout(0 /*rows*/, 2 /*columns*/, 5 /*Horizontal space */, 5 /*Vertical space */)); // GridLayout for products
        productsPanel2.setBackground(Color.black);
        productsPanel2.setBounds(25, 115, 770, 500);

        displayProducts2(productsPanel2, currentPage);
        Panel5.add(productsPanel2);
        // getContentPane().add(Panel5, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JButton backButton2 = new JButton("Back");
        backButton2.setBounds(290, 653, 100, 30);
        backButton2.setFont(new Font("Times new Roman", Font.BOLD, 16));
        backButton2.setForeground(Color.BLACK);
        backButton2.setBackground(customColor1);
        backButton2.setEnabled(true);
        backButton2.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        backButton2.addActionListener(new BackButton2ActionListener());
        Panel5.add(backButton2);

        JButton nextButton2 = new JButton("Next");
        nextButton2.setBounds(415, 653, 100, 30);
        nextButton2.setFont(new Font("Times new Roman", Font.BOLD, 16));
        nextButton2.setForeground(Color.BLACK);
        nextButton2.setBackground(customColor1);
        nextButton2.setEnabled(true);
        nextButton2.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

        nextButton2.addActionListener(new NextButton2ActionListener());
        Panel5.add(nextButton2);

        currentPage = 0;

        //add(Panel5);
        setVisible(true);

        // ************ PANEL 6 ********************   
        // Define the list of product IDs you want to fetch
        List<String> specificProductIDs3 = new ArrayList<>();
        specificProductIDs3.add("1050");
        specificProductIDs3.add("1026");
        specificProductIDs3.add("1036");
        specificProductIDs3.add("1071");
        specificProductIDs3.add("1064");
        specificProductIDs3.add("1059");
        // specificProductIDs2.add("1009");
        // specificProductIDs2.add("1009");

        // Add more product IDs as needed
        // Fetch products based on specific IDs
        products3 = fetchProductsFromDatabase3(specificProductIDs3);
        // Rest of your code remains the same...
        cart3 = new ArrayList<>();

        JPanel productsPanel3 = new JPanel(new GridLayout(0 /*rows*/, 2 /*columns*/, 5 /*Horizontal space */, 5 /*Vertical space */)); // GridLayout for products
        productsPanel3.setBackground(Color.black);
        productsPanel3.setBounds(25, 115, 770, 500);

        displayProducts3(productsPanel3, currentPage);
        Panel6.add(productsPanel3);
        // getContentPane().add(Panel6, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JButton backButton3 = new JButton("Back");
        backButton3.setBounds(290, 653, 100, 30);
        backButton3.setFont(new Font("Times new Roman", Font.BOLD, 16));
        backButton3.setForeground(Color.BLACK);
        backButton3.setBackground(customColor1);
        backButton3.setEnabled(true);
        backButton3.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        backButton3.addActionListener(new BackButton3ActionListener());
        Panel6.add(backButton3);

        JButton nextButton3 = new JButton("Next");
        nextButton3.setBounds(415, 653, 100, 30);
        nextButton3.setFont(new Font("Times new Roman", Font.BOLD, 16));
        nextButton3.setForeground(Color.BLACK);
        nextButton3.setBackground(customColor1);
        nextButton3.setEnabled(true);
        nextButton3.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

        nextButton3.addActionListener(new NextButton3ActionListener());
        Panel6.add(nextButton3);

        currentPage = 0;

        //add(Panel5);
        setVisible(true);

        // ************ PANEL 7 ********************   
        // Define the list of product IDs you want to fetch
        List<String> specificProductIDs4 = new ArrayList<>();
        specificProductIDs4.add("1048");
        specificProductIDs4.add("1064");
        specificProductIDs4.add("1041");
        specificProductIDs4.add("1065");
        specificProductIDs4.add("1035");
        specificProductIDs4.add("1038");
        // specificProductIDs4.add("1009");
        // specificProductIDs4.add("1009");

        // Add more product IDs as needed
        // Fetch products based on specific IDs
        products4 = fetchProductsFromDatabase4(specificProductIDs4);
        // Rest of your code remains the same...
        cart4 = new ArrayList<>();

        JPanel productsPanel4 = new JPanel(new GridLayout(0 /*rows*/, 2 /*columns*/, 5 /*Horizontal space */, 5 /*Vertical space */)); // GridLayout for products
        productsPanel4.setBackground(Color.black);
        productsPanel4.setBounds(25, 115, 770, 500);

        displayProducts4(productsPanel4, currentPage);
        Panel7.add(productsPanel4);
        // getContentPane().add(Panel6, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JButton backButton4 = new JButton("Back");
        backButton4.setBounds(290, 653, 100, 30);
        backButton4.setFont(new Font("Times new Roman", Font.BOLD, 16));
        backButton4.setForeground(Color.BLACK);
        backButton4.setBackground(customColor1);
        backButton4.setEnabled(true);
        backButton4.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); // Add border

        backButton4.addActionListener(new BackButton4ActionListener());
        Panel7.add(backButton4);

        JButton nextButton4 = new JButton("Next");
        nextButton4.setBounds(415, 653, 100, 30);
        nextButton4.setFont(new Font("Times new Roman", Font.BOLD, 16));
        nextButton4.setForeground(Color.BLACK);
        nextButton4.setBackground(customColor1);
        nextButton4.setEnabled(true);
        nextButton4.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

        nextButton4.addActionListener(new NextButton4ActionListener());
        Panel7.add(nextButton4);

        currentPage = 0;

        //add(Panel7);
        setVisible(true);

    }

    // Method to add a slideshow gallery
    private void startSlideshow() {
        try {
            URL slideImageURL1 = new URL("https://media.licdn.com/dms/image/D5622AQHXgTGMNzrLvg/feedshare-shrink_2048_1536/0/1701434309554?e=1704326400&v=beta&t=bAPn49mlFahyem2ixakR53mC2ZPLRlj0E6BoI3EfW-0");
            BufferedImage img1 = ImageIO.read(slideImageURL1);
            slideImageLabel1 = new JLabel(new ImageIcon(img1));
            slideImageLabel1.setBounds(0, 0, 740, 200);

            URL slideImageURL2 = new URL("https://media.licdn.com/dms/image/D5622AQHZXx2M7C1eGA/feedshare-shrink_2048_1536/0/1701434356871?e=1704326400&v=beta&t=k45mWB2L2M-X46RTNXpkeuxGp2exDO0XnFuHQ5lFzOc");
            BufferedImage img2 = ImageIO.read(slideImageURL2);
            slideImageLabel2 = new JLabel(new ImageIcon(img2));
            slideImageLabel2.setBounds(0, 0, 740, 200);

            URL slideImageURL3 = new URL("https://media.licdn.com/dms/image/D5622AQGydweHZ9xa8w/feedshare-shrink_2048_1536/0/1701434391473?e=1704326400&v=beta&t=m9DyL1Y90m-HcJzXcWlbxRRDscYUCvESX8TdR0xZvuo");
            BufferedImage img3 = ImageIO.read(slideImageURL3);
            slideImageLabel3 = new JLabel(new ImageIcon(img3));
            slideImageLabel3.setBounds(0, 0, 740, 200);

            URL slideImageURL4 = new URL("https://media.licdn.com/dms/image/D5622AQEcU84O0_erGw/feedshare-shrink_2048_1536/0/1701434419847?e=1704326400&v=beta&t=JPNqncW0YYjtRGrmRgS4wLvJTu4VxJilv5Jx5ZnWWE0");
            BufferedImage img4 = ImageIO.read(slideImageURL4);
            slideImageLabel4 = new JLabel(new ImageIcon(img4));
            slideImageLabel4.setBounds(0, 0, 740, 200);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading images from URL: " + e.getMessage());
        }

        slideImageLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add action for the first image (slideImageLabel1)
                System.out.println("Clicked on Electronics Banner!!");
                // Perform desired action here...
            }
        });
        slideImageLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add action for the first image (slideImageLabel1)
                System.out.println("Clicked on Beauty Products Banner!!");
                // Perform desired action here...
            }
        });
        slideImageLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add action for the first image (slideImageLabel1)
                System.out.println("Clicked on Mobiles banner!!");
                // Perform desired action here...
            }
        });

        slideImageLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add action for the first image (slideImageLabel1)
                System.out.println("Clicked on Mens Fashion Banner!!");
                // Perform desired action here...
            }
        });

        JPanel slideshowPanel = new JPanel();
        slideshowPanel.setLayout(null); // Set layout to null for manual positioning
        slideshowPanel.setBounds(35, 235, 740, 200);
        slideshowPanel.setBackground(Color.BLACK);

        slideshowPanel.add(slideImageLabel1);
        slideshowPanel.add(slideImageLabel2);
        slideshowPanel.add(slideImageLabel3);
        slideshowPanel.add(slideImageLabel4);

        Panel4.add(slideshowPanel);

        slideshowTimer = new Timer(1500, new ActionListener() {
            int counter = 0;

            public void actionPerformed(ActionEvent e) {
                if (counter % 4 == 0) {
                    slideImageLabel1.setVisible(true);
                    slideImageLabel2.setVisible(false);
                    slideImageLabel3.setVisible(false);
                    slideImageLabel4.setVisible(false);
                } else if (counter % 4 == 1) {
                    slideImageLabel1.setVisible(false);
                    slideImageLabel2.setVisible(true);
                    slideImageLabel3.setVisible(false);
                    slideImageLabel4.setVisible(false);
                } else if (counter % 4 == 2) {
                    slideImageLabel1.setVisible(false);
                    slideImageLabel2.setVisible(false);
                    slideImageLabel3.setVisible(true);
                    slideImageLabel4.setVisible(false);
                } else {
                    slideImageLabel1.setVisible(false);
                    slideImageLabel2.setVisible(false);
                    slideImageLabel3.setVisible(false);
                    slideImageLabel4.setVisible(true);
                }

                counter++;
            }
        });
        slideshowTimer.start(); // Start the slideshow timer
    }

    private void changeSlide(boolean forward) {
        switch (currentSlide) {
            case 0:
                slideImageLabel1.setVisible(false);
                break;
            case 1:
                slideImageLabel2.setVisible(false);
                break;
            case 2:
                slideImageLabel3.setVisible(false);
                break;
            case 3:
                slideImageLabel4.setVisible(false);
                break;
        }

        if (forward) {
            currentSlide = (currentSlide + 1) % 4; // Update the current slide index
        } else {
            currentSlide = (currentSlide - 1 + 4) % 4; // Update the current slide index
        }

        switch (currentSlide) {
            case 0:
                slideImageLabel1.setVisible(true);
                break;
            case 1:
                slideImageLabel2.setVisible(true);
                break;
            case 2:
                slideImageLabel3.setVisible(true);
                break;
            case 3:
                slideImageLabel4.setVisible(true);
                break;
        }
    }

// *************** FETCHING PRODUCTS IN PANEL 4 ******************    
    private List<Product> fetchProductsFromDatabase(List<String> productIDs1) {
        List<Product> productList1 = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234")) {
            // Creating a SQL query string with a WHERE clause to fetch products by IDs1
            String query = "SELECT * FROM Products_list WHERE id IN (";
            for (int i = 0; i < productIDs1.size(); i++) {
                query += "'" + productIDs1.get(i) + "'";
                if (i < productIDs1.size() - 1) {
                    query += ",";
                }
            }
            query += ")";

            try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String imageURL = resultSet.getString("imageURL");
                    String imageURL2 = resultSet.getString("imageURL2");
                    String imageURL3 = resultSet.getString("imageURL3");

                    Product product = new Product(id, name, category, description, price, imageURL, imageURL2, imageURL3);
                    productList1.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or error messages here
        }

        return productList1;
    }

    // ************** DISPLAYING PRODTS IN PANEL 4 ***********************
    private void displayProducts(JPanel productsPanel, int page) {

        for (Product product : products1) {
            JPanel productPanel = new JPanel(new BorderLayout());
            productPanel.setLayout(null); // Setting null layout
            try {
                URL imageURL = new URL(product.getImageURL());
                BufferedImage img = ImageIO.read(imageURL);
                JLabel imageLabel = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                imageLabel.setBounds(10, 10, 100, 100); // x, y, width, height

                productPanel.add(imageLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String fullName = product.getName();
            int halfLength = fullName.length() / 2;

            String firstName = fullName.substring(0, halfLength);
            String lastName = fullName.substring(halfLength);

            JTextArea detailsArea = new JTextArea(
                    "      \n       " + firstName + "   \n      " + lastName + " \n\n       Rs. " + product.getPrice() + "/-" + "\n\n\n      " + product.getDescription()
            );
            detailsArea.setFont(new Font("Times new roman", Font.BOLD, 15));
            detailsArea.setForeground(Color.BLACK);
            detailsArea.setEditable(false);
            detailsArea.setBounds(120, 10, 250, 130);
            detailsArea.setBackground(customColor1);
            productPanel.add(detailsArea);

            JButton viewProductButton = new JButton("View product");
            viewProductButton.setBounds(10, 112, 109, 30); // x, y, width, height
            viewProductButton.setFont(new Font("Times new Roman", Font.BOLD, 16));
            viewProductButton.setForeground(Color.BLACK);
            viewProductButton.setBackground(customColor1);
            viewProductButton.setEnabled(true);
            viewProductButton.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

            viewProductButton.addActionListener(new ViewProductActionListener(product));
            productPanel.add(viewProductButton);

            productPanel.setBorder(BorderFactory.createLineBorder(customColor2, 4));
            productsPanel.add(productPanel);
        }
    }

    private class ViewProductActionListener implements ActionListener {

        private Product product;

        public ViewProductActionListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ProductDetailsGUI(product);
        }
    }

    private class NextButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // currentPage++;
            remove(Panel4);
            add(Panel5);
            setTitle("TROVE CART - TODAY DEALS PAGE 2");
            revalidate();
            repaint();
        }
    }

    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentPage > 0) {
                currentPage--;
                // refreshProductDisplay();
            }
        }
    }

// ************* FETCHING PRODUCTS FOR PANEL 5 ************************
    private List<Product> fetchProductsFromDatabase2(List<String> productIDs2) {
        List<Product> productList2 = new ArrayList<>();

        // Modify your SQL query as needed to fetch specific products
        // Here's an example:
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234")) {
            String query = "SELECT * FROM Products_list WHERE id IN (";
            for (int i = 0; i < productIDs2.size(); i++) {
                query += "'" + productIDs2.get(i) + "'";
                if (i < productIDs2.size() - 1) {
                    query += ",";
                }
            }
            query += ")";

            try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String imageURL = resultSet.getString("imageURL");
                    String imageURL2 = resultSet.getString("imageURL2");
                    String imageURL3 = resultSet.getString("imageURL3");

                    Product product = new Product(id, name, category, description, price, imageURL, imageURL2, imageURL3);
                    productList2.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or error messages here
        }

        return productList2;
    }

// **************** DISPLAYING PRODUCTS FOR PANEL 5 **************************
    private void displayProducts2(JPanel productsPanel2, int page) {
        for (Product product : products2) {
            JPanel productPanel2 = new JPanel(new BorderLayout());
            productPanel2.setLayout(null); // Setting null layout
            try {
                URL imageURL = new URL(product.getImageURL());
                BufferedImage img = ImageIO.read(imageURL);
                JLabel imageLabel = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                imageLabel.setBounds(10, 10, 100, 100); // x, y, width, height

                productPanel2.add(imageLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String fullName = product.getName();
            int halfLength = fullName.length() / 2;

            String firstName = fullName.substring(0, halfLength);
            String lastName = fullName.substring(halfLength);

            JTextArea detailsArea = new JTextArea(
                    "      \n       " + firstName + "   \n      " + lastName + " \n\n       Rs. " + product.getPrice() + "/-" + "\n\n\n      " + product.getDescription()
            );
            detailsArea.setFont(new Font("Times new roman", Font.BOLD, 15));
            detailsArea.setForeground(Color.BLACK);
            detailsArea.setEditable(false);
            detailsArea.setBounds(120, 10, 250, 130);
            detailsArea.setBackground(customColor1);
            productPanel2.add(detailsArea);

            JButton viewProductButton2 = new JButton("View product");
            viewProductButton2.setBounds(10, 112, 109, 30); // x, y, width, height
            viewProductButton2.setFont(new Font("Times new Roman", Font.BOLD, 16));
            viewProductButton2.setForeground(Color.BLACK);
            viewProductButton2.setBackground(customColor1);
            viewProductButton2.setEnabled(true);
            viewProductButton2.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

            viewProductButton2.addActionListener(new ViewProduct2ActionListener(product));
            productPanel2.add(viewProductButton2);

            productPanel2.setBorder(BorderFactory.createLineBorder(customColor2, 4));
            productsPanel2.add(productPanel2);
        }
    }

    private class ViewProduct2ActionListener implements ActionListener {

        private Product product;

        public ViewProduct2ActionListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ProductDetailsGUI(product);
        }
    }

    private class NextButton2ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // currentPage++;
            remove(Panel5);
            add(Panel6, BorderLayout.CENTER);
            setTitle("TROVE CART - TODAY DEALS PAGE 3");
            revalidate();
            repaint();
        }
    }

    private class BackButton2ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //if (currentPage > 0) {
            // currentPage--;
            remove(Panel5);
            add(Panel4);
            setTitle("TROVE CART - LANDING PAGE");
            revalidate();
            repaint();
        }
    }

// ************* FETCHING PRODUCTS FOR PANEL 6 ************************
    private List<Product> fetchProductsFromDatabase3(List<String> productIDs3) {
        List<Product> productList3 = new ArrayList<>();

        // Modify your SQL query as needed to fetch specific products
        // Here's an example:
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234")) {
            String query = "SELECT * FROM Products_list WHERE id IN (";
            for (int i = 0; i < productIDs3.size(); i++) {
                query += "'" + productIDs3.get(i) + "'";
                if (i < productIDs3.size() - 1) {
                    query += ",";
                }
            }
            query += ")";

            try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String imageURL = resultSet.getString("imageURL");
                    String imageURL2 = resultSet.getString("imageURL2");
                    String imageURL3 = resultSet.getString("imageURL3");

                    Product product = new Product(id, name, category, description, price, imageURL, imageURL2, imageURL3);
                    productList3.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or error messages here
        }

        return productList3;
    }

// **************** DISPLAYING PRODUCTS FOR PANEL 6 **************************
    private void displayProducts3(JPanel productsPanel3, int page) {
        for (Product product : products3) {
            JPanel productPanel3 = new JPanel(new BorderLayout());
            productPanel3.setLayout(null); // Setting null layout
            try {
                URL imageURL = new URL(product.getImageURL());
                BufferedImage img = ImageIO.read(imageURL);
                JLabel imageLabel = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                imageLabel.setBounds(10, 10, 100, 100); // x, y, width, height

                productPanel3.add(imageLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String fullName = product.getName();
            int halfLength = fullName.length() / 2;

            String firstName = fullName.substring(0, halfLength);
            String lastName = fullName.substring(halfLength);

            JTextArea detailsArea = new JTextArea(
                    "      \n       " + firstName + "   \n      " + lastName + " \n\n       Rs. " + product.getPrice() + "/-" + "\n\n\n      " + product.getDescription()
            );
            detailsArea.setFont(new Font("Times new roman", Font.BOLD, 15));
            detailsArea.setForeground(Color.BLACK);
            detailsArea.setEditable(false);
            detailsArea.setBounds(120, 10, 250, 130);
            detailsArea.setBackground(customColor1);
            productPanel3.add(detailsArea);

            JButton viewProductButton3 = new JButton("View product");
            viewProductButton3.setBounds(10, 112, 109, 30); // x, y, width, height
            viewProductButton3.setFont(new Font("Times new Roman", Font.BOLD, 16));
            viewProductButton3.setForeground(Color.BLACK);
            viewProductButton3.setBackground(customColor1);
            viewProductButton3.setEnabled(true);
            viewProductButton3.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

            viewProductButton3.addActionListener(new ViewProduct3ActionListener(product));
            productPanel3.add(viewProductButton3);

            productPanel3.setBorder(BorderFactory.createLineBorder(customColor2, 4));
            productsPanel3.add(productPanel3);
        }
    }

    private class ViewProduct3ActionListener implements ActionListener {

        private Product product;

        public ViewProduct3ActionListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ProductDetailsGUI(product);
        }
    }

    private class NextButton3ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //currentPage++;
            remove(Panel6);
            add(Panel7, BorderLayout.CENTER);
            setTitle("TROVE CART - TODAY DEALS PAGE 4");
            revalidate();
            repaint();
        }
    }

    private class BackButton3ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //if (currentPage > 0) {
            // currentPage--;
            remove(Panel6);
            add(Panel5);
            setTitle("TROVE CART - TODAY DEALS PAGE 2");
            revalidate();
            repaint();
        }
    }

    // ************* FETCHING PRODUCTS FOR PANEL 6 ************************
    private List<Product> fetchProductsFromDatabase4(List<String> productIDs4) {
        List<Product> productList4 = new ArrayList<>();

        // Modify your SQL query as needed to fetch specific products
        // Here's an example:
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234")) {
            String query = "SELECT * FROM Products_list WHERE id IN (";
            for (int i = 0; i < productIDs4.size(); i++) {
                query += "'" + productIDs4.get(i) + "'";
                if (i < productIDs4.size() - 1) {
                    query += ",";
                }
            }
            query += ")";

            try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String imageURL = resultSet.getString("imageURL");
                    String imageURL2 = resultSet.getString("imageURL2");
                    String imageURL3 = resultSet.getString("imageURL3");

                    Product product = new Product(id, name, category, description, price, imageURL, imageURL2, imageURL3);
                    productList4.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or error messages here
        }

        return productList4;
    }

// **************** DISPLAYING PRODUCTS FOR PANEL 7 **************************
    private void displayProducts4(JPanel productsPanel4, int page) {
        for (Product product : products4) {
            JPanel productPanel4 = new JPanel(new BorderLayout());
            productPanel4.setLayout(null); // Setting null layout
            try {
                URL imageURL = new URL(product.getImageURL());
                BufferedImage img = ImageIO.read(imageURL);
                JLabel imageLabel = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                imageLabel.setBounds(10, 10, 100, 100); // x, y, width, height

                productPanel4.add(imageLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String fullName = product.getName();
            int halfLength = fullName.length() / 2;

            String firstName = fullName.substring(0, halfLength);
            String lastName = fullName.substring(halfLength);

            JTextArea detailsArea = new JTextArea(
                    "      \n       " + firstName + "   \n      " + lastName + " \n\n       Rs. " + product.getPrice() + "/-" + "\n\n\n      " + product.getDescription()
            );
            detailsArea.setFont(new Font("Times new roman", Font.BOLD, 15));
            detailsArea.setForeground(Color.BLACK);
            detailsArea.setEditable(false);
            detailsArea.setBounds(120, 10, 250, 130);
            detailsArea.setBackground(customColor1);
            productPanel4.add(detailsArea);

            JButton viewProductButton4 = new JButton("View product");
            viewProductButton4.setBounds(10, 112, 109, 30); // x, y, width, height
            viewProductButton4.setFont(new Font("Times new Roman", Font.BOLD, 16));
            viewProductButton4.setForeground(Color.BLACK);
            viewProductButton4.setBackground(customColor1);
            viewProductButton4.setEnabled(true);
            viewProductButton4.setBorder(BorderFactory.createLineBorder(Color.red, 4)); // Add border

            viewProductButton4.addActionListener(new ViewProduct4ActionListener(product));
            productPanel4.add(viewProductButton4);

            productPanel4.setBorder(BorderFactory.createLineBorder(customColor2, 4));
            productsPanel4.add(productPanel4);
        }
    }

    private class ViewProduct4ActionListener implements ActionListener {

        private Product product;

        public ViewProduct4ActionListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ProductDetailsGUI(product);
        }
    }

    private class NextButton4ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //currentPage++;
            // remove(Panel6);
            // add(Panel7, BorderLayout.CENTER);
            // setTitle("TROVE CART - TODAY DEALS PAGE 4");
            // revalidate();
            // repaint();
        }
    }

    private class BackButton4ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //if (currentPage > 0) {
            // currentPage--;
            remove(Panel7);
            add(Panel6);
            setTitle("TROVE CART - TODAY DEALS PAGE 3");
            revalidate();
            repaint();
        }
    }

}

public class Landing_page {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EcommerceAppGUI();
        });
    }
}
