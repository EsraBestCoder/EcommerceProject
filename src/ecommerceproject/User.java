/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerceproject;

    import java.util.ArrayList;
    import java.util.List;
    
    public class User {

    private String username;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String password;
    private String email;
    private String homeAddress;
    private String workAddress;
    private List<Product> productsOrdered;
    private List<Product> favouriteProducts;
    private List<CreditCard> creditCards;
      
    public User(String username,String name,String surname,String dateOfBirth,
            String password,String email,String homeAddress,String workAdress ){
        
        this.username=username;
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.password=password;
        this.email=email;
        this.homeAddress=homeAddress;
        this.workAddress=workAdress;
        this.productsOrdered= new ArrayList<>();
        this.favouriteProducts=new ArrayList<>();
        this.creditCards= new ArrayList<>();       
    }
    
    public void ProductOrdering(Product product){
        getProductsOrdered().add(product);
        System.out.println(username + " has added " + product.getName());
    }
    public void ProductFavorites(Product product){
        getFavouriteProducts().add(product);
        System.out.println(username + " has added "+product.getName()+ "to favourites");
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public List<Product> getProductsOrdered() {
        return productsOrdered;
    }
    
    public void setProductsOrdered(List<Product> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public List<Product> getFavouriteProducts() {
        return favouriteProducts;
    }

    public void setFavouriteProducts(List<Product> favouriteProducts) {
        this.favouriteProducts = favouriteProducts;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
  
    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
  
    }