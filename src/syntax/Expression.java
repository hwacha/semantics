package syntax;

import model.Model;
import model.SemanticValue;
import proof.LogicalForm;

public abstract class Expression {
	protected SyntacticCategory cat;
	protected String name;
	protected SpeechAct actType;
	
	protected LogicalForm lf;
	
	public Expression(SyntacticCategory cat, SpeechAct actType) {
		this.cat = cat;
		this.actType = actType;
	}
	
	public Expression(SyntacticCategory cat) {
		this(cat, new Honest());
	}
	
	public SemanticValue meaning(Model m) {
		return this.lf.denotation(m);
	}
	
	public SyntacticCategory getSyntacticCategory() {
		return cat;
	}
	
	public String getName() {
		return name;
	}
	
	public LogicalForm getForm() {
		return lf;
	}
	
	public String toStringWithType() {
		return name + " [" + actType + "]";
	}
	
	@Override
	public String toString() {
		return name;
	}
}
