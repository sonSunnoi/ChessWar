package chesswar.gui;

import chesswar.mechanic.Position;
import chesswar.mechanic.board.Board;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class BoardGUI extends GridPane {

    private Board renderBoard;

    public BoardGUI(Board board) {
        renderBoard = board;
        setAlignment(Pos.CENTER);
        setHeight(400);
        setWidth(400);
        for (int y = 0; y < Board.BOARD_SIZE; y++) {
            for (int x = 0; x < Board.BOARD_SIZE; x++) {
                add(renderBoard.getField(new Position(x + 1, y + 1)).getFieldGUI(),x,y);
            }
        }

    }
}
