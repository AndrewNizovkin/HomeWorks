package ru.geekbrains.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("student")
public class StudentsController {
    private final StudentRepository repository;

    @Autowired
    public StudentsController(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Возвращает всех студентов
     * @return
     */
    @GetMapping("student")
    public List<Student> getAll() {
        return repository.getAll();
    }

    /**
     * Возвращет всех студентов группы
     * @param groupName
     * @return
     */
    @GetMapping("group/{groupName}/student")
    public List<Student> getGroup(@PathVariable String groupName) {
        return repository.getByGroup(groupName);
    }

    /**
     * Возвращает студента по id
     * @param id
     * @return
     */
    @GetMapping("student/{id}")
    public Student getById(@PathVariable int id) {
        return repository.getByID(id);
    }

    /**
     * Возвращает список студентов по имени
     * регистр учитывается
     * @param name
     * @return
     */
    @GetMapping("student/search")
    public List<Student> getByName(@RequestParam String name) {
        return repository.getByName(name);
    }

}
