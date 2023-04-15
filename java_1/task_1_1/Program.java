/**
 * Вывести все простые числа от 1 до 1000
 */
public class Program {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }

    /**
     * Checks number is prime
     *
     * @param n int natural number
     * @return boolean
     */
    private static boolean isPrime(int n) {
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}