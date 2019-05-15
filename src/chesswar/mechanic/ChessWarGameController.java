package chesswar.mechanic;

import chesswar.mechanic.board.Highlight;
import chesswar.mechanic.event.EventHandler;
import chesswar.mechanic.event.FieldClickEvent;
import chesswar.mechanic.event.TurnEndEvent;
import chesswar.mechanic.listener.Listener;
import chesswar.mechanic.turn.Turn;

public class ChessWarGameController implements Listener {

    private ChessWarGame chessWarGame;

    public ChessWarGameController() {
        chessWarGame = new ChessWarGame();
        chessWarGame.getEventSystem().register(this);
        chessWarGame.getTurnController().getTurnControllerGUI().getUndoButton().setOnAction(event -> {
            chessWarGame.getTurnController().getTurn().unexecuteCommand();
            update();
        });
        chessWarGame.getTurnController().getTurnControllerGUI().getConfirmButton().setOnAction(event -> {
            chessWarGame.getEventSystem().dispatch(new TurnEndEvent(chessWarGame.getTurnController().getTurn().getPlayer()));
        });
        chessWarGame.getChessmanDataFirst().setThisTurnPlayer(chessWarGame.getTurnController().getTurn().getPlayer());
        chessWarGame.getChessmanDataSecond().setThisTurnPlayer(chessWarGame.getTurnController().getTurn().getPlayer());
    }


    @EventHandler
    public void onFieldClickEvent(FieldClickEvent event) {
        Position click = event.getField().getPosition();
        if (chessWarGame.getCacheFirstActionPosition() == null) {

            chessWarGame.setFirstAction(click);
            chessWarGame.getChessmanDataFirst().setChessman(event.getField().getChessman());
//            System.out.println("First");

        } else if (chessWarGame.getCacheSecondActionPosition() == null
                && event.getField().getHighlight() != Highlight.SELF
                && event.getField().getHighlight() != Highlight.NONE) {

            chessWarGame.setCacheSecondActionPosition(click);
            if(chessWarGame.getChessmanDataFirst().getChessman() != event.getField().getChessman())
                chessWarGame.getChessmanDataSecond().setChessman(event.getField().getChessman());
//            System.out.println("waiting");

        } else if (chessWarGame.getCacheSecondActionPosition() == click) {

            chessWarGame.setConfirmed(true);
            chessWarGame.setCacheSecondActionPosition(click);
            chessWarGame.setSecondAction(click);
            chessWarGame.resetAction();
            chessWarGame.getChessmanDataFirst().setChessman(null);
            chessWarGame.getChessmanDataSecond().setChessman(null);
//            System.out.println("action");

        } else {

            chessWarGame.resetAction();
            chessWarGame.getChessmanDataFirst().setChessman(null);
            chessWarGame.getChessmanDataSecond().setChessman(null);
//            System.out.println("cancelled");

        }
        chessWarGame.getTurnController().update();
        chessWarGame.getBoardController().getBoardGUI().update();

    }

    public void update(){
        chessWarGame.getTurnController().update();
        chessWarGame.getBoardController().getBoardGUI().update();
        chessWarGame.getChessmanDataFirst().setChessman(null);
        chessWarGame.getChessmanDataSecond().setChessman(null);
    }
    @EventHandler
    public void onTurnEndEvent(TurnEndEvent event) {
        Player player;
        if(event.getPlayer().equals(new Player("White"))){
            player = new Player("Black");
        } else {
            player = new Player("White");
        }
        chessWarGame.getTurnController().setTurn(new Turn(player));
        chessWarGame.getChessmanDataFirst().setThisTurnPlayer(player);
        chessWarGame.getChessmanDataSecond().setThisTurnPlayer(player);
        chessWarGame.getPlayerAndChess().get(event.getPlayer()).stream().forEach(chessman -> {
            chessman.setMoved(false);
            chessman.setAttacked(false);
        });
        update();
    }

    public ChessWarGame getChessWarGame() {
        return chessWarGame;
    }
}
