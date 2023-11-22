package ru.geekbrains.lesson1.homework.ModelElements;

import java.awt.*;

/**
 * Источник света
 * Доработано в рамках ДЗ
 */
public class Flash {

    private Point3D location;
    private Angle3D angle3D;
    private Color color;
    private Float power;

    /**
     * Constructor
     * @param location Flash location
     * @param angle3D Flash direction
     * @param color Flash color
     * @param power Flash power
     */
    public Flash(Point3D location, Angle3D angle3D, Color color, Float power) {
        this.location = location;
        this.angle3D = angle3D;
        this.color = color;
        this.power = power;
    }

    /**
     * Changes Flash direction
     * @param angle Angle3D
     */
    public void rotate(Angle3D angle) {

    }

    /**
     * Changes Flash position
     * @param  point3D new Flash position
     */
    public void move(Point3D point3D) {

    }

    /**
     * Gets flash color
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets flash power
     * @return Float
     */
    public Float getPower() {
        return power;
    }

    /**
     * Sets flash color
     * @param color Color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets flash power
     * @param power Float
     */
    public void setPower(Float power) {
        this.power = power;
    }
}
