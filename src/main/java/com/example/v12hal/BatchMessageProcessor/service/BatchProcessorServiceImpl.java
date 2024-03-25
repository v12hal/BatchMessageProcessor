package com.example.v12hal.BatchMessageProcessor.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchProcessorServiceImpl implements BatchProcessor{


    public List<Message<String>> processMessage(Message<List<String>> payload) {
//        List<Integer> partitionIds = (List<Integer>) payload.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION);
//        List<String> receivedMsgKeys = (List<String>) payload.getHeaders().get(KafkaHeaders.RECEIVED_KEY);
//        List<Long> offsets = (List<Long>) payload.getHeaders().get(KafkaHeaders.OFFSET);



        System.out.println("Received: "+payload.getPayload());
//        int val = Integer.parseInt(payload.getPayload().get(0));
//        System.out.println("kafka_receivedMessageKey: "+receivedMsgKeys);
//        System.out.println("kafka_receivedPartitionId: "+partitionIds);
//        System.out.println("kafka_offset: "+offsets);

        List<String> receivedBatch = payload.getPayload();
        List<Message<String>> outputBatch = new ArrayList<>();
        List<Message<String>> emptyList = new ArrayList<>();
        for (String p : receivedBatch) {
            outputBatch.add(MessageBuilder.withPayload(p + ":1").build());
            outputBatch.add(MessageBuilder.withPayload(p + ":2").build());
            outputBatch.add(MessageBuilder.withPayload(p + ":3").build());
            outputBatch.add(MessageBuilder.withPayload(p + ":4").build());
        }
        System.out.println("Received: "+outputBatch);
        return !outputBatch.isEmpty() ? outputBatch : null;
    }

    public void sendToDLQ(ErrorMessage errorMessage) {
        System.out.println("Error message: "+ errorMessage.getOriginalMessage().getPayload());
    }

}
