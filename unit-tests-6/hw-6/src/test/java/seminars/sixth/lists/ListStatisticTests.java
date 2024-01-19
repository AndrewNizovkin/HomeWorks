package seminars.sixth.lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;


class ListStatisticTests {

    /**
     * Проверяет вычисление среднего значения для корректного списка
     */
    @Test
    void handlerGetAverageCorrect() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        HandlerDefault handlerDefault = new HandlerDefault();

        double result = handlerDefault.getAverage(list);

        assertEquals(25.0, result);
    }

    /**
     * Проверяет вычисление среднего значения для списка из одного элемента
     */
    @Test
    void handlerGetAverageSingle() {
        List<Integer> list = Arrays.asList(20);
        HandlerDefault handlerDefault = new HandlerDefault();

        double result = handlerDefault.getAverage(list);

        assertEquals(20.0, result);
    }


    /**
     * Проверяет сравнение чисел
     * @param first первое число
     * @param second второе число
     * @param actual результат
     */
    @ParameterizedTest
    @CsvSource({"20, 10, 1", "10, 20, -1", "10, 10, 0"})
    void handlerCompairDoubleTest(double first, double second, int actual) {
        
        HandlerDefault handler = new HandlerDefault();

        int result = handler.compareDouble(first, second);

        assertEquals(actual, result);
    }

    /**
     * Проверяет отображение сообщения, если первый список имеет большее среднее значение
     */
    @Test
    void getCompareMessageTestFirstBigger() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Handler handler = mock(Handler.class);
        when(handler.getAverage(anyList())).thenReturn(10.0);
        when(handler.compareDouble(anyDouble(), anyDouble())).thenReturn(1);

        ListStatistic listStatistic = new ListStatistic(list1, list2, handler);

        String result = listStatistic.getCompareMessage();

        assertEquals("Первый список имеет большее среднее значение", result);

    }

    /**
     * Проверяет отображение сообщения, если второй список имеет большее среднее значение
     */
    @Test
    void getCompareMessageTestSecondBigger() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Handler handler = mock(Handler.class);
        when(handler.getAverage(anyList())).thenReturn(10.0);
        when(handler.compareDouble(anyDouble(), anyDouble())).thenReturn(-1);

        ListStatistic listStatistic = new ListStatistic(list1, list2, handler);

        String result = listStatistic.getCompareMessage();

        assertEquals("Второй список имеет большее среднее значение", result);

    }

    /**
     * Проверяет отображение сообщения, если второй и второй списки имеют одинаковое среднее значение
     */
    @Test
    void getCompareMessageTestFirstEqualSecond() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Handler handler = mock(Handler.class);
        when(handler.getAverage(anyList())).thenReturn(10.0);
        when(handler.compareDouble(anyDouble(), anyDouble())).thenReturn(0);

        ListStatistic listStatistic = new ListStatistic(list1, list2, handler);

        String result = listStatistic.getCompareMessage();

        assertEquals("Средние значения равны", result);

    }

    /**
     * Проверяет работу программы с реальными данными
     */
    @Test
    void getCompareMessageTest() {
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> second = Arrays.asList(10, 20, 30, 40, 50);
        Handler handler = new HandlerDefault();

        ListStatistic listStatistic = new ListStatistic(first, second, handler);

        String result = listStatistic.getCompareMessage();

        assertEquals("Второй список имеет большее среднее значение", result);

    }

}
