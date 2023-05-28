package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.List;
/*
Создать новый продукт на основе Product, создать ему хотя бы одно свойство
(например, шоколад и калории) и включить в список продуктов в вендинг машину.
 Продемонстрировать работу класса по продаже товаров (как мы это делали на уроке).
*/


public class Program {

    public static void main(String[] args) {

        Product bottleOfWater1 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой [1]", 115, 1);
        Product bottleOfWater2 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой [2]", 215, 1.5);
        BottleOfWater bottleOfWater3 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой [3]", 1115, 1.5);
        Product bottleOfWater4 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой [4]", 55, 2);
        Product bottleOfMilk1 = new BottleOfMilk("ООО Чистый источник", "Бутылка с молоком", 115, 1.5, 10);

        Product chocolate1 = new BarChocolate("Dove",
                "Шоколад",
                97,
                549,
                6.7,
                31.8,
                56.8,
                90);
        BarChocolate chocolate2 = new BarChocolate("Коркунов",
                "Шоколад",
                127,
                571,
                8,
                44,
                29,
                90);
        Product chocolate3 = new BarChocolate("Коркунов",
                "Шоколад",
                92,
                547,
                7.3,
                32.9,
                54.5,
                90);
        BarChocolate chocolate4 = new BarChocolate("Milka",
                "Шоколад",
                98,
                490,
                4.3,
                26,
                58.5,
                90);

        List<Product> products = new ArrayList<>();

        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater4);
        products.add(bottleOfWater3);

        products.add(chocolate1);
        products.add(chocolate2);
        products.add(chocolate3);
        products.add(chocolate4);

        System.out.println("Список продуктов:\n" + "-".repeat(85));
        for (Product product: products) {
            System.out.println(product.displayInfo());
        }
        System.out.println("-".repeat(85) + "\n");

        VendingMachine vendingMachine = new VendingMachine(products);

        BottleOfWater bottleOfWaterResult = vendingMachine.getBottleOfWater(2);
        if (bottleOfWaterResult != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterResult.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        System.out.println();
        BarChocolate chocolateResult = vendingMachine.getBarChocolate(500);
        if (chocolateResult != null) {
            System.out.println("Ещё Вы купили:\n" + chocolateResult.displayInfo());
        } else {
            System.out.println("Такого шоколада нет в автомате.");
        }
    }

}
