package battleship;

public class WrongCoordinatesEntered extends Exception {
    public WrongCoordinatesEntered(Messages errorMessage) {
        super(errorMessage.toString());
    }
}

