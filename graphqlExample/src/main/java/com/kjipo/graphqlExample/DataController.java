package com.kjipo.graphqlExample;


import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Controller
public class DataController {

    private final DataRepository repository;

    public DataController(DataRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Mono<String> getSingleData() {
        return this.repository.getSingleData();
    }


    @SubscriptionMapping
    public Flux<String> getData() {
        return this.repository.getDataStream();
    }


}
