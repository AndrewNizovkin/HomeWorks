package ru.geekbrains.hw2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class Student {
    private static int count;
    private int id;
    private String name;
    private String groupName;

    @Autowired
    public Student(String name, String groupName) {
        id = count++;
        this.name = name;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

}
