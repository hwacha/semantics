package syntax;

public class Left extends Functor {
	public Left(SyntacticCategory out, SyntacticCategory arg) {
		super(out, arg);
	}
	
	@Override
	public String toString() {
		return "(" + arg + "\\" + out + ")";
	}
}
