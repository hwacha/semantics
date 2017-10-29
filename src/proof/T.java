package proof;

public class T implements SemanticType {
	
	@Override
	public boolean equals(Object o) {
		return o instanceof T;
	}
	
	@Override
	public String toString() {
		return "t";
	}
}
