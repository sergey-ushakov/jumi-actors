package fi.jumi.actors.generator.reference.dummyListener;

import fi.jumi.actors.eventizers.Event;
import fi.jumi.actors.generator.DummyListener;
import fi.jumi.actors.queue.MessageSender;

public class EventToDummyListener implements MessageSender<Event<DummyListener>> {

    private final fi.jumi.actors.generator.DummyListener listener;

    public EventToDummyListener(fi.jumi.actors.generator.DummyListener listener) {
        this.listener = listener;
    }

    public void send(Event<DummyListener> message) {
        message.fireOn(listener);
    }
}
