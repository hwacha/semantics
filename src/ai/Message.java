package ai;

public class Message {
	protected String message;
	
	public Message(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
