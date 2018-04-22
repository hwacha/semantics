package syntax;

import proof.Application;
import proof.InvalidTypeException;

public class Phrase extends Expression {
	private Expression left;
	private Expression right;
	
	public Phrase(Expression left, Expression right, SpeechAct actType) {
		super(null, actType);
		
		if (left.cat instanceof Right) {
			Right r = (Right) left.cat;
			if (r.getArg().equals(right.cat)) {
				this.cat = r.getOut();
				try {
					this.lf = new Application(left.lf, right.lf);
				} catch (InvalidTypeException e) {
					e.printStackTrace();
				}
			}
		} else if (right.cat instanceof Left) {
			Left l = (Left) right.cat;
			if (l.getArg().equals(left.cat)) {
				this.cat = l.getOut();
				try {
					this.lf = new Application(right.lf, left.lf);
				} catch (InvalidTypeException e) {
					e.printStackTrace();
				}
			}
		} else throw new IllegalArgumentException();
		
		this.left = left;
		this.right = right;
		this.name = left.name + " " + right.name;
	}
	
	public Phrase(Expression left, Expression right) {
		this(left, right, new Honest());
	}
}
