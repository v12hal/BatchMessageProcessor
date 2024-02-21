package com.example.v12hal.BatchMessageProcessor.config;

import com.example.v12hal.BatchMessageProcessor.service.BatchProcessorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Configuration

public class BatchProcessorConfig {
    private final BatchProcessorServiceImpl batchProcessorService;


    public BatchProcessorConfig(BatchProcessorServiceImpl batchProcessorService,
                                BatchProcessorServiceImpl sendToDLQ) {
        this.batchProcessorService = batchProcessorService;
    }

    @Bean
    public Function<Message<List<String>>, List<Message<String>>> processMessage() {
        return batchProcessorService::processMessage;
    }

    @Bean
    public Consumer<ErrorMessage> sendToDLQ() {
        return batchProcessorService::sendToDLQ;
    }
}
