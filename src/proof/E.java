package proof;

public class E implements SemanticType {
	
	@Override
	public boolean equals(Object o) {
		return o instanceof E;
	}
	
	@Override
	public String toString() {
		return "e";
	}
}
