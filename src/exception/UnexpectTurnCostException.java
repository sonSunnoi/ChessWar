package exception;

import mechanic.turn.Turn;

public class UnexpectTurnCostException extends RuntimeException{

    private int value;

    public UnexpectTurnCostException(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("The cost you spend(%d) cannot exceed the limit(%d):",value , Turn.MAX_TURN_COST);
    }
}
