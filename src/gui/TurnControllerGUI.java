package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TurnControllerGUI extends HBox {

    public static final String UNDO_MESSAGE = "Undo";
    public static final String CONFIRM_MESSAGE = "Confirm";
    private Button undoButton;
    private Button confirmButton; //confirm or Endturn button

    public TurnControllerGUI(){
        undoButton = new Button(UNDO_MESSAGE);
        confirmButton = new Button(CONFIRM_MESSAGE);
    }


}
