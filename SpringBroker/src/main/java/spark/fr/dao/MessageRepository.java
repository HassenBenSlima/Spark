package spark.fr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spark.fr.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
