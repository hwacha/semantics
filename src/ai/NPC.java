package ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;
import proof.*;
import syntax.*;

public class NPC {
	private Model model;
	
	public NPC(Model model) {
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
	
	private void question(BufferedReader r, String question, Expression[] options, String[] responses) throws InterruptedException, IOException {
		assert(options.length == responses.length);
		
		System.out.println(question);
		Thread.sleep(1500);
		
		boolean isDefault = true;
		
		for (int i = 0; i < options.length - 1; i++) {
			if (pollOption(r, options[i].toString())) {
				System.out.println(this.model.update(options[i].getForm()));
				// this.model.update();
				System.out.println(responses[i]);
				isDefault = false;
				break;
			}
		}
		
		if (isDefault) {
			System.out.println(options[options.length - 1]);
			System.out.println(responses[options.length - 1]);
		}
		
		System.out.println();
	}
	
	public void talkWithPlayer() throws IOException, InterruptedException, InvalidTypeException {
		BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
		
		//TODO get rid of this
		int playerID = 123;
		
		SemanticType eToT = new Arrow(new E(), new T());
		
		// a trivially true sentence that is a placeholder for actual name stuff
		LogicalForm ta = new Application(new Constant(eToT, 10), new Constant(new E(), 6));
		
		question(r, "What's your name?", new Expression[]{
				new Word("Bill", new S(), ta),
				new Word("Mike", new S(), ta),
				new Word("Dan", new S(), ta)},
				new String[]{
					"Bill is a nice name.",
					"Mike is a shitty name.",
					"Dan is a generic name."});
		
		// the player was born in x.
		LogicalForm playerWasBornIn = new Application(new Constant(new Arrow(new E(), eToT), 12), new Constant(new E(), 123));
		
		// the player was born in elmira.
		Expression e = new Word("Elmira.", new S(), new Application(playerWasBornIn, new Constant(new E(), 6)));
		Expression n = new Word("New York.", new S(), new Application(playerWasBornIn, new Constant(new E(), 7)));
		Expression p = new Word("Paris.", new S(), new Application(playerWasBornIn, new Constant(new E(), 8)));
		Expression f = new Word("France.", new S(), new Application(playerWasBornIn, new Constant(new E(), 9)));
		
		
		//TODO change so tht you only need the NPs instaead of whole sentence:
		// give template combining question and response.
		
		question(r, "Where are you from?", new Expression[]{e, n, p , f},
				new String[]{"Elmira sounds awful.", "New York is all right.", "Paris sucks.", "Oh."});

		System.out.println("I don't want to be rude or anything, but I'm kind of bored right now. Catch you later!");
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