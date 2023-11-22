package ru.geekbrains.lesson1.homework.InMemoryModel;

import ru.geekbrains.lesson1.homework.ModelElements.Camera;
import ru.geekbrains.lesson1.homework.ModelElements.PoligonalModel;
import ru.geekbrains.lesson1.homework.ModelElements.Scene;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Хранилище 3D-элементов
 * Доработано в рамках ДЗ
 */
public class ModelStore implements ModelChanger {

    private Collection<PoligonalModel> models = new ArrayList<>();
    private Collection<Scene> scenes = new ArrayList<>();
    private Collection<Camera> cameras = new ArrayList<>();
    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    /**
     * Gets model list
     * @return Collection
     */
    public Collection<PoligonalModel> getModels() {
        return models;
    }

    /**
     * Gets scene list
     * @return Collection
     */
    public Collection<Scene> getScenes() {
        return scenes;
    }

    /**
     * Gets camera list
     * @return Collection
     */
    public Collection<Camera> getCameras() {
        return cameras;
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }

    /**
     * Нотификация изменений на уровне хранилища
     */
    private void notifyChange(){
        for (ModelChangedObserver observer : changeObservers){
            observer.applyUpdateModel();
        }
    }

    public void addModel(PoligonalModel poligonalModel){
        notifyChange();
    }

}
