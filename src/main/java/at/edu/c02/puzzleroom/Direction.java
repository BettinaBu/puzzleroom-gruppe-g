package at.edu.c02.puzzleroom;

/**
 * An enum that represents the four directions the player can move.
 */
public enum Direction {
    Up ('^'),
    Down('v'),
    Left('<'),
    Right('>');

    private char direction;

    Direction(char direction) {

        this.direction = direction;
    }
    public char getDirection() {
        return direction;
    }
}
