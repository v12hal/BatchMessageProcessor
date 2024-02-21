package com.example.v12hal.BatchMessageProcessor.service;

import org.springframework.messaging.Message;

import java.util.List;

public interface BatchProcessor {
    public List<Message<String>> processMessage(Message<List<String>> receivedBatch);
}
