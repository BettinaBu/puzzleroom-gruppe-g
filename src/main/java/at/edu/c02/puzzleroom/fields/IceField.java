package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;

public class IceField extends BaseField {

    protected IceField(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() throws PuzzleRoomException {

    }

    public boolean enterField(Direction direction) {

        int newRow = row;
        int newCol = col;
        Field preliminaryField = this;
        while (preliminaryField.getClass() == IceField.class) {


            if (direction.equals(Direction.Up) && gameBoard.getField(newRow - 1, newCol).getClass() != FieldWall.class) {

                newRow--;
            } else if (direction.equals(Direction.Down) && gameBoard.getField(newRow + 1, newCol).getClass() != FieldWall.class) {

                newRow++;
            } else if (direction.equals(Direction.Left) && gameBoard.getField(newRow, newCol - 1).getClass() != FieldWall.class) {

                newCol--;
            } else if (direction.equals(Direction.Right) && gameBoard.getField(newRow, newCol + 1).getClass() != FieldWall.class) {

                newCol++;
            } else {
                gameBoard.getPlayer().walkStep();
                break;
            }

            preliminaryField = gameBoard.getField(newRow, newCol);


        }

        if (preliminaryField.getClass() == IceField.class) {
            setPlayerPositionToField(newRow, newCol);
            return true;
        }else {
          return  preliminaryField.enterField(direction);
        }

    }

    @Override
    public boolean leaveField(Direction direction) {
        return true;
    }

    public boolean isIceField() {
        return true;
    }

    public void setPlayerPositionToField(int newRow, int newCol) {

        gameBoard.getPlayer().setPosition(newRow, newCol);
    }
}
