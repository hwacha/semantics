package proof;

import java.util.HashSet;
import java.util.Set;

import model.Model;
import model.SemanticValue;

public class Variable implements LogicalForm {
	private SemanticType type;
	private int id;
	
	public Variable(SemanticType type, int id) {
		this.type = type;
		this.id = id;
	}
	
	@Override
	public SemanticType getType() {
		return type;
	}
	
	public int getID() {
		return id;
	}

	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public SemanticValue denotation(Model m) {
		return null;
	}

	@Override
	public boolean isFormula() {
		return (type instanceof T);
	}
	
	@Override
	public String toString() {
		return "{" + id + "}";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Variable) {
			Variable that = (Variable) o;
			return this.getType().equals(that.getType()) && this.id == that.getID();
		}
		return false;
	}

	@Override
	public LogicalForm bind(int id, LogicalForm l) {
		if (this.id == id && l.getType().equals(this.getType())) return l;
		else return this;
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		HashSet<Variable> variables = new HashSet<Variable>();
		if (!bound.contains(this)) {
			variables.add(this);
		}
		return variables;
	}

}
