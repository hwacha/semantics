package model;

import syntax.Expression;

public class TruthValue implements SemanticValue {
	private boolean isTrue;
	private boolean isFalse;
	
	public TruthValue() {
		this(false, false);
	}
	
	public TruthValue(boolean value) {
		this(value? true : false, value? false : true);
	}
	
	public TruthValue(boolean isTrue, boolean isFalse) {
		this.isTrue = isTrue;
		this.isFalse = isFalse;
	}
	
	public boolean isUnknown() {
		return !(isTrue || isFalse);
	}
	
	public boolean isTrue() {
		return isTrue && !isFalse;
	}
	
	public boolean isFalse() {
		return !isTrue && isFalse;
	}
	
	public boolean isBoth() {
		return isTrue && isFalse;
	}
	
	public void clear() {
		isTrue = false;
		isFalse = false;
	}
	
	public boolean add(boolean value) {
		boolean hasChanged = false;
		if (value) {
			if (!isTrue) {
				isTrue = true;
				hasChanged = true;
			}
		} else {
			if (!isFalse) {
				isFalse = true;
				hasChanged = true;
			}
		}
		return hasChanged;
	}

	@Override
	public int getID() {
		if (isUnknown()) return 0;
		if (isTrue()) return 1;
		if (isFalse()) return 2;
		else return 3;
	}
	
	@Override
	public String toString() {
		if (isUnknown()) return "U";
		if (isTrue()) return "T";
		if (isFalse()) return "F";
		else return "B";
	}

	@Override
	public void setName(Expression expression) {
		return; // Don't do anything
	}
	
}
