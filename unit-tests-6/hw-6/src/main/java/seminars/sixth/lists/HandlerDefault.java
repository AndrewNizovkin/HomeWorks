package seminars.sixth.lists;

import java.util.List;

public class HandlerDefault implements Handler{
    /**
     * Расчитывает и возвращает среднее значение списка
     *
     * @param list
     * @return
     */
    @Override
    public double getAverage(List<Integer> list) {
        return (double) (list.stream().reduce(0, Integer::sum)) / list.size();
    }

    /**
     * Сравнивает два числа
     *
     * @param first
     * @param second
     * @return 1 - если first > second; -1 - если first < second; 0 - если first == second
     */
    @Override
    public int compareDouble(double first, double second) {
        if (first > second) return 1;
        if (first < second) return -1;
        return 0;
    }
}
