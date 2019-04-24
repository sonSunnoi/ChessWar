package entity.movementbehavior;

import mechanic.Field;
import mechanic.Position;
import EventSystem;
import entity.Chessman;
import exception.FieldOutOfBoardException;

public class PawnMovementBehavior implements MovementBehavior {

   //TODO: constant that about how to move
    private Position[] moveablePosition;
    private Chessman chessman;
    private EventSystem eventSystem;

    public PawnMovementBehavior(Chessman chessman, EventSystem eventSystem) {
        this.chessman = chessman;
        this.eventSystem = eventSystem;
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
            c
        } catch (FieldOutOfBoardException e){
            return false;
        }
        return false;
    }

    @Override
    public Field move(Position pos) {
        if(isMovable(pos))
        return null;
    }
}
