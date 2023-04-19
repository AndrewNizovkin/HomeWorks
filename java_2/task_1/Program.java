/**
 * Task_1
 * Вам дается строка S и целочисленный массив индексов int index[s.length].
 * Напишите программу, которая перетасует символы в S таким образом,
 * что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
 *
 * Пример: s = “cba”, index = [3,2,1] result “abc”
 */
public class Program {
    public static void main(String[] args) {
        String s = "cba";
        int[] index = {3, 2, 1};

        System.out.println(shuffle(s, index));
    }

    /**
     * Gets shuffled string
     * @param s String
     * @param index int[s.lenth]
     * @return String
     */
    public static String shuffle(final  String s, final int[] index) {
        char[] array = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[index[i] - 1] = s.charAt(i);
        }
        return String.valueOf(array);
    }
}