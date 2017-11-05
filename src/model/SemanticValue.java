package model;

import syntax.Expression;

public interface SemanticValue {
	public int getID();

	public void setName(Expression expression);
	
	public boolean update(SemanticValue that);
}
