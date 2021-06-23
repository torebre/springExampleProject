package com.kjipo;


import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static java.time.LocalTime.now;
import static java.util.UUID.randomUUID;


@Component("ReactiveWebSocketHandler")
public class ReactiveWebSocketHandler implements WebSocketHandler {

    private final Gson gson = new Gson();

    private Flux<String> eventFlux = Flux.generate(sink -> {
        Event event = new Event(randomUUID().toString(), now().toString());
        sink.next(gson.toJson(event));
    });

    private Flux<String> intervalFlux = Flux.interval(Duration.ofMillis(1000L))
            .zipWith(eventFlux, (time, event) -> event);

    public Mono<Void> handle(WebSocketSession webSocketSession) {
        return webSocketSession.send(intervalFlux
                .map(webSocketSession::textMessage))
                .and(webSocketSession.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .log());
    }


}
