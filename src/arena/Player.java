package arena;

import entity.Chessman;
import entity.component.King;

import java.util.ArrayList;

public class Player {

    private String name;
    private King king;
    private ArrayList<Chessman> Chessmen;

    public Player(String name) {
        this.name = name;
    }

    public boolean isAlive(){
        return king.isAlive();
    }
}
