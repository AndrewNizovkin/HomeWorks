package seminars.sixth;

import seminars.sixth.lists.HandlerDefault;
import seminars.sixth.lists.ListStatistic;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> second = Arrays.asList(10, 20, 30, 40, 50);
        ListStatistic statistic = new ListStatistic(first, second, new HandlerDefault());

        System.out.println(statistic.getCompareMessage());
    }
}
