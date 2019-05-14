package chesswar.mechanic;

import chesswar.entity.*;
import chesswar.gui.ChessmanData;
import chesswar.mechanic.board.BoardController;
import chesswar.mechanic.board.Field;
import chesswar.mechanic.board.Highlight;
import chesswar.mechanic.command.MeleeAttackCommand;
import chesswar.mechanic.command.MeleeMoveCommand;
import chesswar.mechanic.command.RangeAttackCommand;
import chesswar.mechanic.command.RangeMoveCommand;
import chesswar.mechanic.event.*;
import chesswar.mechanic.turn.Turn;
import chesswar.mechanic.turn.TurnController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChessWarGame {

    private EventSystem eventSystem;
    private TurnController turnController;
    private BoardController boardController;
    private HashMap<Player, ArrayList<Chessman>> playerAndChess = new HashMap<>();
    private Player black;
    private Player white;
    private boolean debugMode = false;
    private ChessmanData chessmanDataFirst;
    private ChessmanData chessmanDataSecond;

    public ChessWarGame() {
        eventSystem = new EventSystem();
        boardController = new BoardController(eventSystem);
        turnController = new TurnController(eventSystem);
        chessmanDataFirst = new ChessmanData();
        chessmanDataSecond = new ChessmanData();
        eventSystem.register(turnController);
        eventSystem.register(boardController);
        init();
    }

    private ArrayList<Position> cacheHighlightPosition;
    private Position cacheFirstActionPosition;
    private Position cacheSecondActionPosition;
    private boolean isConfirmed = true;

    public void setFirstAction(Position position) {
        Field field = boardController.getBoard().getField(position); //field of clicked position
        Chessman chessman = field.getChessman(); //chessman that going to action
        if (chessman != null && (chessman.getOwner().equals(turnController.getTurn().getPlayer()) || debugMode)) {
            cacheHighlightPosition = new ArrayList<>();
            cacheFirstActionPosition = position;
            if (!chessman.isAttacked()) {
                Arrays.stream(chessman.getAttackBehavior().getAttackablePosition()).forEach(pos -> {
                    pos = pos.sum(position);
                    try {
                        if (chessman.getAttackBehavior().canAttack(boardController.getBoard().getField(pos).getChessman())) {
                            boardController.getBoard().getField(pos).highlight(Highlight.ATTACK);
                            cacheHighlightPosition.add(pos);
                        }
                    } catch (NullPointerException e) {
                    }
                });
            }
            if (!chessman.isMoved()) {
                Arrays.stream(chessman.getMovementBehavior().getMoveablePosition()).forEach(pos -> {
                    pos = pos.sum(position);
                    if (chessman.getMovementBehavior().isMoveable(boardController.getBoard().getField(pos))) {
                        boardController.getBoard().getField(pos).highlight(Highlight.MOVE);
                        cacheHighlightPosition.add(pos);
                    }
                });
            }
            //debug bishop by concrete
            if (chessman.getChessType() == ChessType.BISHOP) {
                if (!cacheHighlightPosition.contains(field.getPosition().sum(new Position(1, 1)))) {
                    boardController.getBoard().getField(cacheHighlightPosition.get(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(2, 2))))).unhighlight();
                    cacheHighlightPosition.remove(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(2, 2))));
                }
                if (!cacheHighlightPosition.contains(field.getPosition().sum(new Position(-1, 1)))) {
                    boardController.getBoard().getField(cacheHighlightPosition.get(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(-2, 2))))).unhighlight();
                    cacheHighlightPosition.remove(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(-2, 2))));
                }
                if (!cacheHighlightPosition.contains(field.getPosition().sum(new Position(1, -1)))) {
                    boardController.getBoard().getField(cacheHighlightPosition.get(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(2, -2))))).unhighlight();
                    cacheHighlightPosition.remove(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(2, -2))));
                }
                if (!cacheHighlightPosition.contains(field.getPosition().sum(new Position(-1, -1)))) {
                    boardController.getBoard().getField(cacheHighlightPosition.get(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(-2, -2))))).unhighlight();
                    cacheHighlightPosition.remove(cacheHighlightPosition.indexOf(field.getPosition().sum(new Position(-2, -2))));
                }
            }
            field.highlight(Highlight.SELF);
            cacheHighlightPosition.add(position);
        }
    }

    public void setSecondAction(Position position) {
        Field field = boardController.getBoard().getField(position); //field of clicked position
        Chessman chessman = boardController.getBoard().getField(cacheFirstActionPosition).getChessman(); //chessman that going to action
        cacheSecondActionPosition = position;
        System.out.println(AttackType.MELEE);
        if (field.getHighlight() == Highlight.SELF || field.getHighlight() == Highlight.NONE) {
            resetAction();
        } else if (field.getHighlight() == Highlight.ATTACK) {
            if (chessman.getAttackType() == AttackType.MELEE) {
                turnController.getTurn().executeCommand(new MeleeAttackCommand(chessman, field.getChessman()));
            } else {
                turnController.getTurn().executeCommand(new RangeAttackCommand(chessman, field.getChessman()));
            }
            eventSystem.dispatch(new EntityAttackEvent(chessman, field.getChessman()));
        } else if (field.getHighlight() == Highlight.MOVE) {
            if (chessman.getAttackType() == AttackType.MELEE) {
                turnController.getTurn().executeCommand(new MeleeMoveCommand(chessman, boardController.getBoard().getField(cacheFirstActionPosition), field));
            } else {
                turnController.getTurn().executeCommand(new RangeMoveCommand(chessman, boardController.getBoard().getField(cacheFirstActionPosition), field));
            }
            eventSystem.dispatch(new EntityMoveEvent(chessman, boardController.getBoard().getField(cacheFirstActionPosition), field));
        } else {
            System.out.println("Error at setSecondAction");
        }
        if (debugMode) {
            chessman.setAttacked(false);
            chessman.setMoved(false);
            turnController.getTurn().setTurnCost(0);
        }
    }


    public void resetAction() {
        setCancelHighlight();
        cacheHighlightPosition = null;
        cacheFirstActionPosition = null;
        cacheSecondActionPosition = null;
        isConfirmed = false;
    }

    public void setCancelHighlight() {
        cacheHighlightPosition.stream().forEach(pos -> boardController.getBoard().getField(pos).unhighlight());
    }

    public void init() {
        black = new Player("Black");
        white = new Player("White");
        ArrayList<Chessman> blackChessman = new ArrayList<Chessman>();
        ArrayList<Chessman> whiteChessman = new ArrayList<Chessman>();
        turnController.setTurn(new Turn(black));
        playerAndChess.put(black, blackChessman);
        playerAndChess.put(white, whiteChessman);
        for (Player player : playerAndChess.keySet()) {
            playerAndChess.get(player).add(new King(player));
            playerAndChess.get(player).add(new Queen(player));
            playerAndChess.get(player).add(new Rook(player));
            playerAndChess.get(player).add(new Knight(player));
            playerAndChess.get(player).add(new Knight(player));
            playerAndChess.get(player).add(new Bishop(player));
            playerAndChess.get(player).add(new Bishop(player));
            playerAndChess.get(player).add(new Pawn(player));
            playerAndChess.get(player).add(new Pawn(player));
            playerAndChess.get(player).add(new Pawn(player));
            playerAndChess.get(player).add(new Pawn(player));
            playerAndChess.get(player).add(new Pawn(player));

        }
        boardController.getBoard().getField(new Position(7, 1)).setChessman(playerAndChess.get(black).get(0));
        boardController.getBoard().getField(new Position(6, 1)).setChessman(playerAndChess.get(black).get(1));
        boardController.getBoard().getField(new Position(7, 2)).setChessman(playerAndChess.get(black).get(2));
        boardController.getBoard().getField(new Position(3, 1)).setChessman(playerAndChess.get(black).get(3));
        boardController.getBoard().getField(new Position(10, 1)).setChessman(playerAndChess.get(black).get(4));
        boardController.getBoard().getField(new Position(5, 1)).setChessman(playerAndChess.get(black).get(5));
        boardController.getBoard().getField(new Position(8, 1)).setChessman(playerAndChess.get(black).get(6));
        boardController.getBoard().getField(new Position(2, 3)).setChessman(playerAndChess.get(black).get(7));
        boardController.getBoard().getField(new Position(4, 3)).setChessman(playerAndChess.get(black).get(8));
        boardController.getBoard().getField(new Position(6, 3)).setChessman(playerAndChess.get(black).get(9));
        boardController.getBoard().getField(new Position(8, 3)).setChessman(playerAndChess.get(black).get(10));
        boardController.getBoard().getField(new Position(10, 3)).setChessman(playerAndChess.get(black).get(11));

        boardController.getBoard().getField(new Position(6, 12)).setChessman(playerAndChess.get(white).get(0));
        boardController.getBoard().getField(new Position(7, 12)).setChessman(playerAndChess.get(white).get(1));
        boardController.getBoard().getField(new Position(6, 11)).setChessman(playerAndChess.get(white).get(2));
        boardController.getBoard().getField(new Position(3, 12)).setChessman(playerAndChess.get(white).get(3));
        boardController.getBoard().getField(new Position(10, 12)).setChessman(playerAndChess.get(white).get(4));
        boardController.getBoard().getField(new Position(5, 12)).setChessman(playerAndChess.get(white).get(5));
        boardController.getBoard().getField(new Position(8, 12)).setChessman(playerAndChess.get(white).get(6));
        boardController.getBoard().getField(new Position(3, 10)).setChessman(playerAndChess.get(white).get(7));
        boardController.getBoard().getField(new Position(5, 10)).setChessman(playerAndChess.get(white).get(8));
        boardController.getBoard().getField(new Position(7, 10)).setChessman(playerAndChess.get(white).get(9));
        boardController.getBoard().getField(new Position(9, 10)).setChessman(playerAndChess.get(white).get(10));
        boardController.getBoard().getField(new Position(11, 10)).setChessman(playerAndChess.get(white).get(11));

        boardController.getBoardGUI().update();
    }

    public ArrayList<Position> getCacheHighlightPosition() {
        return cacheHighlightPosition;
    }

    public void setCacheHighlightPosition(ArrayList<Position> cacheHighlightPosition) {
        this.cacheHighlightPosition = cacheHighlightPosition;
    }

    public Position getCacheFirstActionPosition() {
        return cacheFirstActionPosition;
    }

    public void setCacheFirstActionPosition(Position cacheFirstActionPosition) {
        this.cacheFirstActionPosition = cacheFirstActionPosition;
    }

    public Position getCacheSecondActionPosition() {
        return cacheSecondActionPosition;
    }

    public void setCacheSecondActionPosition(Position cacheSecondActionPosition) {
        this.cacheSecondActionPosition = cacheSecondActionPosition;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public ChessmanData getChessmanDataFirst() {
        return chessmanDataFirst;
    }

    public ChessmanData getChessmanDataSecond() {
        return chessmanDataSecond;
    }

    public HashMap<Player, ArrayList<Chessman>> getPlayerAndChess() {
        return playerAndChess;
    }
}
