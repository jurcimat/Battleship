import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int input = scanner.nextInt();
        boolean res1 = input > -15 && input <= 12;
        boolean res2 = input > 14 && input < 17;
        boolean res3 = input >= 19;

        if (res1 || res2 || res3){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}