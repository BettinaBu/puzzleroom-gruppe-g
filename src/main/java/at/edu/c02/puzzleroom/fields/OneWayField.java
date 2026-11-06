package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;

public class OneWayField extends BaseField {
    protected OneWayField(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() throws PuzzleRoomException {

    }

    public boolean enterField(Direction direction) {
        gameBoard.getPlayer().walkStep();
        setPlayerPositionToField();
        return true;
    }

    @Override
    public boolean leaveField(Direction direction) {


        if (direction.getDirection() == super.originalName) {
            return true;
        }

        return false;
    }

}
