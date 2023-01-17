package battleship;

public class WrongBoatSizeException extends Exception {
    public WrongBoatSizeException(String errorMessage) {
        super(errorMessage.toString());
    }
}

