package entity.component;

import arena.Player;
import arena.Position;

public class King extends ChessmanEntity {


    public King(Player owner, Position pos) {
        super(owner, pos);
    }

    public King(Player owner, int x, int y) {
        super(owner, x, y);
    }


}
