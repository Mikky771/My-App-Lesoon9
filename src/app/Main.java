package app;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Створення двовимірного масиву 4x4
        int[][] matrix = new int[4][4];

        // Заповнення матриці випадковими цілими числами в діапазоні від 1 до 50
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        // Виведення матриці на екран у вигляді таблиці
        System.out.println("Матриця:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        // Знаходження суми елементів в парних і непарних рядках
        int evenRowsSum = 0;
        int oddRowsSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    evenRowsSum += matrix[i][j];
                } else {
                    oddRowsSum += matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (0, 2): " + evenRowsSum);
        System.out.println("Сума елементів у непарних рядках (1, 3): " + oddRowsSum);

        // Знаходження добутку елементів в парних і непарних стовпцях
        int evenColsProduct = 1;
        int oddColsProduct = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0) {
                    evenColsProduct *= matrix[i][j];
                } else {
                    oddColsProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Добуток елементів у парних стовпцях (0, 2): " + evenColsProduct);
        System.out.println("Добуток елементів у непарних стовпцях (1, 3): " + oddColsProduct);

        // Перевірка, чи матриця є магічним квадратом
        boolean isMagicSquare = checkMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    // Метод для перевірки, чи є матриця магічним квадратом
    public static boolean checkMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int sumDiagonal1 = 0, sumDiagonal2 = 0;

        // Знаходження суми елементів першої діагоналі
        for (int i = 0; i < n; i++) {
            sumDiagonal1 += matrix[i][i];
        }

        // Знаходження суми елементів другої діагоналі
        for (int i = 0; i < n; i++) {
            sumDiagonal2 += matrix[i][n - i - 1];
        }

        // Якщо суми діагоналей не рівні, це не магічний квадрат
        if (sumDiagonal1 != sumDiagonal2) {
            return false;
        }

        // Сума рядка та стовпця для перевірки
        int sumRow = 0, sumCol = 0;

        // Знаходження суми першого рядка (еталонна сума)
        int targetSum = sumDiagonal1;

        // Перевірка кожного рядка і стовпця
        for (int i = 0; i < n; i++) {
            sumRow = 0;
            sumCol = 0;
            for (int j = 0; j < n; j++) {
                sumRow += matrix[i][j];
                sumCol += matrix[j][i];
            }

            // Якщо сума рядка або стовпця не дорівнює еталонній сумі, це не магічний квадрат
            if (sumRow != targetSum || sumCol != targetSum) {
                return false;
            }
        }

        return true; // Якщо всі суми рівні, це магічний квадрат
    }
}