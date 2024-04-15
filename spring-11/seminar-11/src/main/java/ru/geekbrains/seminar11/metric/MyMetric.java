package ru.geekbrains.seminar11.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyMetric {

    private final AtomicInteger myNumber;
    private final Counter myCounter;

    public MyMetric(MeterRegistry meterRegistry) {
        myNumber = meterRegistry.gauge("custom_gauge", new AtomicInteger());
        myCounter = meterRegistry.counter("my_counter");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 0)
    public void schedulingTask() {
        int random = (int) (Math.random() * 100);
        myNumber.set(random);

        myCounter.increment();
    }
}
