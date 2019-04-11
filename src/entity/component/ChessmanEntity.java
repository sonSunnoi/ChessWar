package entity.component;

import arena.Player;
import entity.Chessman;

public abstract class ChessmanEntity extends Chessman {

    public ChessmanEntity(Player owner) {
        super(owner);
    }

}
