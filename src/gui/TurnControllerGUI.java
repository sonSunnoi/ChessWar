package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class TurnControllerGUI extends HBox {

    public static final String UNDO_MESSAGE = "Undo";
    public static final String CONFIRM_MESSAGE = "Confirm";
    public static final String SHOW_TURN_COST_FORMAT_MESSAGE = "%d/%d";

    private Button undoButton;
    private Button confirmButton; //confirm or Endturn button
    private Label showTurnCost;

    public TurnControllerGUI(){
        undoButton = new Button(UNDO_MESSAGE);
        showTurnCost = new  Label();
        confirmButton = new Button(CONFIRM_MESSAGE);

        setSpacing(40);
        setPadding(new Insets(10));
        getChildren().addAll(undoButton, showTurnCost, confirmButton);
    }

    public Button getUndoButton() {
        return undoButton;
    }

    public Label getShowTurnCost() {
        return showTurnCost;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }
}
