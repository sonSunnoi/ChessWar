import mechanic.event.Event;
import mechanic.event.EventHandler;
import mechanic.listener.Listener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class EventSystem {
    private List<Listener> listeners;

    public EventSystem() {
        this.listeners = new ArrayList<>();
    }

    public void register(Listener listener) {
        listeners.add(listener);
    }

    public void dispatch(Event event) {
        for (Listener listener : listeners) {
            Method[] methods = listener.getClass().getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(EventHandler.class)) {
                    try {
                        invokeListener(listener, m, event);
                    } catch (Exception e) {
                        System.err.println("Exception while trying to pass an mechanic.event to the listener!");
                        System.err.println("Event: " + event.getClass().getSimpleName() +
                                ", Listener: " + listener.getClass().getSimpleName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void invokeListener(Listener listener, Method method, Event event) throws Exception {
        if (method.getParameterCount() != 1) {
            throw new Exception("Parameter count does not equals one");
        }
        Class<?> clazz = method.getParameterTypes()[0];
        if (clazz == event.getClass()) {
            method.invoke(listener, event);
        }
    }
}
