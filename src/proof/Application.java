package proof;

import java.util.HashSet;
import java.util.Set;

import model.Model;
import model.SemanticValue;

public class Application implements LogicalForm {
	private LogicalForm f;
	private LogicalForm x;
	private SemanticType type;
	
	public Application(LogicalForm f, LogicalForm x) throws InvalidTypeException {
		SemanticType fType = f.getType();
		SemanticType xType = x.getType();
		if (f.getType() instanceof Arrow) {
			Arrow aType = (Arrow) fType;
			if (aType.getInputType().equals(xType)) {
				this.type = aType.getOutputType();
			} else {
				throw new InvalidTypeException();
			}
		}
		this.f = f;
		this.x = x;
	}
	
	public LogicalForm reduce() {
		if (f instanceof Lambda) {
			Lambda l = (Lambda) f;
			return l.bind(x);
		} else return this;
	}

	@Override
	public SemanticType getType() {
		return type;
	}

	@Override
	public boolean isClosed() {
		return f.isClosed() && x.isClosed();
	}

	@Override
	public SemanticValue denotation(Model m) {
		if (!this.isClosed()) return null;
		else {
			if (f instanceof Lambda) {
				return this.reduce().denotation(m);
			}
			SemanticValue d = f.denotation(m);
			if (d instanceof model.Function) {
				return ((model.Function) d).apply(x.denotation(m));
			} else return null;
		}
	}

	@Override
	public boolean isFormula() {
		return (type instanceof T);
	}
	
	@Override
	public String toString() {
		return "(" + f.toString() + " " + x.toString() + ")";
	}

	@Override
	public LogicalForm bind(int id, LogicalForm l) {
		try {
			return new Application(f.bind(id, l), x.bind(id, l));
		} catch (InvalidTypeException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		HashSet<Variable> pot = new HashSet<Variable>();
		pot.addAll(f.getFreeVariables(bound));
		pot.addAll(x.getFreeVariables(bound));
		return pot;
	}
}
