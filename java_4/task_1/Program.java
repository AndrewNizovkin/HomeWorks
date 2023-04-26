import java.util.*;

/**
 * Task_1
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернет “перевернутый” список.
 * Постараться не обращаться к листу по индексам.
 */
public class Program {
    public static void main(String[] args) {
        demoRevers();
    }

    /**
     * Creates, revers and print random LinkedList
     */
    private static void demoRevers() {
        LinkedList<Integer> llist = getRandomList(10, 10, 30);
        System.out.println("Исходный список:\n" + llist);
        System.out.println("\"Перевёрнутый\" список:\n" + reverceList(llist));
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

    /**
     * Gets reverse list
     * @param list LinkedList<String>
     * @return LinkedList<String>
     */
    private static LinkedList<Integer> reverceList(LinkedList<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            linkedList.add(iterator.previous());
        }
        return linkedList;
    }
}