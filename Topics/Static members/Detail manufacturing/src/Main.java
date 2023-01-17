import java.util.Scanner;

class ManufacturingController {
    // here you may declare a field

    public static String requestProduct(String product) {
        // write your code here
    }

    public static int getNumberOfProducts() {
        // write your code here
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}