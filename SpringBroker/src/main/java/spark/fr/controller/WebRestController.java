package spark.fr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spark.fr.entities.Message;
import spark.fr.services.KafkaProducer;
import spark.fr.storage.MessageStorage;

@RestController
@RequestMapping(value = "/jsa/kafka")
public class WebRestController {

	@Autowired
	KafkaProducer producer;

	@Autowired
	MessageStorage storage;

	@PostMapping(value = "/producer")
	public Message producer(@RequestBody Message message) {
		producer.send(message);

		return message;
	}

	@GetMapping(value = "/consumer")
	public String getAllRecievedMessage() {
		storage.messagesConsumer();
		storage.clear();

		return "Done";
	}
}
