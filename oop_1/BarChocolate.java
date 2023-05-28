package ru.geekbrains.lesson1;

public class BarChocolate extends Product{
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;
    private double weight;

    /**
     * Constructor with eight parameters
     * @param brand product brand
     * @param name product name
     * @param price product price
     * @param calories calories value in bar of chocolate
     * @param protein protein value in bar of chocolate
     * @param fat fat value in bar of chocolate
     * @param carbohydrates carbohydrates value in bar of chocolate
     * @param weight chocolate bar weight
     */
    public BarChocolate(String brand,
                        String name,
                        double price,
                        double calories,
                        double protein,
                        double fat,
                        double carbohydrates,
                        double weight) {
        super(brand, name, price);
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.weight = weight;
    }

    /**
     * Gets calories of chocolate
     * @return double this.calories
     */
    public double getCalories() {
        return calories;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %.2f - Вес: %.2f Калории: %.1f Жиры: %.1f Белки: %.1f Углеводы: %.1f",
                brand,
                name,
                price,
                weight,
                calories,
                fat,
                protein,
                carbohydrates);
    }

}
