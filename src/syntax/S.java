package syntax;

import proof.SemanticType;
import proof.T;

public class S implements SyntacticCategory {

	@Override
	public SemanticType getSemanticType() {
		return new T();
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof S);
	}
	
	@Override
	public String toString() {
		return "S";
	}
}
