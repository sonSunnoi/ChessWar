package chesswar.mechanic;

import chesswar.entity.Chessman;
import chesswar.entity.King;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
