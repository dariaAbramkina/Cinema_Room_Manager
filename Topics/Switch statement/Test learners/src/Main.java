import java.util.Scanner;

class Main {

    private static final int JAVA = 1;
    private static final int KOTLIN = 2;
    private static final int SCALA = 3;
    private static final int PYTHON = 4;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int answerNumber = scanner.nextInt();

        switch (answerNumber) {
            case JAVA:
                System.out.println("Yes!");
                break;
            case KOTLIN:
            case SCALA:
            case PYTHON:
                System.out.println("No!");
                break;
            default:
                System.out.println("Unknown number");
                break;
        }
    }
}
