import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input = scanner.nextLine();
        if (input.charAt(0) == 'J' || input.charAt(0) == 'j') {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}