import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicle.Car;
import vehicle.Motorcycle;
import vehicle.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void runTests() {
        this.car = new Car("Lada", "Vesta", 2023);
        this.motorcycle = new Motorcycle("Honda", "CBF 1000", 2013);
    }

    /**
     * Проверяем, что экземпляр объекта Car
     * также является экземпляром Vehicle
     */
    @Test
    void carIsVehicle() {
        assertThat(car instanceof Vehicle);

    }

    /**
     * Проверяет, что объект Car создаётся с 4-мя колёсами
     */
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels() == 4);
    }

    /**
     * Проверяет, что объект Motorcycle создаётся с 4-мя колёсами
     */
    @Test
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels() == 2);
    }

    /**
     * Проверяет тестовую скорость автомобиля
     */
    @Test
    void checkSpeedCar() {
        car.testDrive();
        assertThat(car.getSpeed() == 60);
    }

    /**
     * Проверяет тестовую скорость мотоцикла
     */
    @Test
    void checkSpeedMotorcycle() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed() == 75);
    }

    /**
     * Проверяет скорость автомобиля после парковки
     */
    @Test
    void checkSpeedCarAfterParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed() == 0);
    }

    /**
     * Проверяет скорость мотоцикла после парковки
     */
    @Test
    void checkSpeedMotorcycleAfterParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed() == 0);
    }

}
