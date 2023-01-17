import java.util.Scanner;

import static java.lang.Math.abs;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(abs(i-j) + " ");
            }
            System.out.println();
        }
    }
}