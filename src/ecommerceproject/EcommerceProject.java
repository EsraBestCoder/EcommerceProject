/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecommerceproject;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class EcommerceProject {

    
    public static void main(String[] args) {
        
                SwingUtilities.invokeLater(() -> {
            new EcommerceProjectGUI();
        });
        
        
         // Create user
        User user = new User("sherlock_holmes,", "Sherlock,", "Holmes,", "1854-06-01,", "password,", "sherlock@example.com,"
                                       , "221B Baker Street,", "    239 Baker Street");
        // Create meal product
        Product mealProduct = new Product("Spaghetti ", "Red", "Meal", 30, 0.7, "Classic Italian pasta dish");

        // Create dessert product
        Product dessertProduct = new Product("Cheescake ", "Brown", "Dessert", 20, 0.5, "Rich and decadent chocolate cake");

        // Add favorite products for the user
        user.ProductFavorites(mealProduct);
        user.ProductFavorites(dessertProduct);

        // Add credit card for the user
        CreditCard creditCard = new CreditCard("5289304730284726", "Sherlock Holmes", "984849", "09/29");
        user.getCreditCards().add(creditCard);

        // Create an order and process it (for example, only for dessert product)
        Order dessertOrder = new Order(user, dessertProduct, creditCard);
        dessertOrder.processOrder();
         System.out.println();
        // Print user information
        System.out.println("User Information:");
        printUserInfo(user);

        // Print order history of the user
        System.out.println("\nOrder History:");
        printProductList(user.getProductsOrdered());

        // Print favorite products of the user
        System.out.println("\nFavorite Products:");
        printProductList(user.getFavouriteProducts());

        // Print credit cards of the user
        System.out.println("\nCredit Cards:");
        printCreditCards(user.getCreditCards());        
    }   
       // Print user information
        private static void printUserInfo(User user) {
        System.out.printf("Username: %s%n", user.getUsername());
        System.out.printf("Name: %s %s%n", user.getName(), user.getSurname());
        System.out.printf("Email: %s%n", user.getEmail());
        System.out.printf("Home Address: %s%n", user.getHomeAddress());
        System.out.printf("Work Address: %s%n", user.getWorkAddress());
    }
    
       // Print list of products
        private static void printProductList(List<Product> productList) {
        for (Product product : productList) {
            System.out.printf("- %s%n", product.getName());
        }
         System.out.println();
    }
       // Print list of credit cards
        private static void printCreditCards(List<CreditCard> creditCards) {
        for (CreditCard creditCard : creditCards) {
            System.out.printf("- Card Number: %s, Expiration Date: %s%n", creditCard.getCardNumber(), creditCard.getExpirationDate());
        }
         System.out.println();
 }
    
}
        
class EcommerceProjectGUI extends JFrame {

    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField birthdateField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField homeAddressField;
    private JTextField workAddressField;
    private JTextField cardNumberField;
    private JTextField cardUserField;
    private JPasswordField securityCodeField;
    private JTextField expirationDateField;
    private JTextArea cartArea;

    private List<String> cartItems;

    public EcommerceProjectGUI() {
        super("User Registration & Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        createGUI();
        cartItems = new ArrayList<>();
    }

    private void createGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(14, 2));

        // Kullanıcı bilgileri
        mainPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        mainPanel.add(usernameField);

        mainPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        mainPanel.add(firstNameField);

        mainPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        mainPanel.add(lastNameField);

        mainPanel.add(new JLabel("Birthdate:"));
        birthdateField = new JTextField(20);
        mainPanel.add(birthdateField);

        mainPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        mainPanel.add(passwordField);

        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Home Address:"));
        homeAddressField = new JTextField(20);
        mainPanel.add(homeAddressField);

        mainPanel.add(new JLabel("Work Address:"));
        workAddressField = new JTextField(20);
        mainPanel.add(workAddressField);

        // Kredi kartı bilgileri
        mainPanel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField(20);
        mainPanel.add(cardNumberField);

        mainPanel.add(new JLabel("Card User:"));
        cardUserField = new JTextField(20);
        mainPanel.add(cardUserField);

        mainPanel.add(new JLabel("Security Code:"));
        securityCodeField = new JPasswordField(20);
        mainPanel.add(securityCodeField);

        mainPanel.add(new JLabel("Expiration Date:"));
        expirationDateField = new JTextField(20);
        mainPanel.add(expirationDateField);

        // Sepet
        mainPanel.add(new JLabel("Cart:"));
        cartArea = new JTextArea(10, 20);
        cartArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartArea);
        mainPanel.add(scrollPane);

        // Ürün ekleme düğmesi
        JButton addToBasketButton = new JButton("Add to Basket");
        addToBasketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductToBasket();
            }
        });
        mainPanel.add(addToBasketButton);

        // Satın alma düğmesi
        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUser();
            }
        });
        mainPanel.add(purchaseButton);

        add(mainPanel);
        setVisible(true);
    }

    private void addProductToBasket() {
        String itemName = JOptionPane.showInputDialog(this, "Enter item name:");
        if (itemName != null && !itemName.isEmpty()) {
            cartItems.add(itemName);
            updateCartArea();
        }
    }

    private void updateCartArea() {
        cartArea.setText("");
        for (String item : cartItems) {
            cartArea.append(item + "\n");
        }
    }

    private void saveUser() {
        System.out.println("User Information:");
        System.out.println("Username: " + usernameField.getText());
        System.out.println("First Name: " + firstNameField.getText());
        System.out.println("Last Name: " + lastNameField.getText());
        System.out.println("Birthdate: " + birthdateField.getText());
        System.out.println("Password: " + new String(passwordField.getPassword()));
        System.out.println("Email: " + emailField.getText());
        System.out.println("Home Address: " + homeAddressField.getText());
        System.out.println("Work Address: " + workAddressField.getText());

        System.out.println("Credit Card Information:");
        System.out.println("Card Number: " + cardNumberField.getText());
        System.out.println("Card User: " + cardUserField.getText());
        System.out.println("Security Code: " + new String(securityCodeField.getPassword()));
        System.out.println("Expiration Date: " + expirationDateField.getText());

        System.out.println("Cart Items:");
        for (String item : cartItems) {
            System.out.println("- " + item);
        }

        JOptionPane.showMessageDialog(this, "Registration and purchase completed successfully!");
    }
}


   

