package chesswar.mechanic.event;

import chesswar.mechanic.Player;

public class TurnEndEvent implements Event {

    /** Player of the turn ended*/
    private Player player;

    public TurnEndEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
