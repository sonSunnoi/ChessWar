package mechanic.listener;

import mechanic.event.EntityAttackEvent;
import mechanic.event.EntityMoveEvent;
import mechanic.event.EventHandler;
import mechanic.event.TurnEndEvent;


public class ChessWarListener implements Listener {

    public ChessWarListener() {

    }

    @EventHandler
    public void onEntityAttack(EntityAttackEvent event) {

        //TODO: set sound
        //TODO: spawn skeleton if have time

    }

    @EventHandler
    public void onEntityMove(EntityMoveEvent event) {

        //TODO: onKingMove and give or remove buff
        //TODO: onEntityMove and give or remove
    }

    @EventHandler
    public void onTurnEnd(TurnEndEvent event){
        //TODO: change people turn
    }

}
