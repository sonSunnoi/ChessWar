package chesswar.mechanic.board;

import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.listener.Listener;

public class BoardController implements Listener {

    private Board board;
    private EventSystem eventSystem;

    public BoardController(){
        board = new Board();
    }


    @Override
    public EventSystem getEventSystem() {
        return eventSystem;
    }

    @Override
    public void setEventSystem(EventSystem eventSystem) {
        if(eventSystem == null) {
            this.eventSystem = eventSystem;
        }
    }

    public void update(){

    }
}
