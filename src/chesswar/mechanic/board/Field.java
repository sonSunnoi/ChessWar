package chesswar.mechanic.board;

import chesswar.entity.Chessman;
import chesswar.gui.FieldGUI;
import chesswar.mechanic.Position;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.event.FieldClickEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Field {

    private Chessman chessman;
    private Position position;
    private boolean isHighlight;
    private FieldGUI fieldGUI;
    private Highlight highlight;


    public Field() {
        isHighlight = false;
    }

    public Field(FieldGUI fieldGUI, Position position, EventSystem eventSystem) {
        this.position = position;
        this.fieldGUI = fieldGUI;
        fieldGUI.setField(this);
        setHighlight(Highlight.NONE);
    }

    public void highlight(Highlight highlight) {
        isHighlight = true;
        setHighlight(highlight);
    }

    public Highlight getHighlight() {
        return highlight;
    }

    public void setHighlight(Highlight highlight) {
        this.highlight = highlight;
        switch (getHighlight()) {
            case MOVE:
                fieldGUI.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
                break;
            case ATTACK:
                fieldGUI.setBackground(new Background(new BackgroundFill(Color.TOMATO, CornerRadii.EMPTY, Insets.EMPTY)));
                break;
            case SELF:
                fieldGUI.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
                break;
            case NONE:
                fieldGUI.setBackground(new Background(new BackgroundFill(fieldGUI.getDefaultColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void unhighlight() {
        isHighlight = false;
        setHighlight(Highlight.NONE);
    }



    public FieldGUI getFieldGUI() {
        return fieldGUI;
    }

    public void setFieldGUI(FieldGUI fieldGUI) {
        this.fieldGUI = fieldGUI;
    }

    public boolean isHighlight() {
        return isHighlight;
    }


    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
    }

    public Position getPosition() {
        return position;
    }
}
