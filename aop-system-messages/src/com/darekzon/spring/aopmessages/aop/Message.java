package com.darekzon.spring.aopmessages.aop;

/**
 * Class that keeps messages
 * 
 * @author Darek Zon
 */
public class Message {

	/**
	 * 
	 * @param type
	 *            - type of message
	 * @param message
	 *            - message text
	 * @param noJump
	 *            - trigger, if true - don't store message in session just
	 *            display it
	 */
	public Message(final MessageType type, final String message,
			final Boolean noJump) {
		this.type = type;
		this.message = message;
		this.noJump = noJump;
	}

	public enum MessageType {
		OK, ERROR, INFO;
	}

	public static final String key = "sysMessage";

	private MessageType type;

	private String message;

	private Boolean noJump = false;

	public MessageType getType() {
		return this.type;
	}

	public void setType(final MessageType type) {
		this.type = type;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public Boolean getNoJump() {
		return this.noJump;
	}

	public Boolean isNoJump() {
		return this.noJump;
	}

	public void setNoJump(final Boolean nojump) {
		this.noJump = nojump;
	}

}
