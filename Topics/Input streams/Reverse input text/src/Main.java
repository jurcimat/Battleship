import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        int charAsNumber = reader.read();
        ArrayList<String> input = new ArrayList<String>();
        while(charAsNumber != -1) {
            String character = String.valueOf((char) charAsNumber);
            input.add(character);
            charAsNumber = reader.read();
        }
        reader.close();
        for (int i = input.size() - 1; i >= 0; i--) {
            System.out.print(input.get(i));
        }
    }
}