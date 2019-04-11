package entity.attribute;

import arena.Player;
import entity.Chessman;
import entity.component.ChessmanEntity;

public abstract class ChessmanPerk extends Chessman {

    protected ChessmanEntity chessmanEntity;

    public ChessmanPerk(Chessman chessman){
        this.chessman = chessman.
    }

    public ChessmanEntity getChessman(){
        return this.chessman;
    }

}
