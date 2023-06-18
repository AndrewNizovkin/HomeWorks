package ru.geekbrains.lesson7.observer;

public class Vacancy {
    private final TypeVacancy typeVacancy;
    private final String companyName;
    private final double salary;

    public Vacancy(String companyName, double salary, TypeVacancy typeVacancy) {
        this.companyName = companyName;
        this.salary = salary;
        this.typeVacancy = typeVacancy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getSalary() {
        return salary;
    }

    public TypeVacancy getTypeVacancy() {
        return typeVacancy;
    }
}
