import java.util.Scanner;

/**
 * Task_2
 * На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк -
 * строки книги. потом вводится натуральное число m - количество продуктов, на которые у человека аллергия.
 * Потом вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на который у человека аллергия
 * и продукт2 - продукт, на который следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова.
 * название продуктов написаны строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену,
 * не встречаются изначально в тексте.

 * Выходные данные
 * Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание.
 * ВАЖНО!!! Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться
 * с большой буквы!
 *
 * Sample Input:
 * 2
 * Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
 * Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
 * 3
 * арахис - колбаса
 * клубника - вишня
 * сгущенка - молоко
 * Sample Output:
 *
 * Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его.
 * Посыпьте измельчённый колбаса на мороженое.
 * Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.
 */
public class Program {
    public static void main(String[] args) {
        int n = Integer.parseInt(getFromConsole("Количество строк в книге"));
        String[] book = new String[n];
        for (int i = 0; i < n; i++) book[i] = getFromConsole("Строка №" + (i + 1));

        int m = Integer.parseInt(getFromConsole("Количество аллергенов"));
        String[][] products = new String[m][];
        for (int i = 0; i < m; i++) products[i] = getFromConsole("Пара продуктов №" + (i +1)).split(" - ");

        for (String recipe: book) System.out.println(changeRecipe(recipe, products));
    }

    /**
     * Modifies first symbol to UpperCase
     * @param word String
     * @return String
     */
    private static String firstUp(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    /**
     * Modifies the String recipe according to the dictionary dict
     * @param recipe String
     * @param dict String[][]
     * @return String
     */
    private static String changeRecipe(String recipe, String[][] dict) {
        for (String[] pair : dict) {
            recipe = recipe.replace(pair[0], pair[1]);
            recipe = recipe.replace(firstUp(pair[0]), firstUp(pair[1]));
        }
        return recipe;
    }

    /**
     * Gets String from console
     * @param msg message
     * @return String
     */
    private static String getFromConsole(String msg) {
        System.out.print(msg + "--> ");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }
}