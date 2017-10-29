package proof;

import java.util.Set;

import model.Model;
import model.SemanticValue;
import model.TruthValue;

public class Not implements LogicalForm {
	private LogicalForm l;
	
	public Not(LogicalForm l) throws InvalidTypeException {
		if (!l.isFormula()) {
			throw new InvalidTypeException();
		}
		this.l = l;
	}

	@Override
	public SemanticType getType() {
		return new Arrow(new T(), new T());
	}

	@Override
	public boolean isClosed() {
		return l.isClosed();
	}
	
	public LogicalForm sub() {
		return l;
	}

	@Override
	public SemanticValue denotation(Model m) {
		// this will be cast-able if this method is being called
		TruthValue v = (TruthValue) l.denotation(m);
		if (v == null) {
			//TODO this is only here because the domain isn't restricted yet
			return new TruthValue();
		}
		if (v.isTrue()) {
			return new TruthValue(false);
		} if (v.isFalse()) {
			return new TruthValue(true);
		} else
			return v;
	}

	@Override
	public boolean isFormula() {
		return true;
	}
	
	public LogicalForm getSubsentence() {
		return l;
	}

	@Override
	public LogicalForm bind(int id, LogicalForm lf) {
		return l.bind(id, lf);
	}

	@Override
	public Set<Variable> getFreeVariables(Set<Variable> bound) {
		return l.getFreeVariables(bound);
	}
	
	@Override
	public String toString() {
		return "~" + l;
	}
}
