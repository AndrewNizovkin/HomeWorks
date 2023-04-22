import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Task_3
 * Заполнить список названиями планет Солнечной системы
 * в произвольном порядке с повторениями. Вывести название
 * каждой планеты и количество его повторений в списке.
 */
public class Program {
    public static void main(String[] args) {
        String[] planets = new String[] {"Меркурий", "Венера", "Земля",
                "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон"};
        List<String> list = getRandomPlanets(planets, 20);
        System.out.println("Случайный список планет:\n" + list);
        outFreqDictionary(list, planets);

    }

    /**
     * Gets count value in list
     * @param list List<String>
     * @param value String
     * @return int
     */
    private static int getCountOfList(List<String> list, String value){
        int count = 0;
        for (String str: list) {
            if (str.equals(value)) count++;
        }
        return count;
    }

    /**
     * print to console frequency dictionary
     * @param list List
     * @param dict String[]
     */
    private static void outFreqDictionary(List<String> list, String[] dict) {
        for (String value: dict) {
            System.out.println(value + " -> " + getCountOfList(list, value));
        }
    }

    /**
     * Gets list with planets whit random order
     * @param dict array with planets
     * @param size int size result list
     * @return ArrayList
     */
    private static ArrayList<String> getRandomPlanets(String[] dict, int size) {
        ArrayList<String> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(dict[rnd.nextInt(dict.length)]);
        }
        return list;
    }
}