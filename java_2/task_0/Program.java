/**
 * Task_0
 * Посчитайте сколько драгоценных камней в куче обычных камней
 * Пример:
 * jewels = “aB”, stones = “aaaAbbbB”
 * Результат в консоль ”a3B1”
 */
public class Program {
    public static void main(String[] args) {
        String jewels = "aB", stones = "aaaAbbbB";
        System.out.println(findJewelsInStones(jewels, stones));
    }

    /**
     * Gets report with the number of each character of the string jewels in the string stones
     * @param jewels String
     * @param stones String
     * @return String report
     */
    public static String findJewelsInStones(String jewels, String stones) {
        StringBuilder report = new StringBuilder();
        int countCurrent;
        char current;
        for (int i = 0; i < jewels.length(); i++) {
            countCurrent = 0;
            current = jewels.charAt(i);
            report.append(current);
            for (int j = 0; j < stones.length(); j++) {
                if (stones.charAt(j) - current == 0) countCurrent++;
            }
            report.append(countCurrent);
        }
        return String.valueOf(report);
    }
}