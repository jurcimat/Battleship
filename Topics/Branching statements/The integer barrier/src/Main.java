import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int sum = 0;
        // start coding here
        while (true) {
            n = scanner.nextInt();
            if (n == 0){
                break;
            }
            sum += n;
            if (sum >= 1000){
                sum -= 1000;
                break;
            }
        }
        System.out.println(sum);
    }
}