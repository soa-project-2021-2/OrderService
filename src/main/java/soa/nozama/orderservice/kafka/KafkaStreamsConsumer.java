package soa.nozama.orderservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import soa.nozama.orderservice.model.Order;

@Service
public class KafkaStreamsConsumer {

    @KafkaListener(topics = "${order.service.topic}", containerFactory = "kafkaListenerContainerFactory")

    public void listen(Order value){
        System.out.println("Message Received :: "+value.toString());
    }
}
