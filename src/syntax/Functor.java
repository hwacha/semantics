package syntax;

import proof.Arrow;
import proof.SemanticType;

public abstract class Functor implements SyntacticCategory {
	protected SyntacticCategory out;
	protected SyntacticCategory arg;
	
	public Functor(SyntacticCategory out, SyntacticCategory arg) {
		this.out = out;
		this.arg = arg;
	}
	
	public SemanticType getSemanticType() {
		return new Arrow(arg.getSemanticType(), out.getSemanticType());
	}
	
	public SyntacticCategory getOut() {
		return out;
	}
	
	public SyntacticCategory getArg() {
		return arg;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Functor) {
			return out.equals(((Functor) o).out);
		} return false;
	}
}
