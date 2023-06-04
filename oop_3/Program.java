package ru.geekbrains.lesson3.task2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Program {

    static Random random = new Random();

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     * @return
     */
    static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        switch (random.nextInt(2)) {
            case 0 -> {
                return new Worker(names[random.nextInt(2)],
                        surnames[random.nextInt(surnames.length)],
                        random.nextInt(20000, 80000),
                        random.nextInt(20, 55));
            }
            case 1 -> {
                return new Freelancer(names[random.nextInt(2)],
                        surnames[random.nextInt(surnames.length)],
                        random.nextInt(500, 1000),
                        random.nextInt(20, 55));
            }
        }

        int salary = random.nextInt(20000, 80000);
        return new Worker(names[random.nextInt(2)],
                surnames[random.nextInt(surnames.length)],
                salary,
                random.nextInt(20, 55));
    }

    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *   Придумать несколько Comparator'ов для сортировки сотрудников
     *   по фамилии + имени или по возрасту + уровню зп.
     * @param args
     */
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
        {
            employees[i] = generateEmployee();
        }

        System.out.println("\nСортировка по фамилии и имени(при совпадении фамилий):\n" + "-".repeat(126));
        Arrays.sort(employees);
        Arrays.stream(employees).forEach(System.out::println);

        System.out.println("\nСортировка по убыванию уровня заработной платы:\n" + "-".repeat(126));
        Arrays.stream(employees).sorted(new SalaryComparator()).forEach(System.out::println);

        System.out.println("\nСортировка по возрасту от меньшего к большему:\n" + "-".repeat(126));
        Arrays.stream(employees).sorted(new AgeComparator()).forEach(System.out::println);

        System.out.println("\nСортировка по убыванию уровня заработной платы. Только фрилансеры:\n" + "-".repeat(126));
        Arrays.stream(employees).
                filter(a -> a instanceof Freelancer).
                sorted(new SalaryComparator()).
                forEach(System.out::println);

        System.out.println("\nСортировка по возрасту. Только рабочие:\n" + "-".repeat(126));
        Arrays.stream(employees).
                filter(a -> a instanceof Worker).
                sorted((a, b) -> a.age - b.age).
                forEach(System.out::println);

    }

}
