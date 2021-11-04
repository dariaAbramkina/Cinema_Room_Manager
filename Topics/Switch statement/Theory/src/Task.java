// You can experiment here, it won’t be checked

public class Task {
  public static int gcd(int a, int b) {
    while (b > 0) {
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
  public static void main(String[] args) {
    System.out.println(gcd(4, 6));
  }
}
