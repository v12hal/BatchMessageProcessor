package com.example.v12hal.BatchMessageProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;


import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class BatchMessageProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchMessageProcessorApplication.class, args);
	}

//	@Bean
//	public Consumer<String> processMessage() {
//		return s -> System.out.println("Data::Consumed:: "+s.toUpperCase());
//	}

//	@Bean
//	public Function<List<String>, String> processMessage() {
//
//		return persons -> {
//			System.out.println("Received"+ persons);
//			return persons.get(0);
//		};
//	}

//	@Bean
//	public Function<String, List<Message<String>>> processMessage() {
//
//		return p -> {
//			System.out.println("Received: "+p);
//			List<Message<String>> list = new ArrayList<>();
//			list.add(MessageBuilder.withPayload(p + ":1").build());
//			list.add(MessageBuilder.withPayload(p + ":2").build());
//			list.add(MessageBuilder.withPayload(p + ":3").build());
//			list.add(MessageBuilder.withPayload(p + ":4").build());
//			System.out.println("Output: "+list);
//			return list;
//		};
//	}

}
