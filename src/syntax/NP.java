package syntax;

import proof.E;
import proof.SemanticType;

public class NP implements SyntacticCategory {

	@Override
	public SemanticType getSemanticType() {
		return new E();
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof NP);
	}
	
	@Override
	public String toString() {
		return "NP";
	}
}
