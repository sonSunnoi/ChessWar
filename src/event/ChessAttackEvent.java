package event;

import entity.component.Chessman;

public class ChessAttackEvent implements Event {

    private Chessman attacker;
    private Chessman victim;
}
