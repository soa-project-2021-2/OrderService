package soa.nozama.orderservice.kafka;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import soa.nozama.orderservice.model.Order;

@RestController
public class KafkaStreamsController {
    @Autowired
    KafkaStreamsProducer kafkaStreamsProducer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        kafkaStreamsProducer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody Order order) {
        kafkaStreamsProducer.sendMessage(order);
    }
}
