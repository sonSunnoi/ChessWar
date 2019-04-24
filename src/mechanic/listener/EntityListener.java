package mechanic.listener;

import mechanic.event.EntityAttackEvent;
import mechanic.event.EntityMoveEvent;
import mechanic.event.EventHandler;
import mechanic.listener.Listener;

public class EntityListener implements Listener {

    public EntityListener() {

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

}
