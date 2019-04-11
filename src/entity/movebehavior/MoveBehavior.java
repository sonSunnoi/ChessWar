package entity.movebehavior;

import arena.Field;

public interface MoveBehavior {

    boolean isMoveable();
    Field move();
}
