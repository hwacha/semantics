package syntax;

public class Testing {

	public static void main(String[] args) {
		
		Expression bill = new Word("Bill", new NP(), 0);
		// Expression runs = new Word("runs", new Left(new S(), new NP()), 1);
		
		Expression helps = new Word("helps", new Right(new Left(new S(), new NP()), new NP()), 2);
		
		// Expression billRuns = new Phrase(bill, runs);
		Expression helpsBill = new Phrase(helps, bill, new Honest());
		Expression billHelpsBill = new Phrase(bill, helpsBill, new Honest());
		
		System.out.println(billHelpsBill);
		System.out.println(billHelpsBill.getSyntacticCategory());
	}

}
