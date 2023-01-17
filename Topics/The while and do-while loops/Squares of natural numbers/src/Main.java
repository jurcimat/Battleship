import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        int counter = 1;
        while (counter * counter <= number) {
            System.out.println(counter * counter);
            counter++;
        }
    }
}