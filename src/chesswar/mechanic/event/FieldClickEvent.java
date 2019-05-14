package chesswar.mechanic.event;

import chesswar.mechanic.board.Field;

public class FieldClickEvent implements Event{

    private Field field;
    private EventSystem eventSystem;
    public FieldClickEvent(Field field) {
        this.field = field;
        System.out.println(field.getPosition());
    }

    public Field getField() {
        return field;
    }

}
