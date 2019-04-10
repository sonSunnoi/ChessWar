package chessman;

import arena.Player;
import chessman.ChessMoveBehavior.MoveBehavior;

public abstract class Chessman {

    protected MoveBehavior moveBehavior;
    protected Player owner;

    public Player getOwner(){
        return owner;
    }

    public abstract Chessman copy();
}
