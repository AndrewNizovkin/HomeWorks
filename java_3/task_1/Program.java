import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Task_1
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class Program {
    public static void main(String[] args) {
        List<Integer> list = getIntArray(20, 0, 20);
        System.out.println("Исходный произвольный список:\n" + list);
        list.removeIf(x -> x % 2 == 0);
        System.out.println("Чётные удалены:\n" + list);
    }

    /**
     * Gets list with random values
     * @param size int size of list
     * @param min int start diapason
     * @param max int end diapason
     * @return List
     */
    private static List<Integer> getIntArray(int size, int min, int max) {
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(max - min + 1) + min);
        }
        return list;
    }
}