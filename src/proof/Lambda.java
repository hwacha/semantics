package proof;

import java.util.HashSet;
import java.util.Set;

import model.Model;
import model.SemanticValue;

public class Lambda implements LogicalForm {
	private Variable v;
	private LogicalForm l;
	
	public Lambda(Variable v, LogicalForm l) {
		this.v = v;
		this.l = l;
	}
	
	public LogicalForm bind(LogicalForm x) {
		return l.bind(v.getID(), x);
	}

	@Override
	public SemanticType getType() {
		return new Arrow(v.getType(), l.getType());
	}

	@Override
	public boolean isClosed() {
		return getFreeVariables(new HashSet<Variable>()).isEmpty();
	}

	@Override
	public SemanticValue denotation(Model m) {
		return null; //TODO this is also wrong.
		// Should I try to detect when such a
		// function is in the model, or just spawn a new one?
	}

	@Override
	public boolean isFormula() {
		return false; // this is actually right
	}

	@Override
	public LogicalForm bind(int id, LogicalForm lf) {
		if (id == v.getID()) {
			return this;
		}
		return new Lambda(v, l.bind(id, lf));
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		bound.add(v);
		return l.getFreeVariables(bound);
	}
	
	@Override
	public String toString() {
		return "\u03BB" + v + "(" + l + ")";
	}
	
}
