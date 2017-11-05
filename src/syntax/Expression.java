package syntax;

import model.Model;
import model.SemanticValue;
import proof.LogicalForm;

public abstract class Expression {
	protected SyntacticCategory cat;
	protected String name;
	
	protected LogicalForm lf;
	
	public Expression(SyntacticCategory cat) {
		this.cat = cat;
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
	
	@Override
	public String toString() {
		return name;
	}
}
