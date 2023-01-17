import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long number = scanner.nextLong();
        long n = 1L;
        int i = 1;
        while (n <= number) {
            n *= i;
            i++;
        }
        System.out.println(i - 1);
    }
}