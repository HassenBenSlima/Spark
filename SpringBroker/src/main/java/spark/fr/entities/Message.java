package spark.fr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idMsg;
	private String sender;
	private String receiver;
	private String content;

	public Message() {
		super();
	}

	public Message(String sender, String receiver, String content) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	public Long getIdMsg() {
		return idMsg;
	}

	public void setIdMsg(Long idMsg) {
		this.idMsg = idMsg;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content
				+ "]";
	}

}
