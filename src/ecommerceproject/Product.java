/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerceproject;

public class Product {
    
   private String name;
   private String colour;
   private String category;
   private int stock;
   private double weight;
   private String description;
   
   public Product(String name, String colour, String category, int stock, double weight, String description){
       this.name=name;
       this.colour=colour;
       this.category=category;
       this.stock=stock;
       this.weight=weight;
       this.description=description;   
   }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }   
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
   
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
   
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
      
    public void ReduceStock(int orderedQuantity){
 
       if (orderedQuantity <= 0) {
        System.out.println("Invalid order quantity for " + name);
        return;
    }
       if (stock >= orderedQuantity) {
        stock -= orderedQuantity;
        System.out.println("Successfully ordered " + orderedQuantity + " " + name + ". Remaining stock: " + stock);}
       else {
        System.out.println("Failed to order " + orderedQuantity + " " + name + ". Insufficient stock: " + stock);
    }
    }
    
}
