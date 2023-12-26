package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {
    private MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @Test
    void isEvenPositiv() {
        assertTrue(mainHW.isEven(2));
    }

    @Test
    void isEvenNegative() {
        assertFalse(mainHW.isEven(3));
    }

    @Test
    void inIntervalPositive() {
        assertTrue(mainHW.inInterval(50));
    }

    @Test
    void lessIntervalNegative() {
        assertFalse(mainHW.inInterval(20));
    }

    @Test
    void moreIntervalNegative() {
        assertFalse(mainHW.inInterval(150));
    }

}