package proof;

import java.util.HashSet;
import java.util.Set;

import model.Model;
import model.SemanticValue;
import model.TruthValue;

public class Equals implements LogicalForm {
	private LogicalForm l;
	private LogicalForm r;
	
	public Equals(LogicalForm l, LogicalForm r) {
		this.l = l;
		this.r = r;
	}

	@Override
	public SemanticType getType() {
		return new T();
	}

	@Override
	public boolean isClosed() {
		return getFreeVariables(new HashSet<Variable>()).isEmpty();
	}

	@Override
	public SemanticValue denotation(Model m) {
		return new TruthValue(l.denotation(m).equals(r.denotation(m)));
	}

	@Override
	public boolean isFormula() {
		return true;
	}

	@Override
	public LogicalForm bind(int id, LogicalForm l) {
		return new Equals(this.l.bind(id, l), this.r.bind(id, l));
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		Set<Variable> leftVars = this.l.getFreeVariables(bound);
		leftVars.addAll(this.r.getFreeVariables(bound));
		return leftVars;
	}
	
	@Override
	public String toString() {
		return "(" + this.l + " = " + this.r + ")"; 
	}
	
}
