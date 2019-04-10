package dedicated;

import arena.Turn;

import java.util.ArrayList;

public class GameState {

    public static GameState instance = new GameState();
    private ArrayList<Turn> turnList;
    private ArrayList<Listener> listener;
    private int turnCount;

    private Subject gameStateSubject = new Subject() {
        @Override
        public void registerObserver() {

        }

        @Override
        public void removeObserver() {

        }

        @Override
        public void notifyObserver() {

        }
    }

    private GameState(){
        turnList = new ArrayList<Turn>();
        turnCount = 0;
    };

    public boolean addTurn(Turn turn){
        gameStateSubject.notifyObserver();
        turnCount = turnList.size();
    }



}
