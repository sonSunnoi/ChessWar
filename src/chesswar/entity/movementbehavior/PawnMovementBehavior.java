package chesswar.entity.movementbehavior;

import chesswar.mechanic.board.Board;
import chesswar.mechanic.board.Field;
import chesswar.mechanic.Position;
import chesswar.mechanic.event.EventSystem;
import chesswar.entity.Chessman;

public class PawnMovementBehavior implements MovementBehavior {

   //TODO: constant that about how to move
    private Position[] moveablePosition;
    private Chessman chessman;
    private Board board;

    public PawnMovementBehavior(Chessman chessman,Board board) {
        this.chessman = chessman;
        this.board = board;
        moveablePosition = new Position[] {
                new Position(-1,0),
                new Position(1,0),
                new Position(0,-1),
                new Position(0,1)
        };
    }
    @Override
    public Position[] getMoveablePosition() {
        return moveablePosition;
    }

    @Override
    public boolean isMovable(Position pos) {
        try{
           if(board.getField(pos).getChessman() == null)
               return true;
        } catch (NullPointerException e){

        }
        return false;
    }

    @Override
    public Field move(Position pos) {
        if(isMovable(pos))
        return null;
    }
}
