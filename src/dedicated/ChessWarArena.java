package dedicated;

import arena.Player;

import java.util.ArrayList;
import java.util.Stack;

public class ChessWarArena implements Runnable {

    private Stack<GameState> gameStates;
    private Player black; //player1
    private Player white; //player2

    public ChessWarArena(){
        gameStates = new Stack<GameState>();
        black = new Player("B");
        gameStates.push(new GameState())

    }

    @Override
    public void run() {

        while(true) {


        }
    }

    private void
    //Can make a whole game a thread?
}
