import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input = scanner.nextLine();
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        for (int i = low; i <= high; i++){
            System.out.print(input.charAt(i));
        }
    }
}