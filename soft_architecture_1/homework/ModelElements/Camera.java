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
     * Gets camera location
     * @return Point3D
     */
    public Point3D getLocation() {
        return location;
    }

    /**
     * Gets camera direction
     * @return Angle3D
     */
    public Angle3D getAngle3D() {
        return angle3D;
    }

    /**
     * Sets new camera position
     * @param location Point3D
     */
    public void setLocation(Point3D location) {
        this.location = location;
    }

    /**
     * Sets new camera direction
     * @param angle3D Angle3D
     */
    public void setAngle3D(Angle3D angle3D) {
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
