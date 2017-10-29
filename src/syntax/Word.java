package syntax;

import proof.Constant;

public class Word extends Expression {

	public Word(String name, SyntacticCategory cat, int id) {
		super(cat);
		this.name = name;
		this.lf = new Constant(cat.getSemanticType(), id);
	}
}
