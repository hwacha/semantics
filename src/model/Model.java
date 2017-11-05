package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import proof.*;
import syntax.Expression;

public class Model {
	public static int ID_COUNT = -1;
	private HashMap<Integer, Expression> names = new HashMap<Integer, Expression>();
	private HashMap<Integer, SemanticValue> model = new HashMap<Integer, SemanticValue>();
	// to speed things up, change from a map to semantic values to rules
	private HashSet<Rule> rules = new HashSet<Rule>();
	
	public Model() {}
	
	public boolean add(SemanticValue... values) {
		for (SemanticValue x : values) {
			model.put(x.getID(), x);
		}
		return true; //TODO make more restrictive
	}
	
	public boolean add(Rule... rs) {
		for (Rule r : rs) {
			rules.add(r);
		}
		return true; //TODO make more restrictive
	}
	
	public boolean addName(int id, Expression e) {
		if (names.containsKey(id)) {
			return false;
		} else {
			names.put(id, e);
			return true;
		}
	}
	
	public SemanticValue get(int id) {
		return model.get(id);
	}
	
	public boolean satisfies(proof.LogicalForm l) {
		if (l.isClosed() && l.isFormula()) {
			SemanticValue s = l.denotation(this);
			if (s instanceof TruthValue) {
				TruthValue t = (TruthValue) s;
				return t.isTrue();
			}
		}
		return false;
	}
	
	public boolean update(LogicalForm l) {
		if (l.isClosed() && l.isFormula()) {
			SemanticValue s = l.denotation(this);
			if (s instanceof TruthValue) {
				TruthValue t = (TruthValue) s;
				boolean isNot = l instanceof Not;
				if (isNot) {
					Not n = (Not) l;
					t = (TruthValue) n.sub().denotation(this);
				}
				boolean changed = t.add(!isNot); //TODO this is hacky and won't work for double negatives
				return changed;
			}
		}
		return false;
	}
	
	// updates THIS model according to m (m is unchanged)
	public boolean update(Model m) {
		boolean hasUpdated = false;
		for (Entry<Integer, SemanticValue> x : m.model.entrySet()) {
			if (this.model.containsKey(x.getKey())) {
				hasUpdated = this.model.get(x.getKey()).update(x.getValue()) || hasUpdated;
			} else {
				this.model.put(x.getKey(), x.getValue().sClone());
				hasUpdated = true;
			}
		}
		return hasUpdated;
	}
	
	private Set<Integer> getDomain(SemanticType t) {
		if (!t.equals(new proof.E())) {
			return null; //TODO fuck my model isn't good enough. I'll have to type the values
		}
		
		HashSet<Integer> keys = new HashSet<Integer>();
		
		for (int i : model.keySet()) {
			if (model.get(i) instanceof Individual) {
				keys.add(i);
			}
		}
		
		return keys;
	}
	
	// updates according to a rule, assuming
	// variables have been bound with a value
	private boolean updateSentence(Rule r) {
		for (LogicalForm l : r.getTop()) {
			if (!this.satisfies(l)) {
				return false;
			}
		}
		List<LogicalForm> bot = r.getBottom();
		if (bot.size() == 1) {
			return this.update(bot.get(0));
		}
		return false;
	}
	
	public boolean update(Rule r) {
		Set<Variable> vars = r.getFreeVariables();
		HashSet<Rule> rs = new HashSet<Rule>();
		rs.add(r);
		for (Variable v : vars) {
			int varID = v.getID();
			HashSet<Rule> newRules = new HashSet<Rule>();
			for (Rule x : rs) {
				for (int i : getDomain(v.getType())) {
					newRules.add(x.bind(varID, new Constant(v.getType(), i)));
				}
			}
			rs = newRules;
		}
		boolean anyChange = false;
		for (Rule filledRs : rs) {
			for (Rule canonicalR : filledRs.getCanonicalRules()) {
				anyChange = updateSentence(canonicalR) || anyChange;
			}
		}

		return anyChange;
	}
	
	public void update() {
		boolean didUpdate;
		do {
			didUpdate = false;
			for (Rule r : rules) {
				didUpdate = update(r) || didUpdate;
			}
		} while (didUpdate);
	}
	
	public void setNames() {
		for (int id : model.keySet()) {
			if (names.containsKey(id)) {
				model.get(id).setName(names.get(id));
			}
		}
	}
	
	private boolean inconsistencyHelper(SemanticValue v) {
		if (v instanceof TruthValue) {
			if (((TruthValue) v).isBoth()) {
				return true;
			}
		}
		if (v instanceof Function) {
			for (SemanticValue x : ((Function) v).codomain()) {
				if (inconsistencyHelper(x)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasInconsistency() {
		for (SemanticValue v : model.values()) {
			if (inconsistencyHelper(v)) {
				return true;
			}
		}
		return false;
	}
}
