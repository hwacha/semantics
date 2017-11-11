package ai;

import proof.LogicalForm;
import syntax.Expression;

public class Prompt extends Message {
	private Expression[] options;
	private Message[] responses;
	
	public Prompt(String message, LogicalForm[] conditions, Expression[] options, Message[] responses) {
		super(message);
		assert(options.length == responses.length);
		this.options = options;
		this.responses = responses;
	}
	
	public Prompt(String message, Expression[] options, Message[] responses) {
		this(message, null, options, responses);
	}
	
	public Expression[] getOptions() {
		return options;
	}
	
	public Message[] getResponses() {
		return responses;
	}
}
