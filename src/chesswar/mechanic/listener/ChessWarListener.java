package chesswar.mechanic.listener;

import chesswar.mechanic.event.EntityAttackEvent;
import chesswar.mechanic.event.EntityMoveEvent;
import chesswar.mechanic.event.EventHandler;
import chesswar.mechanic.event.TurnEndEvent;


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
