package chesswar.mechanic.turn;

import chesswar.gui.TurnControllerGUI;
import chesswar.mechanic.event.*;
import chesswar.mechanic.listener.Listener;

public class TurnController implements Listener {

    private Turn turn;
    private TurnControllerGUI turnControllerGUI;
    private EventSystem eventSystem;

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

        if(turn.getTurnCost() > 0 && turn.getTurnCost() < Turn.MAX_TURN_COST){
            turnControllerGUI.getUndoButton().setDisable(false);
        } else if (turn.getTurnCost() == 0) {
            turnControllerGUI.getUndoButton().setDisable(true);
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

    public void setEventSystem(EventSystem eventSystem) {
        if(eventSystem == null)
            this.eventSystem = eventSystem;
    }
}
