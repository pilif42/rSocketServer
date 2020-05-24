package com.sample.rsocketserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Used to model the request and response messages between the client (or the ‘requester’) and the server ( or the ‘responder’).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String origin;  // Where a message comes from.
    private String interaction; // Which messaging style it is intended to use.
    private long index; // Which sequence number a message has in a sequence of messages.
    private long created = Instant.now().getEpochSecond();

    public Message(String origin, String interaction) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
    }

    public Message(String origin, String interaction, long index) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = index;
    }
}