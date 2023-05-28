package ru.geekbrains.lesson1;

public class Product {

    protected String name;
    protected String brand;
    protected double price;

    /**
     * Gets product price
     * @return double this.price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Sets product price
     * @param inputPrice double price
     */
    public void setPrice(double inputPrice){
        checkPrice(inputPrice);
    }

    /**
     * Constructor without parameters
     */
    public Product(){
        this("product", 100);
    }

    /**
     * Construcror with two parameters
     * @param inputName String product name
     * @param inputPrice double product price
     */
    public Product(String inputName, double inputPrice){
        this("noname", inputName, inputPrice);
    }

    /**
     * Constructor with three parameters
     * @param brand product brand
     * @param name product name
     * @param price product price
     */
    public Product(String brand, String name, double price){
        checkPrice(price);
        if (name.length() < 5){
            this.name = "product";
        }
        else {
            this.name = name;
        }
        this.brand = brand;


    }

    /**
     * Checks vilid of input price
     * @param inputPrice double product price
     */
    private void checkPrice(double inputPrice){
        if (inputPrice <= 0){
            price = 100;
        }
        else {
            price = inputPrice;
        }
    }

    /**
     * Gets info about product
     * @return String
     */
    public String displayInfo(){
        return String.format("%s - %s- %f", brand, name, price);
    }

}
