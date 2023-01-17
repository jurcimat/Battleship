class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        int y = twoDimArray.length;
        int x = twoDimArray[0].length;
        for (int i = 0; i < y; i++) {
            int[] temp = new int[x];
            for (int j = 0; j < x; j++) {
                temp[x - j - 1] = twoDimArray[i][j];
            }
            twoDimArray[i] = temp;

        }
    }
}