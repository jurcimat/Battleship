import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int i = 0;
        int sum = 0;
        while (i < length){
            array[i] = scanner.nextInt();
            i++;
        }
        int greaterThan = scanner.nextInt();
        for (int j : array) {
            if (j > greaterThan) {
                sum += j;
            }
        }
        System.out.println(sum);



    }
}