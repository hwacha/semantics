package proof;

import java.util.Set;

import model.Model;
import model.SemanticValue;

public class Verum implements LogicalForm {

	@Override
	public SemanticType getType() {
		return new T();
	}

	@Override
	public boolean isClosed() {
		return true;
	}

	@Override
	public SemanticValue denotation(Model m) {
		return new model.TruthValue(true);
	}

	@Override
	public boolean isFormula() {
		return true;
	}

	@Override
	public LogicalForm bind(int id, LogicalForm l) {
		return this;
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		return new java.util.HashSet<Variable>();
	}

}
