package entity.component;

import arena.Player;
import entity.Chessman;

public abstract class ChessmanEntity extends Chessman {

    protected Player owner;

    public ChessmanEntity(Player owner) {
        this.owner = owner;
    }

}
