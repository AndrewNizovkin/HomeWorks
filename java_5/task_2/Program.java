import java.util.*;

/**
 * Task_1
 * Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова,
 * Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов,
 * Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
 * Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу,
 * которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */
public class Program {
    public static void main(String[] args) {
        LinkedList<String> employs = new LinkedList<>();
        employs.add("Иван Иванов");
        employs.add("Светлана Петрова");
        employs.add("Кристина Белова");
        employs.add("Анна Мусина");
        employs.add("Анна Крутова");
        employs.add("Иван Юрин");
        employs.add("Петр Лыков");
        employs.add("Павел Чернов");
        employs.add("Петр Чернышов");
        employs.add("Мария Федорова");
        employs.add("Марина Светлова");
        employs.add("Мария Савина");
        employs.add("Мария Рыкова");
        employs.add("Марина Лугова");
        employs.add("Анна Владимирова");
        employs.add("Иван Мечников");
        employs.add("Петр Петин");
        employs.add("Иван Ежов");
        searchRepeat(employs);
    }

    /**
     * Sorts by popularity and outputs
     * @param list List<String> list
     */
    private static void searchRepeat(List<String> list) {
        TreeMap<String, Integer> repeatMap = new TreeMap<>();
        list.replaceAll(x -> x.split(" ")[0]);

        for (String value: list) {
            repeatMap.putIfAbsent(value, Collections.frequency(list, value));
        }

        TreeMap<Integer, LinkedList<String>> result = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> entry: repeatMap.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add(entry.getKey());
            } else {
                LinkedList<String> llist = new LinkedList<>();
                llist.add(entry.getKey());
                result.put(entry.getValue(), llist);
            }
        }
        System.out.println(result);
    }
}