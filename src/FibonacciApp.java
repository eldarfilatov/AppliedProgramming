import java.util.Scanner;

/**
 * Клас для представлення числа Фібоначчі
 * Зберігає номер та значення числа, а також містить методи для обчислення і перевірки умов
 */
class Fibonacci {
    private int index;  // Індекс числа Фібоначчі
    private long value; // Значення числа Фібоначчі

    /**
     * Конструктор класу Fibonacci, який ініціалізує номер та значення числа Фібоначчі
     *
     * @param index індекс числа Фібоначчі
     * @param value значення числа Фібоначчі
     */
    public Fibonacci(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Метод для отримання індексу числа Фібоначчі.
     *
     * @return індекс числа Фібоначчі
     */
    public int getIndex() {
        return index;
    }

    /**
     * Метод для отримання значення числа Фібоначчі.
     *
     * @return значення числа Фібоначчі
     */
    public long getValue() {
        return value;
    }

    /**
     * Метод для обчислення N-го числа Фібоначчі.
     *
     * @param n номер числа Фібоначчі, яке необхідно обчислити
     * @return значення N-го числа Фібоначчі
     */
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * Метод для перевірки умови F(N+2) < 2^N.
     *
     * @param n       номер числа Фібоначчі
     * @param fnPlus2 значення (N+2)-го числа Фібоначчі
     * @return true, якщо умова виконується, false, якщо не виконується
     */
    public static boolean checkCondition(int n, long fnPlus2) {
        long powerOfTwo = (long) Math.pow(2, n);
        return fnPlus2 < powerOfTwo;
    }
}

/**
 * Головний клас програми для роботи з числами Фібоначчі та перевірки умови.
 */
public class FibonacciApp {

    /**
     * Головний метод програми, який зчитує вхідні дані, обчислює числа Фібоначчі,
     * перевіряє умову та виводить результати у консоль.
     *
     * @param args параметри командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення номера N з клавіатури
        System.out.print("Введіть номер N для обчислення N-го числа Фібоначчі: ");
        int n = scanner.nextInt();

        // Закриття сканера
        scanner.close();

        // Обчислення N-го числа Фібоначчі
        Fibonacci fibonacciN = new Fibonacci(n, Fibonacci.calculateFibonacci(n));
        System.out.println("N-те число Фібоначчі: " + fibonacciN.getValue());

        // Обчислення (N+2)-го числа Фібоначчі
        Fibonacci fibonacciNPlus2 = new Fibonacci(n + 2, Fibonacci.calculateFibonacci(n + 2));
        System.out.println("(N+2)-ге число Фібоначчі: " + fibonacciNPlus2.getValue());

        // Обчислення та виведення значення 2^N
        long powerOfTwo = (long) Math.pow(2, n);
        System.out.println("2^N = " + powerOfTwo);

        // Перевірка умови Fn+2 < 2^N
        boolean condition = Fibonacci.checkCondition(n, fibonacciNPlus2.getValue());
        if (condition) {
            System.out.println("Умова F(N+2) < 2^N виконується.");
        } else {
            System.out.println("Умова F(N+2) < 2^N не виконується.");
        }

    }
}