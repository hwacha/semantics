package ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Model;

public class NPC {
	private Model model;
	
	public NPC(Model model) {
		this.model = model;
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
	
	private void question(BufferedReader r, String question, String[] options, String[] responses) throws InterruptedException, IOException {
		assert(options.length == responses.length);
		
		System.out.println(question);
		Thread.sleep(1500);
		
		boolean isDefault = true;
		
		for (int i = 0; i < options.length - 1; i++) {
			if (pollOption(r, options[i])) {
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
	
	public void talkWithPlayer() throws IOException, InterruptedException {
		BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
		
		question(r, "What's your name?", new String[]{"Bill", "Mike", "Dan"},
				new String[]{"Bill is a nice name.", "Mike is a shitty name.", "Dan is a generic name."});
		
		question(r, "Where are you from?", new String[]{"Elmira", "New York", "Paris", "France", "Mars"},
				new String[]{"Elmira sounds awful.", "New York is all right.", "Paris sucks.", "France is great.", "Oh."});

		System.out.println("I don't want to be rude or anything, but I'm kind of bored right now. Catch you later!");
	}
	
	public static void main(String[] args) {
		NPC npc = new NPC(null);
		try {
			npc.talkWithPlayer();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}