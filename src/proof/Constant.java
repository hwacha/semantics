package proof;

import java.util.HashSet;
import java.util.Set;

import model.SemanticValue;

public class Constant implements LogicalForm {
	private SemanticType type;
	private int id;
	
	public Constant(SemanticType type, int id) {
		this.type = type;
		this.id = id;
	}

	@Override
	public SemanticType getType() {
		return type;
	}

	@Override
	public boolean isClosed() {
		return true;
	}

	@Override
	public SemanticValue denotation(model.Model m) {
		return m.get(id);
	}

	@Override
	public boolean isFormula() {
		return (type instanceof T);
	}
	
	@Override
	public String toString() {
		return "[" + id + "]";
	}

	@Override
	public LogicalForm bind(int id, LogicalForm l) {
		return this;
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		return new HashSet<Variable>();
	}

}
