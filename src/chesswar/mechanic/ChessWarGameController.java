package chesswar.mechanic;

import chesswar.mechanic.board.BoardController;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.listener.ChessWarListener;
import chesswar.mechanic.turn.TurnController;

public class ChessWarGameController {

    private EventSystem eventSystem;
    private TurnController turnController;
    private BoardController boardController;
    private ChessWarListener chessWarListener;

    public ChessWarGameController() {
        eventSystem = new EventSystem();
        turnController = new TurnController();
        boardController = new BoardController();
        chessWarListener = new ChessWarListener();
        eventSystem.register(turnController);
        eventSystem.register(boardController);
        eventSystem.register(chessWarListener);
    }


}
