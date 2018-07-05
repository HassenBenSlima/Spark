package spark.fr.services;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import spark.fr.entities.Message;
import spark.fr.storage.MessageStorage;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	MessageStorage storage;

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${jsa.kafka.topic}")
	public void processMessage(Message message) {

		System.out.println("received content:" + message);
		latch.countDown();
		
		log.info("received content = '{}'", getLatch());

		storage.put(message);
	}
}
