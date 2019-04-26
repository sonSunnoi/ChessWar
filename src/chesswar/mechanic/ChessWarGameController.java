package chesswar.mechanic;

import chesswar.entity.AttackType;
import chesswar.entity.Chessman;
import chesswar.mechanic.board.BoardController;
import chesswar.mechanic.board.Field;
import chesswar.mechanic.board.Highlight;
import chesswar.mechanic.command.MeleeAttackCommand;
import chesswar.mechanic.command.MeleeMoveCommand;
import chesswar.mechanic.command.RangeAttackCommand;
import chesswar.mechanic.command.RangeMoveCommand;
import chesswar.mechanic.event.EntityAttackEvent;
import chesswar.mechanic.event.EntityMoveEvent;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.listener.ChessWarListener;
import chesswar.mechanic.listener.Listener;
import chesswar.mechanic.turn.TurnController;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessWarGameController implements Listener {

    private EventSystem eventSystem;
    private TurnController turnController;
    private BoardController boardController;
    private ChessWarListener chessWarListener;

    private

    public ChessWarGameController() {
        eventSystem = new EventSystem();
        turnController = new TurnController();
        boardController = new BoardController(eventSystem);
        chessWarListener = new ChessWarListener();
        eventSystem.register(turnController);
        eventSystem.register(boardController);
        eventSystem.register(chessWarListener);
        eventSystem.register(this);
    }

    public void init() {


    }

    private ArrayList<Position> cacheHighlightPosition;
    private Position cacheFirstActionPosition;
    private Position cacheSecondActionPosition;

    public void showChessmanAction(Position position) {
        cacheFirstActionPosition = position;
        Field field = boardController.getBoard().getField(position); //field of clicked position
        Chessman chessman = field.getChessman(); //chessman that going to action
        if(!chessman.isAttacked()){
            Arrays.stream(chessman.getAttackBehavior().getAttackablePosition()).forEach(pos -> {
                pos = pos.sum(position);
                if (chessman.getAttackBehavior().canAttack(boardController.getBoard().getField(pos).getChessman())) {
                    boardController.getBoard().getField(pos).highlight(Highlight.ATTACK);
                    cacheHighlightPosition.add(pos);
                }
            });
        }
        if(!chessman.isMoved()){
            Arrays.stream(chessman.getMovementBehavior().getMoveablePosition()).forEach(pos -> {
                pos = pos.sum(position);
                if (chessman.getMovementBehavior().isMoveable(boardController.getBoard().getField(pos))) {
                    boardController.getBoard().getField(pos).highlight(Highlight.MOVE);
                    cacheHighlightPosition.add(pos);
                }
            });
        }
        field.highlight(Highlight.SELF);
        cacheHighlightPosition.add(position);
    }

    public void setCancelHighlight() {
        //TODO: if error change boardController.getBoard() to boardController.getBoard() render gui
        cacheHighlightPosition.stream().forEach(pos -> boardController.getBoard().getField(pos).unhighlight());
    }

    public void setAction(Position pos) {
        cacheSecondActionPosition = pos;
        switch (boardController.getBoard().getField(pos).getHighlight()) {
            case SELF:
                setCancelHighlight();
                break;
            case NONE:
                setCancelHighlight();
                break;
            case ATTACK:
                if(boardController.getBoard().getField(pos).getChessman().getAttackType() == AttackType.MELEE) {
                    turnController.getTurn().executeCommand(new MeleeAttackCommand(
                            boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                            boardController.getBoard().getField(cacheSecondActionPosition).getChessman()));
                } else {
                    turnController.getTurn().executeCommand(new RangeAttackCommand(
                            boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                            boardController.getBoard().getField(cacheSecondActionPosition).getChessman()));
                }
                eventSystem.dispatch(new EntityAttackEvent(
                        boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                        boardController.getBoard().getField(cacheSecondActionPosition).getChessman()));
                break;
            case MOVE:
                if(boardController.getBoard().getField(pos).getChessman().getAttackType() == AttackType.MELEE) {
                    turnController.getTurn().executeCommand(new MeleeMoveCommand(
                            boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                            boardController.getBoard().getField(cacheFirstActionPosition),
                            boardController.getBoard().getField(cacheSecondActionPosition)));
                } else {
                    turnController.getTurn().executeCommand(new RangeMoveCommand(
                            boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                            boardController.getBoard().getField(cacheFirstActionPosition),
                            boardController.getBoard().getField(cacheSecondActionPosition)));
                }
                eventSystem.dispatch(new EntityMoveEvent(
                        boardController.getBoard().getField(cacheFirstActionPosition).getChessman(),
                        boardController.getBoard().getField(cacheFirstActionPosition),
                        boardController.getBoard().getField(cacheSecondActionPosition)));
                break;
        }
    }

    @Override
    public EventSystem getEventSystem() {
        return null;
    }

    @Override
    public void setEventSystem(EventSystem e) {

    }

}
