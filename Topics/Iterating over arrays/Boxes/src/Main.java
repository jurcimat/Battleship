import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];

        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);
        int box1Count = 0;
        int box2Count = 0;
        for (int i = 0; i < 3; i++) {
            if (box1[i] < box2[i]){
                box2Count++;
            } else if (box1[i] > box2[i]) {
                box1Count++;
            }
        }

        if (box1Count == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (box2Count == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }

    }
}