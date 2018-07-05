package spark.fr.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import spark.fr.entities.Message;

@Component
public class MessageStorage {

	private List<Message> storage = new ArrayList<Message>();

	public void put(Message message) {
		storage.add(message);
	}

	public void messagesConsumer() {

		storage.forEach(msg -> System.out.println(msg));

	}

	public void clear() {
		storage.clear();
	}
}
