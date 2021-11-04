import java.util.Scanner;

public class Main {
    private static final int SQUARE = 1;
    private static final int CIRCLE = 2;
    private static final int TRIANGLE = 3;
    private static final int RHOMBUS = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answerNumber = scanner.nextInt();

        switch (answerNumber) {
            case SQUARE:
                System.out.println("You have chosen a square");
                break;
            case CIRCLE:
                System.out.println("You have chosen a circle");
                break;
            case TRIANGLE:
                System.out.println("You have chosen a triangle");
                break;
            case RHOMBUS:
                System.out.println("You have chosen a rhombus");
                break;
            default:
                System.out.println("There is no such shape!");
                break;
        }
    }
}
