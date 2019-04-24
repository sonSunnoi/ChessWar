package mechanic;

import entity.Chessman;
import gui.FieldGUI;

import java.util.ArrayList;

public class Field {

    private Chessman chessman;
    private boolean moveHighlight;
    private boolean attackHighlight;
    private FieldGUI fieldGUI;

    public Field(){
        moveHighlight = false;
        attackHighlight = false;
    }

    public Field(Chessman chessman){
        this.chessman = chessman;
    }


}
