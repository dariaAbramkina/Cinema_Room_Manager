import java.util.Scanner;

public class Main {
    private static final String GRYFFINDOR = "gryffindor";
    private static final String HUFFLEPUFF = "hufflepuff";
    private static final String SLYTHERIN = "slytherin";
    private static final String RAVENCLAW = "ravenclaw";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String houseName = scanner.next();

        switch (houseName) {
            case GRYFFINDOR:
                System.out.println("bravery");
                break;
            case HUFFLEPUFF:
                System.out.println("loyalty");
                break;
            case SLYTHERIN:
                System.out.println("cunning");
                break;
            case RAVENCLAW:
                System.out.println("intellect");
                break;
            default:
                System.out.println("not a valid house");
                break;
        }
    }
}
