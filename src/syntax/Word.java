package syntax;

import proof.Constant;
import proof.LogicalForm;
import proof.Verum;

public class Word extends Expression {

	public Word(String name, SpeechAct actType, SyntacticCategory cat, int id) {
		super(cat, actType);
		this.name = name;
		this.lf = new Constant(cat.getSemanticType(), id);
	}
	
	public Word(String name, SpeechAct actType, SyntacticCategory cat, LogicalForm lf) {
		super(cat, actType);
		this.name = name;
		this.lf = lf;
	}
	
	public Word(String name, SyntacticCategory cat, int id) {
		this(name, new Honest(), cat, id);
	}
	
	public Word(String name, SyntacticCategory cat, LogicalForm lf) {
		this(name, new Honest(), cat, lf);
	}
	
	public Word(String name, SpeechAct actType) {
		this(name, actType, new S(), new Verum());
	}
	
	public Word(String name) {
		this(name, new S(), new Verum());
	}
}
