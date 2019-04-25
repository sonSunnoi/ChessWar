package chesswar.mechanic.board;

import chesswar.entity.Chessman;
import chesswar.gui.FieldGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Field {

    private Chessman chessman;

    private boolean isHighlight;
    private FieldGUI fieldGUI;

    public Field() {
        isHighlight = false;
    }

    public Field(FieldGUI fieldGUI) {
        this.fieldGUI = fieldGUI;
        fieldGUI.setField(this);

    }

    public void highlight(Highlight highlight) {
        isHighlight = true;
        switch (highlight) {
            case MOVE:
                fieldGUI.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
                break;
            case ATTACK:
                fieldGUI.setBackground(new Background(new BackgroundFill(Color.TOMATO, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void unhighlight() {
        isHighlight = false;
        fieldGUI.setBackground(new Background(new BackgroundFill(fieldGUI.getDefaultColor(), CornerRadii.EMPTY, Insets.EMPTY)));

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
}
