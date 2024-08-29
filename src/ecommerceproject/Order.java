/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerceproject;

public class Order {
    private User user;
    private Product product;
    private CreditCard creditCard;
    

    public Order(User user, Product product, CreditCard creditCard){
        this.user = user;
        this.product = product;
        this.creditCard = creditCard;        
   }
    public void processOrder(){
        if (product.getStock() > 0){
            product.ReduceStock(1);
            user.ProductOrdering(product);
            
            System.out.println("Order processed successfully.");
        } else {
            System.out.println("Sorry, the product is out of stock.");
        }
        }

    
    
    }
