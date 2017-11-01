package io.github.aretche.griffonWebSocket

import griffon.core.artifact.GriffonService
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import org.springframework.web.socket.sockjs.client.SockJsClient
import org.springframework.web.socket.sockjs.client.Transport
import org.springframework.web.socket.sockjs.client.WebSocketTransport

import java.lang.reflect.Type

/**
 * Created by arellanog on 01/11/17.
 */
@javax.inject.Singleton
@griffon.metadata.ArtifactProviderFor(GriffonService)
class GriffonWebsocketService {

    String url = "ws://localhost:8080/stomp"

    def iniciarListener(){

        List<Transport> transports = new ArrayList<>()
        transports.add(new WebSocketTransport(new StandardWebSocketClient()))
        SockJsClient client = new SockJsClient(transports)
        WebSocketStompClient stompClient = new WebSocketStompClient(client)

        stompClient.setMessageConverter(new StringMessageConverter())
        StompSessionHandler sessionHandler = new MyListenerStompSessionHandler()
        stompClient.connect(url, sessionHandler)

    }

    def enviarMensaje(String mensaje){

        List<Transport> transports = new ArrayList<>()
        transports.add(new WebSocketTransport(new StandardWebSocketClient()))
        SockJsClient client = new SockJsClient(transports)
        WebSocketStompClient stompClient = new WebSocketStompClient(client)

        stompClient.setMessageConverter(new StringMessageConverter())
        StompSessionHandler sessionHandler = new StompSessionHandler() {
            @Override
            void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {}
            @Override
            void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {}
            @Override
            void handleTransportError(StompSession stompSession, Throwable throwable) {}
            @Override
            Type getPayloadType(StompHeaders stompHeaders) { return null }
            @Override
            void handleFrame(StompHeaders stompHeaders, Object o) {}
        }
        StompSession session = stompClient.connect(url, sessionHandler).get()
        session.send('/app/hello',mensaje)
    }

}
