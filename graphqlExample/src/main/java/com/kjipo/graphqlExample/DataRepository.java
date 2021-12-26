package com.kjipo.graphqlExample;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

//@Repository
public class DataRepository {


    public String getBasic() {
        return """
                Test
                """;
    }


    public Mono<String> getSingleData() {
        return Mono.deferContextual(context -> {
            Object name = context.get("name");
            return Mono.delay(Duration.ofMillis(100)).map(data -> "Test2: " + name);
        });
    }

//    public Flux<String> getData2() {
//        return Mono.delay(Duration.ofMillis(100)).flatMapMany(data -> Flux.deferContextual(context -> {
//            String name = context.get("name");
//            return Flux.just("Test10", "Test11", "Test12", "Test13", "Test14", "Test15").map(data -> data +" " name);
//        }));
//    }


    public Flux<String> getDataStream() {
        return Mono.delay(Duration.ofMillis(100)).flatMapMany(data -> Flux.deferContextual(context -> {
            String name = context.get("name");
            return Flux.just("Test10", "Test11", "Test12", "Test13", "Test14", "Test15").map(testData -> testData + " " +name);
        }));
    }


}
