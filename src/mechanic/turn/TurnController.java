package mechanic.turn;

import gui.TurnControllerGUI;
import mechanic.event.Listener;

public class TurnController implements Listener {

    private Turn turn;
    private TurnControllerGUI turnControllerGUI;

    public TurnController(TurnControllerGUI turnControllerGUI) {
        this.turnControllerGUI = turnControllerGUI;
    }

    /**
     * use for new turn
     */

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public void update() {

        turnControllerGUI.getUndoButton().setDisable(true);
        turnControllerGUI.getConfirmButton().setDisable(false);
        if (turn.getTurnCost() == 0) {
            turnControllerGUI.getUndoButton().setDisable(false);
        } else if (turn.getTurnCost() == turn.MAX_TURN_COST) {
            turnControllerGUI.getConfirmButton().setDisable(true);
        }

        turnControllerGUI.getShowTurnCost().
                setText(String.format(turnControllerGUI.SHOW_TURN_COST_FORMAT_MESSAGE, turn.getTurnCost(), Turn.MAX_TURN_COST));

    }
}
