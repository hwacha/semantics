package model;

import java.util.HashMap;
import java.util.Map.Entry;

import syntax.Expression;

public class Function implements SemanticValue {
	private int id;
	private HashMap<SemanticValue, SemanticValue> map;
	private Expression name;
	
	public Function(int id) {
		this.id = id;
		this.map = new HashMap<SemanticValue, SemanticValue>();
	}
	
	public Function() {
		this(-1);
	}
	
	public boolean set(SemanticValue input, SemanticValue output) {
		map.put(input, output);
		return true; //TODO make more restrictive
	}
	
	public SemanticValue apply(SemanticValue input) {
		return map.get(input);
	}

	@Override
	public int getID() {
		return id;
	}
	
	private String toString(int depth) {
		String tab = mult("  ", depth + 1);
		StringBuilder s = new StringBuilder();
		//s.append("{\n");
		s.append("\n");
		for (SemanticValue input : map.keySet()) {
			s.append(tab);
			if (input instanceof Function) {
				s.append(((Function) input).toString(depth + 1));
			} else {
				s.append(input);
			}
			s.append(" -> ");
			SemanticValue output = map.get(input);
			if (output instanceof Function) {
				s.append(((Function) output).toString(depth + 2));
			} else {
				s.append(output);
			}
			s.append("\n");
		}
		//s.append(tab + "}");
		return s.toString();
	}
	
	private String mult(String string, int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) {
			s.append(string);
		}
		return s.toString();
	}

	public String toString() {
		return toString(0);
	}

	@Override
	public void setName(Expression expression) {
		this.name = expression;
	}

	@Override
	public boolean update(SemanticValue that) {
		if (!(that instanceof Function)) {
			return false;
		}
		Function other = (Function) that;
		
		boolean hasUpdated = false;
		
		for (Entry<SemanticValue, SemanticValue> x: other.map.entrySet()) {
			if (this.map.containsKey(x.getKey())) {
				hasUpdated = this.map.get(x.getKey()).update(x.getValue()) || hasUpdated;
			} else {
				this.map.put(x.getKey(), x.getValue());
				hasUpdated = true;
			}
		}
		
		return hasUpdated;
	}
}
