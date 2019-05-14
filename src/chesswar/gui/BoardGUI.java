package chesswar.gui;

import chesswar.mechanic.Position;
import chesswar.mechanic.board.Board;
import chesswar.mechanic.board.Field;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class BoardGUI extends GridPane {

    private Board renderBoard;

    public BoardGUI(Board board) {
        renderBoard = board;
        setAlignment(Pos.BOTTOM_CENTER);
        setMaxHeight(30*Board.BOARD_SIZE);
        setMaxWidth(30*Board.BOARD_SIZE);
        for (int y = 0; y < Board.BOARD_SIZE; y++) {
            for (int x = 0; x < Board.BOARD_SIZE; x++) {
                add(renderBoard.getField(new Position(x + 1, y + 1)).getFieldGUI(),x,y);
            }
        }
    }

    public void update(){
        for (int y = 0; y < Board.BOARD_SIZE; y++) {
            for (int x = 0; x < Board.BOARD_SIZE; x++) {
                Field field = renderBoard.getField(new Position(x + 1, y + 1));
                field.getFieldGUI().update();
            }
        }
    }
}
