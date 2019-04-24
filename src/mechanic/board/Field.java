package mechanic.board;

import entity.Chessman;
import gui.FieldGUI;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Field {

    private Chessman chessman;
    private boolean isHighlight;
    private FieldGUI fieldGUI;

    public Field() {
        isHighlight = false;
    }

    public Field(FieldGUI fieldGUI) {
        this.fieldGUI = fieldGUI;
    }

    public void highlight(Highlight highlight) {
        isHighlight = true;
        switch (highlight) {
            //TODO: implement color in GUI
        }
    }

    public void unhighlight() {
        isHighlight = false;
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

}
