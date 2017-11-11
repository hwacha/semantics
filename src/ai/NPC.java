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
	private Message[] conversation;
	
	public NPC(String name, Model model, Message[] conversation) {
		this.name = name;
		this.model = model;
		this.conversation = conversation;
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
		
		for (Message m : conversation) {
			if (m.meetsConditions(this.model)) {
				prompt(r, m);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		NPC npc = new NPC(null);
//		try {
//			npc.talkWithPlayer();
//		} catch (IOException | InterruptedException | InvalidTypeException e) {
//			e.printStackTrace();
//		}
		
		char[] cs = "the quick brown fox jumped over the lazy gray dog.".toCharArray();
		
		for (int i = 0; i < cs.length; i++) {
			cs[i] = (char) (((int)cs[i]) + 1);
		}
		System.out.println(new String(cs));
	}
}