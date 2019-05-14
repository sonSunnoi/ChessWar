package chesswar.mechanic;

import chesswar.mechanic.board.Highlight;
import chesswar.mechanic.event.EventHandler;
import chesswar.mechanic.event.FieldClickEvent;
import chesswar.mechanic.event.TurnEndEvent;
import chesswar.mechanic.listener.Listener;

public class ChessWarGameController implements Listener {

    private ChessWarGame chessWarGame;

    public ChessWarGameController() {
        chessWarGame = new ChessWarGame();
        chessWarGame.getEventSystem().register(this);
    }


    @EventHandler
    public void onFieldClickEvent(FieldClickEvent event) {
        Position click = event.getField().getPosition();
        if (chessWarGame.getCacheFirstActionPosition() == null) {
            chessWarGame.setFirstAction(click);
            System.out.println("First");
        } else if (chessWarGame.getCacheSecondActionPosition() == null
                && event.getField().getHighlight() != Highlight.SELF
                && event.getField().getHighlight() != Highlight.NONE) {
            chessWarGame.setCacheSecondActionPosition(click);
            System.out.println("waiting");
        } else if (chessWarGame.getCacheSecondActionPosition() == click) {
            chessWarGame.setConfirmed(true);
            chessWarGame.setCacheSecondActionPosition(click);
            chessWarGame.setSecondAction(click);
            chessWarGame.resetAction();
            System.out.println("action");
        } else {
            chessWarGame.resetAction();
            System.out.println("cancelled");
        }
        chessWarGame.getTurnController().update();
    }

    @EventHandler
    public void onTurnEndEvent(TurnEndEvent event) {

    }

    public ChessWarGame getChessWarGame() {
        return chessWarGame;
    }
}
