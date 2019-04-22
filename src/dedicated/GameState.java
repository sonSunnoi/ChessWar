package dedicated;

import arena.Board;
import arena.Player;

public class GameState {

    private int turnCount;
    private EventSystem eventSystem;
    private Player black;
    private Player white;
    private Board board;

    public GameState(int turnCount, Player black, Player white, Board board) {
        this.turnCount = turnCount;
        this.black = black;
        this.white = white;
        this.board = board;
    }

    pub

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }
}
