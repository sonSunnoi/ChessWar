package chesswar.mechanic.board;

import chesswar.gui.FieldGUI;
import javafx.scene.paint.Color;
import chesswar.mechanic.Position;

//one object per one stage in the board
public final class Board {

    private Field[][] board;
    private static int BOARD_SIZE = 12;

    /**
     * Board Contains field that held Chessman
     */

    public Board() {
        board = new Field[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                switch ((x + y) % 2) {
                    case 0:
                        board[y][x] = new Field(new FieldGUI(Color.SNOW));
                }

            }
        }
    }

    public Field getField(Position position) {
        try {
            return board[position.getY()][position.getX()];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

