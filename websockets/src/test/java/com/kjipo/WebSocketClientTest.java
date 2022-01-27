package com.kjipo;


import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(
        // TODO Figure out why the data source does not get set up during testing
        exclude = {
                R2dbcAutoConfiguration.class,
        }
)
public class WebSocketClientTest {

    @LocalServerPort
    private int port;


    @Test
    public void clientGetsDataTest() {
        AtomicInteger messageCounter = new AtomicInteger();
        WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
                URI.create("ws://localhost:" + port + "/event-emitter"),
                session -> session.send(
                                Mono.just(session.textMessage("event-spring-reactive-client-websocket")))
                        .thenMany(session.receive().
                                map(WebSocketMessage::getPayloadAsText)
                                .log()
                                .map((logMessage) -> {
                                    messageCounter.getAndIncrement();
                                    return logMessage;
                                })).then()).subscribe();

        Awaitility.await().atMost(5, TimeUnit.SECONDS).untilAtomic(messageCounter, greaterThanOrEqualTo(3));
    }

}
