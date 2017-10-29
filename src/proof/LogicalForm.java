package proof;

import java.util.Set;

public interface LogicalForm {
	public SemanticType getType();
	public boolean isClosed();
	public model.SemanticValue denotation(model.Model m);
	public boolean isFormula();
	public LogicalForm bind(int id, LogicalForm l);
	public Set<Variable> getFreeVariables(Set<Variable> bound);
}
