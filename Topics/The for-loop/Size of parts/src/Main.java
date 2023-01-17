import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int numOfParts = scanner.nextInt();
        int part;
        int rejects = 0;
        int shipped = 0;
        int fixed = 0;
        for (int i = 1; i <= numOfParts; i++){
            part = scanner.nextInt();
            if (part == 1) {
                fixed++;
            } else if (part == -1) {
                rejects++;
            } else {
                shipped++;
            }
        }
        System.out.println(shipped + " " + fixed + " " + rejects);

    }
}