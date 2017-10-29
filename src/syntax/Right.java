package syntax;

public class Right extends Functor {
	
	public Right(SyntacticCategory out, SyntacticCategory arg) {
		super(out, arg);
	}
	
	@Override
	public String toString() {
		return "(" + out + "/" + arg + ")";
	}
	
}
