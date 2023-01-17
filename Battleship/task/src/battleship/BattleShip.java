package battleship;

import java.io.IOException;
import java.util.Scanner;

public class BattleShip {

    private int[] parseInputSetBoats(String first, String second) {
        int x1, x2, y1, y2;
        int temp;
        y1 = first.charAt(0) - 64;
        y2 = second.charAt(0) - 64;
        x1 = Integer.parseInt(first.substring(1));
        x2 = Integer.parseInt(second.substring(1));
        if (y1 > y2) {
            temp = y2;
            y2 = y1;
            y1 = temp;
        }
        if (x1 > x2) {
            temp = x2;
            x2 = x1;
            x1 = temp;
        }
        return new int[] { x1, y1, x2, y2 };
    }

    private int[] parseInputTakeShot(String position, Board board) throws WrongCoordinatesEntered{
        int x,y;
        x = Integer.parseInt(position.substring(1));
        y = position.charAt(0) - 64;
        if (!board.isOnBoard(x,y)) {
            throw new WrongCoordinatesEntered(Messages.ERROR_WRONG_COORDINATES);
        }
        return new int[] {x,y};
    }

    private void setBoats(Board board)  {
        Scanner input = new Scanner(System.in);
        int x1, x2, y1, y2;
        String firstPosition;
        String secondPosition;
        String[] boats = { "Aircraft Carrier",
                "Battleship",
                "Submarine",
                "Cruiser",
                "Destroyer"};
        int[] boatsSizes = { 5, 4, 3, 3, 2};
        boolean writeSuccess;
        int [] parsedInput;
        for (int index = 0; index < 5; index++) {
            System.out.println("Enter the coordinates od the " + boats[index] + " (" + boatsSizes[index] + " cells):\n");
            firstPosition = input.next();
            secondPosition = input.next();
            System.out.println();
            parsedInput = this.parseInputSetBoats(firstPosition, secondPosition);
            x1 = parsedInput[0];
            y1 = parsedInput[1];
            x2 = parsedInput[2];
            y2 = parsedInput[3];
            writeSuccess = false;
            while (!writeSuccess) {
                try {
                    board.checkPosition(x1, y1, x2, y2);
                    board.checkBoatSize(x1, y1, x2, y2, boatsSizes[index], boats[index]);
                    writeSuccess = board.writeBoatToBoard(x1, y1, x2, y2);
                    board.printBoard(false);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    firstPosition = input.next();
                    secondPosition = input.next();
                    parsedInput = this.parseInputSetBoats(firstPosition, secondPosition);
                    x1 = parsedInput[0];
                    y1 = parsedInput[1];
                    x2 = parsedInput[2];
                    y2 = parsedInput[3];
                    System.out.println();
                }
            }
        }
    }
    private void takeShot(Board board) {
        Scanner input = new Scanner(System.in);
        String position;
        int[] coord = new int[2];
        boolean correctCoordinates = false;
        position = input.next();
        System.out.println();
        while (!correctCoordinates) {
            try {
                coord = this.parseInputTakeShot(position, board);
                correctCoordinates = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                position = input.next();
            }

        }
        board.checkHit(coord[0], coord[1]);
    }

    private void promptEnterPress() {
        //Scanner scanner = new Scanner(System.in);
        int in;
        System.out.println(Messages.INFO_PRESS_ENTER);
        while (true) {
            try {
                in = System.in.read();
                if (in == 10) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void setBoard(Messages message, Board board) {
        System.out.println(message);
        this.setBoats(board);
    }

    private void printBoards(Board boardOne, Board boardTwo, String player) {
        if (player.equals("Player 1")) {
            boardTwo.printBoard(true);
            System.out.println("---------------------");
            boardOne.printBoard(false);
        } else {
            boardOne.printBoard(true);
            System.out.println("---------------------");
            boardTwo.printBoard(false);
        }
    }
    public void play() {
        boolean playerOneWin = false;
        boolean playerTwoWin = false;
        boolean currentPlayer = false;
        int index = 0;

        Board boardOne = new Board();
        Board boardTwo = new Board();
        String[] players = new String[] {"Player 1", "Player 2"};

        this.setBoard(Messages.INFO_PLAYER_ONE_PLACE_SHIPS, boardOne);
        this.promptEnterPress();
        this.setBoard(Messages.INFO_PLAYER_TWO_PLACE_SHIPS, boardTwo);

        while (!(playerOneWin || playerTwoWin)) {
            this.promptEnterPress();
            index = (currentPlayer) ? 1 : 0;
            this.printBoards(boardOne,boardTwo,players[index]);
            System.out.println(players[index] + Messages.INFO_TURN);
            if (currentPlayer) {
                this.takeShot(boardOne);
            } else {
                this.takeShot(boardTwo);
            }
            playerOneWin = !(boardTwo.shipExists());
            playerTwoWin = !(boardOne.shipExists());
            currentPlayer = !currentPlayer;
        }
        System.out.println(Messages.INFO_GAME_END);

    }
}
