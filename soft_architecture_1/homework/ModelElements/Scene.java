package ru.geekbrains.lesson1.homework.ModelElements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Сцена
 * Доработано в рамках ДЗ
 */
public class Scene {

    private static int counter = 1000;
    private int id;
    private Collection<PoligonalModel> models = new ArrayList<>();
    private Collection<Flash> flashes = new ArrayList<>();

    /**
     * Constructor
     */
    public Scene() {
        id = ++counter;
    }

    /**
     * Gets model collection
     * @return Collection
     */
    public Collection<PoligonalModel> getModels() {
        return models;
    }

    /**
     * Gets flash collection
     * @return Collection
     */
    public Collection<Flash> getFlashes() {
        return flashes;
    }

    /**
     * Does some work
     * @param type some type
     * @return some type
     */
    public Type method1(Type type) {
        return null;
    }

    /**
     * Does some work
     * @param type1 some type
     * @param type2 some type
     * @return some type
     */
    public Type method2(Type type1, Type type2) {
        return null;
    }

}
