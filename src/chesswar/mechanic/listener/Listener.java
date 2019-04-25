package chesswar.mechanic.listener;

import chesswar.mechanic.event.EventSystem;

public interface Listener {

    EventSystem getEventSystem();

    void setEventSystem(EventSystem e);
}
