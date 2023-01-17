package battleship;


import static java.lang.Math.abs;

public class Board {
    int boardSize = 10;
    String[][] board;

    public Board(){
        this.createBoard();
        this.printBoard(false);
    }

    private void createBoard(){
        this.board = new String[][] {
                { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                { "A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                { "J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        };
    }
    public void printBoard(boolean fog){
        for (int i = 0; i < this.boardSize + 1; i++){
            for (int j = 0; j < this.boardSize + 1; j++){
                if (fog) {
                    if (this.board[i][j].equals("O")) {
                        System.out.print("~ ");
                    } else {
                        System.out.print(this.board[i][j] + " ");
                    }
                } else {
                    System.out.print(this.board[i][j] + " ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
    protected boolean isOnBoard(int x, int y) {
        return (x <= 10 && x >= 1) && (y <= 10 && y >= 1);
    }

    private boolean isFree(int x, int y) {
        if (this.isOnBoard(x, y)) {
            return !("O".equals(this.board[y][x]));
        }
        return true;
    }

    protected void checkBoatSize(int x1, int y1, int x2, int y2, int length, String boat) throws WrongBoatSizeException {
        if (x1 == x2) {
            if (abs(y2 - y1) + 1 != length) {
                throw new WrongBoatSizeException("Error! Wrong length of the " + boat + " ! Try again:\n");
            }
        } else {
            if (abs(x2 - x1) + 1 != length) {
                throw new WrongBoatSizeException("Error! Wrong length of the " + boat + " ! Try again:\n");
            }
        }

    }

    protected void checkPosition(int x1, int y1, int x2, int y2) throws WrongBoatPositionException{
        if (!(x1 == x2 || y1 == y2)) {
            throw new WrongBoatPositionException(Messages.ERROR_WRONG_BOAT_LOCATION);
        }
        this.checkSurroundings(x1, y1, x2, y2);

    }

    private void checkSurroundings(int x1, int y1, int x2, int y2) throws WrongBoatPositionException{
        boolean checkLeft, checkRight, checkMiddle, checkUp, checkDown;
        if (x1 == x2) {
            for (int i = y1; i < y2; i++) {
                checkLeft = this.isFree(x1 - 1, i);
                checkMiddle = this.isFree(x1, i);
                checkRight = this.isFree(x1 + 1, i);
                if (!(checkLeft && checkMiddle && checkRight)) {
                    throw new WrongBoatPositionException(Messages.ERROR_BOAT_IS_TOO_CLOSE);
                }
            }
            checkUp = this.isFree(x1,y1 - 1);
            checkDown = this.isFree(x1, y2 + 1);
            if (!(checkUp && checkDown)) {
                throw new WrongBoatPositionException(Messages.ERROR_BOAT_IS_TOO_CLOSE);
            }
        } else {
            for (int i = x1; i < x2; i++) {
                checkUp = this.isFree(i,y1 - 1);
                checkMiddle = this.isFree(i, y1);
                checkDown = this.isFree(i, y2);
                if (!(checkUp && checkMiddle && checkDown)) {
                    throw new WrongBoatPositionException(Messages.ERROR_BOAT_IS_TOO_CLOSE);
                }
                checkLeft = this.isFree(x1 - 1, y1);
                checkRight = this.isFree(x2 + 1, y2);
                if (!(checkLeft && checkRight)) {
                    throw new WrongBoatPositionException(Messages.ERROR_BOAT_IS_TOO_CLOSE);
                }

            }
        }
    }

    protected boolean writeBoatToBoard(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++){
                this.board[i][x1] = "O";
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++){
                this.board[y1][i] = "O";
            }
        }
        return true;
    }
    private boolean isShipSunk(int x, int y) {
        int[] xCoords = {x, x + 1, x, x - 1};
        int[] yCoords = {y + 1, y, y - 1, y};
        for (int i = 0; i < 4; i++) {
            if (isOnBoard(xCoords[i], yCoords[i])) {
                if (this.board[yCoords[i]][xCoords[i]].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean shipExists() {
        for (int y = 1; y <= this.boardSize; y++) {
            for (int x = 1; x <= this.boardSize; x++) {
                if (this.board[y][x].equals("O")){
                    return true;
                }
            }
        }
        return false;
    }

    public void checkHit(int x, int y) {
        if (this.board[y][x].equals("O") || this.board[y][x].equals("X")) {
            this.board[y][x] = "X";
            if (this.isShipSunk(x, y)) {
                System.out.println(Messages.INFO_SHIP_SUNK);
            } else {
                System.out.println(Messages.INFO_HIT);
            }

            //this.printBoard(true);

        } else {
            this.board[y][x] = "M";
            //this.printBoard(true);
            System.out.println(Messages.INFO_MISS);
        }
        //this.printBoard(true);
    }
}
