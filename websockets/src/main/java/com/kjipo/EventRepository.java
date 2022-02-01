package com.kjipo;

import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, Long> {

    Event findById(long eventId);


}
