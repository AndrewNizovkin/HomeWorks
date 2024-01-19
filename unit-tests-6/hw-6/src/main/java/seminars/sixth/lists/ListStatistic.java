package seminars.sixth.lists;

import java.util.List;

/**
 *  Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
 * a. Рассчитывает среднее значение каждого списка.
 * b. Сравнивает эти средние значения и выводит соответствующее сообщение:
 *
 * - "Первый список имеет большее среднее значение", если среднее значение первого списка больше.
 *
 * - "Второй список имеет большее среднее значение", если среднее значение второго списка больше.
 *
 * - "Средние значения равны", если средние значения списков равны.
 */

public class ListStatistic {
    private List<Integer> first;
    private List<Integer> second;
    private Handler handler;

    public ListStatistic(List<Integer> first, List<Integer> second, Handler handler) {
        this.first = first;
        this.second = second;
        this.handler = handler;
    }

    /**
     * Сравнивает списки и возвращает сообщение
     * @return сообщение
     */
    public String getCompareMessage() {
        String message = "";
        double firstAverage = handler.getAverage(first);
        double secondAverage = handler.getAverage(second);
        int res = handler.compareDouble(firstAverage, secondAverage);
        res = (int) Math.signum(res);

        switch (res) {

            case 1 -> message =  "Первый список имеет большее среднее значение";

            case -1 -> message = "Второй список имеет большее среднее значение";

            default -> message = "Средние значения равны";

        }
        return message;
    }
}
