package chesswar.gui;

import chesswar.mechanic.turn.TurnController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TurnControllerGUI extends HBox {

    public static final String UNDO_MESSAGE = "Undo";
    public static final String CONFIRM_MESSAGE = "Confirm";
    public static final String SHOW_TURN_COST_FORMAT_MESSAGE = "%d/%d";

    private Button undoButton;
    private Button confirmButton; //confirm or Endturn button
    private Label showTurnCost;
    private TurnController turnController;

    public TurnControllerGUI(TurnController turnController) {
        this.turnController = turnController;
        undoButton = new Button(UNDO_MESSAGE);
        showTurnCost = new Label();
        confirmButton = new Button(CONFIRM_MESSAGE);

        setSpacing(23);
        setPadding(new Insets(10));
        setHeight(50);
        setMaxWidth(250);
        setMinWidth(250);
        showTurnCost.setMinWidth(35);
        showTurnCost.setMaxWidth(35);
        getChildren().addAll(undoButton, showTurnCost, confirmButton);
        showTurnCost.setPadding(new Insets(5,0,0,0));
        showTurnCost.setText(String.format("0/%d", turnController.getTurn().MAX_TURN_COST));
    }

    public void update() {
        showTurnCost.setText(String.format("%d/%d",
                turnController.getTurn().getTurnCost(),
                turnController.getTurn().MAX_TURN_COST));
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
