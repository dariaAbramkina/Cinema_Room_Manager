import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsCount = scanner.nextInt();
        int columnsCount = scanner.nextInt();
        int[][] matrix = new int[rowsCount][columnsCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] matrixRotated = new int[columnsCount][rowsCount];
        for (int i = 0; i < matrixRotated.length; i++) {
            for (int j = 0; j < matrixRotated[i].length; j++) {
                matrixRotated[i][j] = matrix[matrix.length - 1 - j][i];
                System.out.print(matrixRotated[i][j] + " ");
            }
            System.out.println();
        }
    }
}
