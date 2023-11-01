# Trove Cart

**Trove Cart** is a desktop e-commerce application built with **Java Swing** and **Apache NetBeans**. It provides a complete shopping experience â€” from user registration and login to browsing products by category, viewing product details, managing a cart, and completing checkout.

The application connects to an **Oracle Database** using the **OJDBC7** JDBC driver to store user credentials, addresses, and product catalog data in **MYSQL** Database.

---

## Features

### User Management
- **Welcome screen** with Login and Sign Up options
- **User registration** with validation (password match, 10-digit phone number, email format)
- **Address collection** during sign-up (door no., street, town, district, state, pincode)
- **Login authentication** against stored user records
- **Welcome email** sent to new users via JavaMail (SMTP)

### Shopping Experience
- **Landing page** with animated typewriter banners and promotional slideshow
- **7 product categories**: Grocery, Mobile, Men's Fashion, Women's Fashion, Electronics, Beauty, and Kids
- **Product listing** fetched dynamically from the database
- **Product detail view** with multiple product images, description, and price
- **Add to Cart** functionality
- **My Cart** window to review selected items
- **Search bar** to find products by name (full integrated version)
- **Top Deals** pages with Back / Next navigation
- **Payment panel** with card type selection (Visa, MasterCard, American Express)

### UI / UX
- Custom dark theme with orange (`#EFA965`) and purple (`#382399`) accent colors
- Category icons, slide banners, and product images
- Interactive hover effects on navigation labels
- Responsive panel-based navigation across 21+ screens (full version)

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 8 |
| GUI Framework | Java Swing (AWT) |
| IDE | Apache NetBeans |
| Database | Oracle Database |
| JDBC Driver | OJDBC7 (`ojdbc7.jar`) |
| Email | JavaMail API (`javax.mail.jar`) |
| Utilities | Apache Commons (`comm-2.0.jar`), Trident (`trident.jar`) |

---

## Project Structure

```
Trove Cart Java Swing Project/
â”‚
â”œâ”€â”€ Project/                          # Apache NetBeans project (main source)
â”‚   â”œâ”€â”€ src/
â”‚   â”‚   â”œâ”€â”€ Welcome.java              # Panel 0 â€“ Welcome / entry screen
â”‚   â”‚   â”œâ”€â”€ Login.java                # Panel 1 â€“ Login form
â”‚   â”‚   â”œâ”€â”€ Signup.java               # Panel 2 â€“ Registration form
â”‚   â”‚   â”œâ”€â”€ Address.java              # Panel 3 â€“ Address form
â”‚   â”‚   â””â”€â”€ Landing_page.java         # Panel 4+ â€“ E-commerce landing & deals
â”‚   â”œâ”€â”€ nbproject/                    # NetBeans project configuration
â”‚   â”œâ”€â”€ build.xml                     # Ant build script
â”‚   â””â”€â”€ dist/                         # Compiled JAR output
â”‚
â”œâ”€â”€ Final Cat files/                  # Integrated submission code (CAT exam)
â”‚   â”œâ”€â”€ Full main code.txt            # Complete single-file application
â”‚   â”œâ”€â”€ Full main code-1.txt          # Updated integrated version
â”‚   â””â”€â”€ addtocartb.txt                # Add-to-cart module reference
â”‚
â”œâ”€â”€ Attachments/                      # UI assets (images, GIFs, videos, banners)
â”‚   â”œâ”€â”€ Welcome page/
â”‚   â”œâ”€â”€ Login page/
â”‚   â”œâ”€â”€ Signup page/
â”‚   â”œâ”€â”€ Address page/
â”‚   â”œâ”€â”€ Logo/
â”‚   â”œâ”€â”€ Category icons/
â”‚   â”œâ”€â”€ Slide banners/
â”‚   â””â”€â”€ Product images/               # Product photos by category
â”‚
â”œâ”€â”€ JAR FILES/                        # External library dependencies
â”œâ”€â”€ Trove java report.docx            # Project documentation report
â””â”€â”€ README.md
```

> **Note:** The `Project/src/` folder contains **modular** screen files (each runnable independently). The `Final Cat files/` folder contains the **full integrated** application with all panels combined into a single class â€” this is the version submitted for evaluation.

---

## Application Flow

```
â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”
â”‚   Welcome   â”‚â”€â”€â”€â”€â–¶â”‚    Login    â”‚â”€â”€â”€â”€â–¶â”‚  Landing    â”‚
â”‚  (Panel 0)  â”‚     â”‚  (Panel 1)  â”‚     â”‚  (Panel 4)  â”‚
â””â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”˜     â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜     â””â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”˜
       â”‚                                         â”‚
       â–¼                                         â–¼
â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”
â”‚   Sign Up   â”‚â”€â”€â”€â”€â–¶â”‚   Address   â”‚â”€â”€â”€â”€â–¶â”‚   Login     â”‚
â”‚  (Panel 2)  â”‚     â”‚  (Panel 3)  â”‚     â”‚  (Panel 1)  â”‚
â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜     â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜     â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜

Landing Page (Panel 4)
    â”œâ”€â”€ Category browsing (Panels 8â€“21)
    â”œâ”€â”€ Top Deals pages (Panels 5â€“7)
    â”œâ”€â”€ Product details â†’ Add to Cart
    â”œâ”€â”€ My Cart â†’ Payment
    â””â”€â”€ Search products
```

### Panel Map (Full Integrated Version)

| Panels | Purpose |
|--------|---------|
| 0 | Welcome screen |
| 1 | Login |
| 2 | Sign Up |
| 3 | Address |
| 4 | Landing page (home) |
| 5â€“7 | Top Deals of the Day |
| 8â€“9 | Grocery category |
| 10â€“11 | Mobile category |
| 12â€“13 | Men's Fashion category |
| 14â€“15 | Women's Fashion category |
| 16â€“17 | Electronics category |
| 18â€“19 | Beauty category |
| 20â€“21 | Kids section |


## Prerequisites

Before running the project, ensure you have:

1. **JDK 8** or later installed
2. **Apache NetBeans IDE** (recommended) or any Java IDE with Ant support
3. **Oracle Database** installed and running locally
4. **Oracle SQL Developer** or similar tool to create tables and insert data
5. Required **JAR files** (available in the `JAR FILES/` folder):
   - `ojdbc7.jar` â€” Oracle JDBC driver
   - `javax.mail.jar` â€” Email support
   - `comm-2.0.jar` â€” Apache Commons utilities
   - `trident.jar` â€” UI animation library

---

## Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/Aditya-Ganesamoorthy/Trove-Cart-Java-Project.git
cd Trove-Cart-Java-Project
```

### 2. Set up Oracle Database

1. Start Oracle Database and ensure the listener is running on port `1521`.
2. Create the required tables (`Products_list`, `Signup_Details`, etc.) using the SQL examples above.
3. Insert product records with image URLs pointing to your product images (see `Attachments/Product images/` for reference assets).
4. Insert sample user data for testing login.

### 3. Configure database connection

Update the JDBC connection string in the source files to match your Oracle setup:

```java
Connection con = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:ORCL",  // host:port:SID
    "system",   // username
    "1234"      // password
);
```

> Replace `ORCL`, username, and password with your actual Oracle credentials.

### 4. Configure email (optional)

For the welcome email feature in `Signup.java`, update the SMTP credentials:

```java
final String emailUsername = "your-email@gmail.com";
final String emailPassword = "your-app-password";
```

Use a Gmail **App Password** if two-factor authentication is enabled.

### 5. Add JAR dependencies in NetBeans

1. Open the `Project/` folder in NetBeans.
2. Right-click the project â†’ **Properties** â†’ **Libraries**.
3. Add the following JARs from the `JAR FILES/` folder:
   - `ojdbc7.jar`
   - `javax.mail.jar`
   - `comm-2.0.jar`
   - `trident.jar`
4. Update the JAR paths in `nbproject/project.properties` if your local paths differ.

### 6. Build the project

In NetBeans: **Run** â†’ **Clean and Build Project** (or press `Shift + F11`).

Or from the command line:

```bash
cd Project
ant clean jar
```

---

## Running the Application

### Modular version (individual screens)

Each file in `Project/src/` has its own `main` method for testing screens independently:

| Class | Entry Point | Screen |
|-------|-------------|--------|
| `Welcome.java` | `Welcome.main()` | Welcome page |
| `Login.java` | `Login.main()` | Login form |
| `Signup.java` | `Signup.main()` | Sign up form |
| `Address.java` | `Address.main()` | Address form |
| `Landing_page.java` | `Landing_page.main()` | E-commerce landing page |

In NetBeans, open the desired file and click **Run File** (`Shift + F6`).

### Full integrated version

Copy the contents of `Final Cat files/Full main code.txt` (or `Full main code-1.txt`) into a single `.java` file in NetBeans and run it. This version includes the complete panel navigation, search, cart, and payment flow.

### Requirements at runtime

- Oracle Database must be running with populated tables
- Internet connection is required for loading banner and product images from external URLs

---

## Attachments & Media

The `Attachments/` folder contains all visual assets used in the application:

| Folder | Contents |
|--------|----------|
| `Welcome page/` | Welcome screen banners and GIFs |
| `Login page/` | Login screen animations |
| `Signup page/` | Sign-up promotional media |
| `Address page/` | Address form visuals |
| `Logo/` | Trove Cart logo and branding |
| `Category icons/` | Category icon animations (Grocery, Mobile, Fashion, etc.) |
| `Category resized/` | Optimized category GIFs for the UI |
| `Slide banners/` | Promotional slideshow images |
| `Product images/` | Product photos organized by category (Grocery, etc.) |

---

## Project Report

A detailed project report is included at:

```
Trove java report.docx
```

This document covers project objectives, system design, implementation details, and testing.

---

## Development Timeline

This project was developed over Semester 3 (November 2023 – February 2024) at Coimbatore Institute of Technology.

## Author

**Aditya Ganesamoorthy**

- GitHub: [@Aditya-Ganesamoorthy](https://github.com/Aditya-Ganesamoorthy)
- Institution: Coimbatore Institute of Technology (CIT)
- Semester: 3 (2023–2024)