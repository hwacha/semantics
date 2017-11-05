package syntax;

import proof.Constant;
import proof.LogicalForm;

public class Word extends Expression {

	public Word(String name, SyntacticCategory cat, int id) {
		super(cat);
		this.name = name;
		this.lf = new Constant(cat.getSemanticType(), id);
	}
	
	public Word(String name, SyntacticCategory cat, LogicalForm lf) {
		super(cat);
		this.name = name;
		this.lf = lf;
	}
}
