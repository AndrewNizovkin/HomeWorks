package ru.geekbrains.lesson1.homework.ModelElements;

/**
 * Камера
 * Доработано в рамках ДЗ
 */
public class Camera {

    private Point3D location;
    private Angle3D angle3D;

    /**
     * Constructor
     * @param location Camera location
     * @param angle3D Camera direction
     */
    public Camera(Point3D location, Angle3D angle3D) {
        this.location = location;
        this.angle3D = angle3D;
    }



    /**
     * Changes camera direction
     * @param angle rotate angle
     */
    public void rotate(Angle3D angle) {

    }

    /**
     * Changes camera position
     * @param newLocation new camera position
     */
    public void move(Point3D newLocation) {

    }

}
