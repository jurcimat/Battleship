import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        int hundreds = number / 100;
        int decimal = (number % 100) / 10;
        int ones = (number % 100) % 10;

        System.out.println(hundreds + decimal + ones);
    }
}