package entity.movebehavior;

import arena.Field;

public class PawnMoveBehavior implements MoveBehavior{

   //TODO: constant that about how to move
    public PawnMoveBehavior(){

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
