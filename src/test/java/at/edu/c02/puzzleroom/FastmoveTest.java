package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandFastmove;
import at.edu.c02.puzzleroom.commands.CommandLoad;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidArgumentsException;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidMoveException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FastmoveTest {
    @Test
    public void fastmovePositiveTest() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/main/java/fastmove.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Ausgabe mitschreiben, um zu zählen, wie oft der Raum angezeigt wird
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            new CommandFastmove(new String[]{"d", "r", "r", "u"}).execute(gameBoard);
        } finally {
            System.setOut(originalOut);
        }

        // Figur ist nach 4 Schritten im Ziel
        assertTrue(gameBoard.isFinished());
        assertEquals(4, player.getStepCount());

        // Jede Anzeige enthält genau ein '*' (die Figur) -> Raum wurde genau einmal angezeigt
        assertEquals(1, output.toString().chars().filter(c -> c == '*').count());
    }

    @Test
    public void fastmoveNegativeTest() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/main/java/fastmove.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Erster Zug gelingt, zweiter trifft die Wand
        try {
            new CommandFastmove(new String[]{"d", "d", "r"}).execute(gameBoard);
            fail("PuzzleRoomInvalidMoveException erwartet");
        } catch (PuzzleRoomInvalidMoveException e) {
            // erwartet
        }

        // Figur steht eine Reihe unter dem Start, dritter Zug wurde nicht mehr ausgeführt
        assertEquals(2, player.getRow());
        assertEquals(1, player.getCol());
        assertEquals(1, player.getStepCount());
    }

    @Test(expected = PuzzleRoomInvalidArgumentsException.class)
    public void fastmoveInvalidArgumentTest() throws Exception {
        // "x" ist keine gültige Richtung -> Fehler schon beim Erstellen des Befehls
        new CommandFastmove(new String[]{"d", "x"});
    }
}