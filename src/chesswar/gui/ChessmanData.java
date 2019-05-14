package chesswar.gui;

import chesswar.entity.ChessType;
import chesswar.entity.Chessman;
import chesswar.mechanic.Player;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChessmanData extends VBox {

    public static String ALLY = "ALLY";
    public static String ENEMY = "ENEMY";
    private static String NOT_AVAILABLE = "N/A";
    private Player thisTurnPlayer;
    private Chessman chessman;
    private Label side;
    private Label type;
    private Label attackType;
    private Label hp;
    private Label attack;
    private Label defense;

    public ChessmanData() {
        side = new Label();
        type = new Label();
        attackType = new Label();
        hp = new Label();
        attack = new Label();
        defense = new Label();
        update();
    }


    public void update() {
        getChildren().removeAll();
        try {
            if(chessman.isAlly(thisTurnPlayer)){
                side.setText(ALLY);
            } else {
                side.setText(ENEMY);
            }
            type.setText("Type: " + chessman.getChessType());
            attackType.setText("Attack Type: " + chessman.getAttackType());
            hp.setText("HP: " + chessman.getHp());
            attack.setText("ATK: " + chessman.getDamage());
            defense.setText("DEF: " + chessman.getDefense());
            getChildren().addAll(side, type, attackType, hp, attack, defense);
        } catch (NullPointerException e) {
            side.setText("N/A");
            getChildren().add(side);
        }
    }

    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
        update();
    }

    public Player getThisTurnPlayer() {
        return thisTurnPlayer;
    }

    public void setThisTurnPlayer(Player thisTurnPlayer) {
        this.thisTurnPlayer = thisTurnPlayer;
    }
}
