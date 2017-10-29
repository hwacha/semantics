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
	
	public void talkTo(NPC to) {
		//TODO mix your model with the other NPC.
	}
	
	public void talkWithPlayer() throws IOException {
		BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("(Enter the number that corresponds with your choice.");
		System.out.println("Jim: Where were you born?");
		System.out.println("	1. Paris (Honest)");
		System.out.println("	2. France (Honest, more vague)");
		System.out.println("	3. Elmira (Lie)");
		System.out.println("	4. New York (Lie, more vague)");
		
		String response = r.readLine();
		if (response.equals("1")) //Paris
		{
			System.out.println ("Jim: Really? The Boss is really not a fan of foreigners...");
			System.out.println ("	1. Sorry- did I say Paris? I meant New York. I lived in Paris for a couple of years."
					+ " (Lie, relatively convincing)");
			System.out.println ("	2. Did I say Paris? I meant New York. (Lie, hardly convincing)");
			System.out.println ("	3. Yep. Paris. (Honest)");
			String currentLine = r.readLine();
			if (currentLine.equals("1")) //relatively convincing lie
			{
				System.out.println ("Oh, alright. I've always wanted to try this pizza place in New York, Jo's. Have you heard of it?");
				System.out.println ("	1. Yes. (Lie)");
				System.out.println ("	2. No. (Honest)");
				if(r.readLine().equals("1")) //yes, I've been to Jo's.
				{
					System.out.println("Have you been there?");
					System.out.println ("	1. Of course! (Lie)");
					System.out.println ("	2. No. (Honest)");
					if(r.readLine().equals("1"))
					{
						System.out.println ("What do you recommend?");
						//...more questioning
					}
					if(r.readLine().equals("2"))
					{
						System.out.println ("That's too bad.");
						//WIN: You've succeeded in convincing Jim you are a legit New Yorker.
					}
				}
				else if (r.readLine().contentEquals("2")) //no, I haven't heard of Jo's
				{
					System.out.println("H");
					//LOSE: Jim now very much doubts you're from NY, and will communicate this to the boss.
				}
			}
			else if (currentLine.equals("2")) //unconvincing lie that you meant to say NY
			{
				System.out.println("Why would you confuse those two?");
				// LOSE: Jim now very much doubts you're from NY, and will communicate this to the boss.
			}
			else if (currentLine.equals("3")) //truth
			{
				System.out.println ("Jim: That's too bad.");
				// LOSE: Jim now knows you're not from NY, and will communicate this to the boss.
			}
		} 
		else if (response.equals("2")) //France
		{
			//similar thing to Paris response
		}
		else if (response.equals("3")) {
			System.out.println("Sounds awful.");
		} //Elmira
		else if (response.equals("4")) {
			System.out.println("Ayyy!!!!!!");
		}
			
	}
	
	public static void main(String[] args) throws InterruptedException {
//		try {
//			(new NPC(null)).talkWithPlayer();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.print("option1");
		Thread.sleep(1000);
		System.out.print("\b\b\b\b\b\b\b");
		System.out.println("option2");
	}
}