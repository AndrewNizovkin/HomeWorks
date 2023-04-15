import java.util.Scanner;

/**
 * Реализовать простой калькулятор
 * Минимум -- > Условия + Цикл
 * Введите число
 * Введите число
 * Выберите операцию
 * 1 - сложить
 * 2 - умножить
 */
public class Program {
    public static void main(String[] args) {
        int firstNumber = Integer.parseInt(getFromConsole("Введите первое число"));
        int secondNumber = Integer.parseInt(getFromConsole("Введите второе число"));
        int operation = Integer.parseInt(getFromConsole("[1]сложить  [2]умножить"));
        System.out.println(" = " + calculator(firstNumber, secondNumber, operation));
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
     * Calculates two integer numbers
     * @param firstNumber int
     * @param secondNumber int
     * @param operation int code of operation
     * @return int
     */
    private static int calculator(int firstNumber, int secondNumber, int operation) {
        return switch (operation) {
            case 1 -> firstNumber + secondNumber;
            case 2 -> firstNumber * secondNumber;
            default -> Integer.MAX_VALUE;
        };
    }
}