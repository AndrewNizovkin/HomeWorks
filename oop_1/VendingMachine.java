package ru.geekbrains.lesson1;

import java.util.List;

/**
 * This class encapsulates list of products.
 * Presents methods for sale products
 */
public class VendingMachine {

    private List<Product> products;


    /**
     * Constructor
     * @param products list of products
     */
    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    /**
     * Gets out the first instance BottleOfWater whose volume equal to the transmitted
     * @param volume test volume
     * @return instance ButtleOfWater or null
     */
    public BottleOfWater getBottleOfWater(double volume){
        for (Product product : products){
            if (product instanceof BottleOfWater){
                if (((BottleOfWater)product).getVolume()  == volume){
                    return (BottleOfWater)product;
                }
            }
        }
        return null;
    }

    /**
     * Gets out the first instance BarChocolate whose calories are less than the value
     * @param volume control value of calories
     * @return BarCocolate
     */
    public BarChocolate getBarChocolate(double volume){
        for (Product product : products){
            if (product instanceof BarChocolate){
                if (((BarChocolate)product).getCalories()  <= volume){
                    return (BarChocolate) product;
                }
            }
        }
        return null;
    }


}
