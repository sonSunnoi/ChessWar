package chesswar.mechanic.board;

import chesswar.gui.BoardGUI;
import chesswar.gui.FieldGUI;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.event.FieldClickEvent;
import javafx.scene.paint.Color;
import chesswar.mechanic.Position;

//one object per one stage in the board
public final class Board {

    private Field[][] board;
    private EventSystem eventSystem;
    public static int BOARD_SIZE = 12;

    /**
     * Board Contains field that held Chessman
     */

    public Board(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
        board = new Field[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                switch ((x + y) % 2) {
                    case 0:
                        board[y][x] = new Field(new FieldGUI(Color.SNOW), new Position(x + 1, y + 1), eventSystem);
                        break;
                    case 1:
                        board[y][x] = new Field(new FieldGUI(Color.DARKGREY), new Position(x + 1, y + 1), eventSystem);
                        break;
                }
                board[y][x].getFieldGUI().setField(board[y][x]);
                Field tempField = board[y][x];
                board[y][x].getFieldGUI().setOnAction(e -> {
                    eventSystem.dispatch(new FieldClickEvent(tempField));
                });
            }
        }
    }

    public Board(Board copyBoard) {
        this.eventSystem = copyBoard.getEventSystem();
        this.board = copyBoard.board;
    }

    public Field getField(Position position) {
        try {
            return board[position.getY() - 1][position.getX() - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }
}

