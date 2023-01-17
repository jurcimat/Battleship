package battleship;

public class WrongBoatPositionException extends Exception{
    public WrongBoatPositionException(Messages errorMessage) {
        super(errorMessage.toString());
    }
}
