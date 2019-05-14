package chesswar.mechanic.board;

import chesswar.gui.BoardGUI;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.listener.Listener;

public class BoardController implements Listener {

    private Board board;
    private BoardGUI boardGUI;
    private EventSystem eventSystem;

    public BoardController(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
        board = new Board(eventSystem);
        boardGUI = new BoardGUI(board);
    }

    public void update() {

    }

    public Board getBoard() {
        return board;
    }

    public BoardGUI getBoardGUI() {
        return boardGUI;
    }
}
