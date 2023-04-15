import java.util.Scanner;

/**
 * 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n!
 * (произведение чисел от 1 до n)
 * Перейти по ссылке, реализовать формулу на Java.
 */
public class Program {
    public static void main(String[] args) {
        int n = Integer.parseInt(getFromConsole("Введите натуральное число"));
        System.out.println(n + "-е треугольное число = " + getTriangularNumber(n));
        System.out.println(n + "-факториал = " + getFactorial(n));
    }

    /**
     * Gets String from console
     * @param msg message
     * @return String
     */
    private static String getFromConsole(String msg) {
        System.out.print(msg + "--> ");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    /**
     * Gets Triangular number
     * @param n natural number
     * @return int Triangular number
     */
    private static int getTriangularNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * Gets factorial
     * @param n int natural number
     * @return int n-factorial
     */
    private static int getFactorial(int n) {
        if (n == 1) return 1;
        return getFactorial(n - 1) * n;
    }
}
