package battleship;

public enum Messages {
    ERROR_WRONG_COORDINATES("Error! You entered the wrong coordinates! Try again:\n"),
    ERROR_BOAT_IS_TOO_CLOSE("Error! You placed it too close to another one. Try again:\n"),
    ERROR_WRONG_BOAT_LOCATION("Error! Wrong ship location! Try again:\n"),

    INFO_HIT("You hit a ship!\n"),
    INFO_MISS("You missed!\n"),
    INFO_SHIP_SUNK("You sank a ship! Specify a new target:\n"),
    INFO_GAME_START("The game starts!\n"),
    INFO_TAKE_SHOT("Take a shot!\n"),
    INFO_TURN(", it's your turn:\n"),
    INFO_GAME_END("You sank the last ship. You won. Congratulations!\n"),

    INFO_PLAYER_ONE_PLACE_SHIPS("Player 1, place your ships on the game field\n"),

    INFO_PLAYER_TWO_PLACE_SHIPS("Player 2, place your ships on the game field\n"),

    INFO_PRESS_ENTER("Press Enter and pass the move to another player\n");

    private final String message;
    Messages(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
