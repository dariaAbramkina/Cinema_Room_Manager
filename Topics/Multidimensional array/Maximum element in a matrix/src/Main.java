import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsCount = scanner.nextInt();
        int columnsCount = scanner.nextInt();
        int columnIndex = 0;
        int rowIndex = 0;
        int[][] matrix = new int[rowsCount][columnsCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int maxValue = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    rowIndex = i;
                    columnIndex = j;
                } else {
                    if (matrix[i][j] == maxValue) {
                        if (rowIndex > i) {
                            rowIndex = i;
                        } else {
                            if (rowIndex == i && columnIndex > j) {
                                columnIndex = j;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(rowIndex + " " + columnIndex);
    }
}