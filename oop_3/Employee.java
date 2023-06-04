package ru.geekbrains.lesson3.task2;

public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    protected double salary; // Ставка заработной платы
    protected int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, String surname, double salary, int age) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    /**
     * Сравнивает по фамилии, а при совпадении по имени
     */
    @Override
    public int compareTo(Employee o) {
        int res = surname.compareTo(o.surname);
        if (res == 0){
            res = name.compareTo(o.name);
        }
        return res;
    }
}
