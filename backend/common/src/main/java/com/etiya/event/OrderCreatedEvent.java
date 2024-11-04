package com.etiya.event;


import java.util.UUID;

public class OrderCreatedEvent {

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(UUID id) {
        this.id= id;
    }

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
