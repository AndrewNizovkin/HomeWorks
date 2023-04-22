import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Task_2
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и 
 * среднее арифметическое из этого списка. Collections.max()
 */
public class Program {
    public static void main(String[] args) {
        ArrayList<Integer> list = getIntArray(20, 0, 20);
        System.out.println("Исходный произвольный список:\n" + list);
        System.out.println("Максимальное значение = " + Collections.max(list));
        System.out.println("Минимальное значение = " + Collections.min(list));
        System.out.printf("Среднее арифметическое = %.2f", getAverage(list));

    }

    /**
     * Gets average of List<Integer>
     * @param list List<Integer>
     * @return int
     */
    private static double getAverage(List<Integer> list) {
        double sum = 0;
        for (int value: list) sum += value;
        return sum / list.size();
    }

    /**
     * Gets list with random values
     * @param size int size of list
     * @param min int start diapason
     * @param max int end diapason
     * @return ArrayList
     */
    private static ArrayList<Integer> getIntArray(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(max - min + 1) + min);
        }
        return list;
    }
}