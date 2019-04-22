package entity.movementbehavior;

import arena.Field;

public class PawnMovementBehavior implements MovementBehavior {

   //TODO: constant that about how to move
    public PawnMovementBehavior(){

    }

    @Override
    public boolean isMoveable() {
        return false;
    }

    @Override
    public Field move() {
        return null;
    }
}
