package model;

import syntax.Expression;

public class Individual implements SemanticValue {
	private int id;
	
	private Expression name;
	
	public Individual(int id) {
		this.id = id;
	}
	
	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public String toString() {
		if (this.name == null) {
			return "[" + id + "]";
		} else {
			return this.name.toString();
		}
		
	}
	
	public void setName(Expression e) {
		this.name = e;
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Individual) && (((Individual) o).id == this.id);
	}

	@Override
	public boolean update(SemanticValue that) {
		return false;
	}
}
