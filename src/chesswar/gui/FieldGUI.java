package chesswar.gui;

import chesswar.entity.Chessman;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import chesswar.mechanic.board.Field;

public class FieldGUI extends Button {

    private Chessman chessman;
    private Color defaultColor;
    private Field field;

    public FieldGUI(Color color) {
        defaultColor = color;
        this.field = field;
    }

    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }


}
