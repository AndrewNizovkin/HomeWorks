import java.util.*;

/**
 * Task_3
 * Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
 */
public class Program {
    public static void main(String[] args) {
        demoSum();
    }

    /**
     * Creates new LinkedList<Integer> and gets sum of all elements
     */
    private static void demoSum() {
        LinkedList<Integer> linkedList = getRandomList(10, 0, 10);
        Iterator<Integer> iterator = linkedList.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println(linkedList);
        System.out.println("Сумма элементов = " + sum);
    }

    /**
     * Gets Linkedlist<Integer> with random values
     * @param size int size of list
     * @param min int start diapason
     * @param max int end diapason
     * @return LinkedList<Integer>
     */
    private static LinkedList<Integer> getRandomList(int size, int min, int max) {
        LinkedList<Integer> llist = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            llist.add(rnd.nextInt(max - min + 1) + min);
        }
        return llist;
    }

}