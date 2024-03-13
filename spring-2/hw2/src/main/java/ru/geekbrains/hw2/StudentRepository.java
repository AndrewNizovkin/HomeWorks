package ru.geekbrains.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> students;

    @Autowired
    public StudentRepository() {
        students = new ArrayList<>();
        loadDemoStudents();
    }

    /**
     * Возвращает студента по ID
     * @param id
     * @return
     */
    public Student getByID(int id) {
        return students.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Возвращает список студентов, в имени которых есть name
     * регистр учитывается
     * @param name
     * @return
     */
    public List<Student> getByName(String name) {
        String regex = ".*" + name + ".*";
        return students.stream()
                .filter(x -> x.getName().matches(regex))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает копию списка всех студентов
     * @return List
     */
    public  List<Student> getAll() {
        return List.copyOf(students);
    }

    /**
     * Возвращает список студентов группы
     * @param groupName группа
     * @return List
     */
    public List<Student> getByGroup(String groupName) {
        return students.stream()
                .filter(x -> x.getGroupName().equals(groupName))
                .collect(Collectors.toList());
    }

    /**
     * Заполняет демо-список студентов
     */
    private void loadDemoStudents() {
        students.add(new Student("Андрей", "Разработка"));
        students.add(new Student("Иван", "Разработка"));
        students.add(new Student("Семён", "Разработка"));
        students.add(new Student("Кирилл", "Разработка"));
        students.add(new Student("Василий", "Разработка"));
        students.add(new Student("Костя", "Тестирование"));
        students.add(new Student("Николай", "Тестирование"));
        students.add(new Student("Владимир", "Тестирование"));
        students.add(new Student("Афанасий", "Тестирование"));
        students.add(new Student("Павел", "Тестирование"));
        students.add(new Student("Мария", "Дизайн"));
        students.add(new Student("Наталья", "Дизайн"));
        students.add(new Student("Елена", "Дизайн"));
        students.add(new Student("Аглая", "Дизайн"));
    }
}
