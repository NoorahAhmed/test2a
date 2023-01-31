package nl.multicode.processors;

import nl.multicode.model.request.RequestMessage;

public interface MessageProcessor {

    String process(RequestMessage message);
}
