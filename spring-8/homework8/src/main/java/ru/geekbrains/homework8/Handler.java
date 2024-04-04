package ru.geekbrains.homework8;

import org.springframework.stereotype.Component;


@Component
public class Handler {

    @Timer
    public int fib(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <=n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
