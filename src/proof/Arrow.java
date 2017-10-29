package proof;

public class Arrow implements SemanticType {
	private SemanticType inputType;
	private SemanticType outputType;
	
	public Arrow(SemanticType inputType, SemanticType outputType) {
		this.inputType = inputType;
		this.outputType = outputType;
	}
	
	public SemanticType getInputType() {
		return inputType;
	}
	
	public SemanticType getOutputType() {
		return outputType;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Arrow)) {
			return false;
		} else {
			Arrow that = (Arrow) o;
			return this.inputType.equals(that.getInputType()) && this.outputType.equals(that.getOutputType());
		}
	}
	
	@Override
	public String toString() {
		return "(" + inputType.toString() + "->" + outputType.toString() + ")";
	}
}
