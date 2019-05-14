package chesswar.mechanic.turn;

import chesswar.gui.TurnControllerGUI;
import chesswar.mechanic.event.*;
import chesswar.mechanic.listener.Listener;

public class TurnController implements Listener {

    private Turn turn;
    private TurnControllerGUI turnControllerGUI;
    private EventSystem eventSystem;

    public TurnController(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
        this.turnControllerGUI = new TurnControllerGUI(this);
        turnControllerGUI.getUndoButton().setDisable(true);
        turnControllerGUI.getConfirmButton().setDisable(true);
    }

    /**
     * use for new turn
     */

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public void update() {
        turnControllerGUI.update();
        if(turn.getTurnCost() > 0 && turn.getTurnCost() < Turn.MAX_TURN_COST){
            turnControllerGUI.getUndoButton().setDisable(false);
            turnControllerGUI.getConfirmButton().setDisable(true);
        } else if (turn.getTurnCost() == 0) {
            turnControllerGUI.getUndoButton().setDisable(true);
            turnControllerGUI.getConfirmButton().setDisable(true);

        } else if (turn.getTurnCost() == Turn.MAX_TURN_COST) {
            eventSystem.dispatch(new ReachTurnEndEvent());
        }

        turnControllerGUI.getShowTurnCost().
                setText(String.format(turnControllerGUI.SHOW_TURN_COST_FORMAT_MESSAGE, turn.getTurnCost(), Turn.MAX_TURN_COST));

    }

    @EventHandler
    public void onReachTurnEndEvent(ReachTurnEndEvent event) {
        turnControllerGUI.getConfirmButton().setDisable(false);
    }

    @EventHandler
    public void onTurnEndEvent(TurnEndEvent event){
        turnControllerGUI.getUndoButton().setDisable(true);
        turnControllerGUI.getConfirmButton().setDisable(true);
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public Turn getTurn() {
        return turn;
    }

    public TurnControllerGUI getTurnControllerGUI() {
        return turnControllerGUI;
    }
}
