import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println(a);
	}
}