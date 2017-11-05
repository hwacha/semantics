package ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;
import proof.*;
import syntax.*;

public class NPC {
	private String name;
	private Model model;
	
	public NPC(String name, Model model) {
		this.name = name;
		this.model = model;
	}
	
	public Model getModel() {
		return model;
	}
	
	private String constant(char c, String s) {
		char[] cs = new char[s.length()];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = c;
		}
		return new String(cs);
	}
	
	private boolean pollOption(BufferedReader r, String option) throws InterruptedException, IOException {
		System.out.print(option);
		Thread.sleep(1500);
		
		if (r.ready()) {
			r.readLine();
			return true; 
		}
		
		String bs = constant('\b', option);
		System.out.print(bs);
		System.out.print(constant(' ', option));
		System.out.print(bs);
		
		return false;
	}
	
	private void prompt(BufferedReader r, Message m) throws InterruptedException, IOException {
		System.out.println(name + ": " + m);
		Thread.sleep(1500);
		
		if (!(m instanceof Prompt)) {
			return;
		}
		Prompt p = (Prompt) m;
		
		boolean isDefault = true;
		
		Expression[] options = p.getOptions();
		Message[] responses = p.getResponses();
		
		for (int i = 0; i < options.length - 1; i++) {
			if (pollOption(r, options[i].toString())) {
				this.model.update(options[i].getForm());
				this.model.update();
				prompt(r, responses[i]);
				// System.out.println(responses[i]);
				isDefault = false;
				break;
			}
		}
		
		if (isDefault) {
			System.out.println(options[options.length - 1]);
			this.model.update(options[options.length - 1].getForm());
			this.model.update();
			System.out.println(responses[options.length - 1]);
		}
		
		System.out.println();
	}
	
	public void talkWithPlayer() throws IOException, InterruptedException, InvalidTypeException {
		BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
		
		SemanticType eToT = new Arrow(new E(), new T());
		
		// a trivially true sentence that is a placeholder for actual name stuff
		LogicalForm ta = new Verum();
		
		prompt(r, new Prompt("What's your name?", new Expression[]{
				new Word("Bill", new S(), ta),
				new Word("Mike", new S(), ta),
				new Word("Dan", new S(), ta)},
				new Message[]{
					new Prompt("Are YOU Bill Gates?", new Expression[] {new Word("yes", new S(), ta), new Word("no", new S(), ta)},
							new Message[] {new Message("Give me money."), new Message("That's too bad.")}),
					new Message("Mike is a shitty name."),
					new Message("Dan is a generic name.")}));
		
		// the player was born in x.
		LogicalForm playerWasBornIn = new Application(new Constant(new Arrow(new E(), eToT), 12), new Constant(new E(), 123));
		
		// the player was born in elmira.
		Expression e = new Word("Elmira.", new S(), new Application(playerWasBornIn, new Constant(new E(), 6)));
		Expression n = new Word("New York.", new S(), new Application(playerWasBornIn, new Constant(new E(), 7)));
		Expression p = new Word("Paris.", new S(), new Application(playerWasBornIn, new Constant(new E(), 8)));
		Expression f = new Word("France.", new S(), new Application(playerWasBornIn, new Constant(new E(), 9)));
		
		
		//TODO change so that you only need the NPs instead of whole sentence:
		// give template combining question and response.
		
		prompt(r, new Prompt("Where are you from?", new Expression[]{e, n, p , f},
				new Message[]{
						new Message("Elmira sounds awful."),
						new Message("New York is all right."),
						new Message("Paris sucks."),
						new Message("Oh.")}));

		// System.out.println("I don't want to be rude or anything, but I'm kind of bored right now. Catch you later!");
		System.out.println("END OF CONVERSATION\n");
	}
	
	public static void main(String[] args) {
//		NPC npc = new NPC(null);
//		try {
//			npc.talkWithPlayer();
//		} catch (IOException | InterruptedException | InvalidTypeException e) {
//			e.printStackTrace();
//		}
	}
}