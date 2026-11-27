package at.edu.c02.puzzleroom.commands;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.Player;
import at.edu.c02.puzzleroom.exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This command moves the player several steps in a row.
 * Arguments: u (up), d (down), l (left), r (right)
 * Example usage: `fastmove d r r u`
 * <p>
 * The board is shown only once, after the last successful move.
 * If a move is blocked, a PuzzleRoomInvalidMoveException is thrown:
 * moves that already succeeded stay in effect, the remaining moves are skipped.
 */
public class CommandFastmove implements Command {
    private final List<Direction> directions = new ArrayList<>();

    public CommandFastmove(String[] arguments) throws PuzzleRoomException {
        if (arguments.length == 0) {
            throw new PuzzleRoomInvalidArgumentsException();
        }
        // Parse all arguments before any move is executed, so that a typo
        // (e.g. `fastmove d x`) does not leave the player half-way through
        for (String argument : arguments) {
            directions.add(switch (argument) {
                case "u" -> Direction.Up;
                case "d" -> Direction.Down;
                case "l" -> Direction.Left;
                case "r" -> Direction.Right;
                default -> throw new PuzzleRoomInvalidArgumentsException();
            });
        }
    }

    public void execute(GameBoard gameBoard) throws PuzzleRoomException {
        Player player = gameBoard.getPlayer();
        if (player == null) {
            throw new PuzzleRoomInvalidMoveException();
        }

        for (Direction direction : directions) {
            // Call the player directly instead of CommandMove,
            // because CommandMove shows the board after every single step
            boolean success = switch (direction) {
                case Up -> player.moveUp();
                case Down -> player.moveDown();
                case Left -> player.moveLeft();
                case Right -> player.moveRight();
            };
            if (!success) {
                // Leaves the loop: earlier moves stay, later moves are skipped
                throw new PuzzleRoomInvalidMoveException();
            }
        }

        // Show the board exactly once, after the last move
        new CommandShow().execute(gameBoard);
    }
}