package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;

public class FieldIce extends BaseField {

    protected FieldIce(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() throws PuzzleRoomException {

    }

    public boolean enterField(Direction direction) {

        //newRow & newCol werden mit der Startposition initialisiert
        //newRow und newCol stellen dann die durchs "weiterrutschen" erreichten Koordinaten dar

        int newRow = row;
        int newCol = col;
        Field preliminaryField = this; //preliminaryField ist das durch newRow und newCol beschriebene Feld in seiner jeweiligen Ausprägung, wird mit Startposition initialisiert
        while (preliminaryField.getClass() == FieldIce.class) { //checkt Klasseneigenschaft

//Prüfung, auf die jeweilige Richtung und ob das Feld in dieser Richtung keine Mauer (=  erreichbar) ist
            //wenn Prüfung true, newRow bzw newCol dementsprechend angepasst
            if (direction.equals(Direction.Up) && gameBoard.getField(newRow - 1, newCol).getClass() != FieldWall.class) {

                newRow--;
            } else if (direction.equals(Direction.Down) && gameBoard.getField(newRow + 1, newCol).getClass() != FieldWall.class) {

                newRow++;
            } else if (direction.equals(Direction.Left) && gameBoard.getField(newRow, newCol - 1).getClass() != FieldWall.class) {

                newCol--;
            } else if (direction.equals(Direction.Right) && gameBoard.getField(newRow, newCol + 1).getClass() != FieldWall.class) {

                newCol++;
            } else {
                //wenn Prüfung fehlschlägt, also eine Mauer in Richtung ist, wird abgebrochen und der Schritt gezählt
                gameBoard.getPlayer().walkStep();
                break;
            }

            preliminaryField = gameBoard.getField(newRow, newCol);


        }

        if (preliminaryField.getClass() == FieldIce.class) {
            //Player steht auf FieldIce vor Mauer, wird dort hingesetzt und beendet
            setPlayerPositionToField(newRow, newCol);
            return true;
        }else {
            //normales Feld, weitere Aktionen vom neuen Feld aufgerufen
          return  preliminaryField.enterField(direction);
        }

    }

    @Override
    public boolean leaveField(Direction direction) {
        return true;
    }

//setzt den Player auf das nächste FieldIce
    public void setPlayerPositionToField(int newRow, int newCol) {

        gameBoard.getPlayer().setPosition(newRow, newCol);
    }
}
