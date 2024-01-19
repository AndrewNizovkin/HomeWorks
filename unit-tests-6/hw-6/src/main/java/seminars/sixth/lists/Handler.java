package seminars.sixth.lists;

import java.util.List;

public interface Handler {

    /**
     * Расчитывает среднее значение
     * @param list
     * @return
     */
    double getAverage(List<Integer> list);

    /**
     * Сравнивает два числа
     * @param first
     * @param second
     * @return
     */
    int compareDouble(double first, double second);
}
