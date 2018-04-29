package ai;

import model.Model;
import proof.LogicalForm;

public class Message {
	protected String message;
	protected LogicalForm[] conditions;
	
	public Message(String message, LogicalForm[] conditions) {
		this.message = message;
		this.conditions = conditions;
	}
	
	public Message withNewString(String message) {
		return new Message(message, conditions);
	}
	
	public Message(String message) {
		this(message, null);
	}
	
	public boolean meetsConditions(Model m) {
		if (conditions == null) {
			return true;
		}
		
		for (LogicalForm l : conditions) {
			if (!m.satisfies(l)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
