package io.github.aretche.griffonWebSocket;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * Created by arellanog on 31/10/17.
 */
public class MyListenerStompSessionHandler extends StompSessionHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(MyListenerStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("Se estableció la sesión: " + session.getSessionId());
        session.subscribe("/topic/hello", this);
        logger.info("Subscripto a /topic/hello");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Se produjo la excepción: ", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        String msg = (String) payload;
        logger.info("Recibido : " + msg);
    }
}
