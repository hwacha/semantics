package testing;

import java.io.IOException;

import ai.*;
import model.*;
import proof.*;
import syntax.*;

public class Testing {
	
	public static void main(String[] args) throws InvalidTypeException {
		
		// people
//		Individual bill = new Individual(4);
//		Individual mike = new Individual(5);
//		Individual dan = new Individual(20);
		Individual effi = new Individual(10);
		Individual jane = new Individual(11);
//		Individual player = new Individual(123);
		//		
		
		Word effiName = new Word("Effi", new NP(), 10);
		Word janeName = new Word("Jane", new NP(), 11);
		Word raffaName = new Word("Raffa", new NP(), 12);
		
//		Word billName = new Word("Bill", new NP(), 4);
//		Word mikeName = new Word("Mike", new NP(), 5);
//		Word danName = new Word("Dan", new NP(), 20);
		
		// places
//		Individual e = new Individual(6);
//		Individual n = new Individual(7);
//		Individual p = new Individual(8);
//		Individual f = new Individual(9);
		
//		Word elmiraName = new Word("Elmira", new NP(), 6);
//		Word newYorkName = new Word("New York", new NP(), 7);
//		Word parisName = new Word("Paris", new NP(), 8);
//		Word franceName = new Word("France", new NP(), 9);
		

		
		// 1-place functions
		// x is a place
//		Function isPlace = new Function(10);
//		isPlace.set(bill, new TruthValue(false));
//		isPlace.set(mike, new TruthValue(false));
//		isPlace.set(dan, new TruthValue(false));
//		isPlace.set(player, new TruthValue(false));
//		isPlace.set(e, new TruthValue(true));
//		isPlace.set(n, new TruthValue(true));
//		isPlace.set(p, new TruthValue(true));
//		isPlace.set(f, new TruthValue(true));
		
//		Word isPlaceName = new Word("is a place", new Left(new S(), new NP()), 10);
//		
//		// 2-place functions
//		
//		// x contains y
//		Function containsE = new Function();
//		containsE.set(e, new TruthValue());
//		containsE.set(n, new TruthValue());
//		containsE.set(p, new TruthValue());
//		containsE.set(f, new TruthValue());
//		
//		Function containsN = new Function();
//		containsN.set(e, new TruthValue());
//		containsN.set(n, new TruthValue());
//		containsN.set(p, new TruthValue());
//		containsN.set(f, new TruthValue());
//		
//		Function containsP = new Function();
//		containsP.set(e, new TruthValue());
//		containsP.set(n, new TruthValue());
//		containsP.set(p, new TruthValue());
//		containsP.set(f, new TruthValue());
//		
//		Function containsF = new Function();
//		containsF.set(e, new TruthValue());
//		containsF.set(n, new TruthValue());
//		containsF.set(p, new TruthValue());
//		containsF.set(f, new TruthValue());
//		
//		Function contains = new Function(11);
//		
//		contains.set(e, containsE);
//		contains.set(n, containsN);
//		contains.set(p, containsP);
//		contains.set(f, containsF);
//		
//		Function bornin = new Function(12);
//		Function billWasBornIn = new Function();
//		Function mikeWasBornIn = new Function();
//		Function danWasBornIn = new Function();
//		Function playerWasBornIn = new Function();
////	
	
		Function isConsistent = new Function(29);
		isConsistent.set(jane, new TruthValue(true));
		
		Function knowsRaffa = new Function(30);
		knowsRaffa.set(jane, new TruthValue());
		
		Individual dead = new Individual(7);
		Individual gettingGroceries = new Individual(8);
		Individual replaced = new Individual(9);
		
		Function theStatusOfRaffaIs = new Function(31);
		
		Function knowsTheStatusOfRaffaIs = new Function(32);
		Function janeKnowsTheStatusOfRaffaIs = new Function(33);
	
		janeKnowsTheStatusOfRaffaIs.set(dead, new TruthValue());
		janeKnowsTheStatusOfRaffaIs.set(gettingGroceries, new TruthValue());
		janeKnowsTheStatusOfRaffaIs.set(replaced, new TruthValue());
		
		knowsTheStatusOfRaffaIs.set(jane, janeKnowsTheStatusOfRaffaIs);
		
//		billWasBornIn.set(e, new TruthValue(true));
//		billWasBornIn.set(n, new TruthValue());
//		billWasBornIn.set(p, new TruthValue());
//		billWasBornIn.set(f, new TruthValue());
////		
//		mikeWasBornIn.set(e, new TruthValue());
//		mikeWasBornIn.set(n, new TruthValue());
//		mikeWasBornIn.set(p, new TruthValue(true));
//		mikeWasBornIn.set(f, new TruthValue());
////		
//		danWasBornIn.set(e, new TruthValue());
//		danWasBornIn.set(n, new TruthValue());
//		danWasBornIn.set(p, new TruthValue(true));
//		danWasBornIn.set(f, new TruthValue());
////		
//		playerWasBornIn.set(e, new TruthValue());
//		playerWasBornIn.set(n, new TruthValue());
//		playerWasBornIn.set(p, new TruthValue());
//		playerWasBornIn.set(f, new TruthValue());
////		
//		bornin.set(bill, billWasBornIn);
//		bornin.set(mike, mikeWasBornIn);
//		bornin.set(dan, danWasBornIn);
//		bornin.set(player, playerWasBornIn);
		
//		Model m = new Model();
////		m.add(e, n, p, f, isPlace, contains);
//		m.add(bill, mike, dan, player, e, n, p, f, isPlace, contains, bornin);
//		m.addName(4, billName);
//		m.addName(5, mikeName);
//		m.addName(20, danName);
//		m.addName(6, elmiraName);
//		m.addName(7, newYorkName);
//		m.addName(8, parisName);
//		m.addName(9, franceName);
//		m.addName(10, isPlaceName);
		
		Model effisModel = new Model();
		effisModel.add(jane, isConsistent, knowsRaffa, theStatusOfRaffaIs,
				       knowsTheStatusOfRaffaIs, dead, gettingGroceries, replaced);
		
		Model m = new Model();
		
		//sentences
		Constant deadRef = new Constant(new E(), 7);
		Constant groceriesRef = new Constant(new E(), 8);
		Constant replacedRef = new Constant(new E(), 9);
		Constant consistentRef = new Constant(new Arrow(new E(), new T()), 29);
		Constant knowsRaffaRef = new Constant(new Arrow(new E(), new T()), 30);		
		Constant statusOfRaffaRef = new Constant(new Arrow(new E(), new T()), 31);		
		Constant knowsStatusOfRaffaRef = 
				new Constant(new Arrow(new E(), new Arrow(new E(), new T())), 32);
		
		
		// if don't know the person, can't know their status
		Variable person = new Variable(new E(), 2);
		Variable statusX = new Variable(new E(), 90);

		Rule dontKnowCantKnowStatus = new Rule();
		LogicalForm top1 = new Not(new Application(knowsRaffaRef, person));
		LogicalForm bot1 = new Not(new Application(new Application(knowsStatusOfRaffaRef, person), statusX));
		dontKnowCantKnowStatus.addTop(top1);
		dontKnowCantKnowStatus.addBottom(bot1);
		
		//if the status of raffa is X, it can't be Y provided X != Y
		Variable status1 = new Variable(new E(), 60);
		Variable status2 = new Variable(new E(), 61);
		
		Rule singleStatusOnly = new Rule();
		LogicalForm top2a = new Application(statusOfRaffaRef, status1);
		LogicalForm top2b = new Not(new Equals(status1, status2));
		LogicalForm bot2 = new Not(new Application(statusOfRaffaRef, status2));
		
		singleStatusOnly.addTop(top2a);
		singleStatusOnly.addTop(top2b);
		singleStatusOnly.addBottom(bot2);
		
		effisModel.add(dontKnowCantKnowStatus);
		effisModel.add(singleStatusOnly);

//		
//		// a trivially true sentence that is a placeholder for actual name stuff
		LogicalForm ta = new Verum();
		S s = new S();
		
		Prompt p1 = new Prompt("What's your name?", new Expression[]{
				new Word("Bill", new S(), ta),
				new Word("Mike", new S(), ta),
				new Word("Dan", new S(), ta)},
				new Message[][]{
					new Message[]{
							new Prompt("Like...Bill Gates?",
									new Expression[] {
											new Word("yes", new S(), ta),
											new Word("no", new S(), ta)
									},
									new Message[][] { 
										new Message[]{new Message("Give me money.")},
										new Message[]{new Message("That's too bad.")}
									})
					},
					new Message[]{new Message("Mike is a shitty name.")},
					new Message[]{new Message("Dan is a generic name.")}});
		
		// the player was born in x.
		// LogicalForm playerWasBornIn2 = new Application(new Constant(new Arrow(new E(), eToT), 12), new Constant(new E(), 123));
		
		// the player was born in elmira.
//		Expression e6 = new Word("Elmira.", new S(), new Application(playerWasBornIn2, new Constant(new E(), 6)));
//		Expression n2 = new Word("New York.", new S(), new Application(playerWasBornIn2, new Constant(new E(), 7)));
//		Expression p2 = new Word("Paris.", new S(), new Application(playerWasBornIn2, new Constant(new E(), 8)));
//		Expression f2 = new Word("France.", new S(), new Application(playerWasBornIn2, new Constant(new E(), 9)));
		
		
		//TODO change so that you only need the NPs instead of whole sentence:
		// give template combining question and response.
		
		Honest h = new Honest();
		Lie l = new Lie();
		Deflect d = new Deflect();
		
		Message[] blank = {new Message("")};
		
		Prompt farloPopzRequest = new Prompt("Could you tell me where the Eyeball Popz are?",
				new Expression[]{new Word("I'm new here. I'm not too sure.", h),
								 new Word("Snacks on Aisle 2.", h),
								 new Word("Right over there.", h), 
								 new Word("Aisle 1.", l),
								 new Word("We don't sell Eyeball Popz here.", l)},
				new Message[][]{blank, blank,
								new Message[]{
										new Prompt("What? Where?",
													new Expression[]{new Word("In... that general direction", h)},
													new Message[][]{blank})},
								blank,
								{new Message("Oh, that's a bummer. I'll just look around then. Thanks!")}});
		
		Prompt farloProbe = new Prompt("Never seen you before. When did you get here?",
				new Expression[]{new Word("Very recently.", h),
								 new Word("This week.", h),
								 new Word("Yesterday.", h),
								 new Word("Last month.", l),
								 new Word("Long time ago, buddy.", l),
								 new Word("Probably been here since you've been born.", l)},
				new Message[][]{{farloPopzRequest}, {farloPopzRequest}, {farloPopzRequest}, {farloPopzRequest}, {farloPopzRequest},
								{new Message("Wow, that's a long time. Never noticed you before!"), farloPopzRequest}});
		
		Prompt farlosIntro = new Prompt("Ay. You're new here aren't you?",
				new Expression[]{new Word("Yeah.", h),
								 new Word("Mhm.", h),
								 new Word("Yes I am. I'm also a human.", h),
								 new Word("Nope.", l),
								 new Word("Been here awhile now.", l),
								 new Word("Who's askin'?", d),
								 new Word("Can I help you?", d)},
				new Message[][]{{farloProbe}, {farloProbe}, {farloProbe}, {farloProbe}, {farloProbe}, {farloPopzRequest}, {farloPopzRequest}});
		
		Model farlosModel = new Model();
		NPC farlo = new NPC("Farlo", farlosModel, new Message[]{farlosIntro});
		
//		//Effi - Mags & OJ starts here:
//		Prompt effisIntro = new Prompt("Hey. Where's Raffa?",
//				new Expression[]{new Word("I'm new here. Just got here from Earth.", h), //triggers questioning 1
//								 new Word("I'm new here. Who's Raffa?", h),
//								 new Word("Don't know what happened to him. Can I help you with anything?", h),
//								 new Word("Raffa went out to get groceries. ", l),
//								 new Word("Raffa's dead.", l),
//								 new Word("I've been here a while now; maybe Raffa got replaced.", l),
//								 new Word("Don't know. Can I help you?", d), 
//								 new Word("Who's asking?", d),
//								 new Word("What's wrong with your face?", d)},
//				new Message[][]{{questioning1}, 
//								{new Message("He used to work here."), specialOrder}, 
//								{specialOrder}, 
//								{new Message("Oh okay... wait a sec. This is a grocery store. I don't know what you're"
//										   + "hiding, but i'm not gonna ask."), specialOrder}, 
//								{new Message("Damn. Guy had it coming, I guess..."), specialOrder}, 
//								{specialOrder}, 
//								{specialOrder}, 
//								{new Message("Oh... the name's Effi. Raffa was a friend."), specialOrder}, 
//								{new Prompt("What? What�s wrong with it? Do I have something on it?", 
//										new Expression[]{new Word("Oh, no. Nevermind. I must be seeing things.")},
//										new Message[][] {blank})}});
//		
//		Prompt questioning1 = new Prompt("*squints suspiciously* What was your name again?",
//				new Expression[]{new Word("I'm new here. Just got here from Earth.", h), //triggers questioning 1
//						 new Word("Jane.", h),
//						 new Word("Janet.", l),
//						 new Word("Jody.", l),
//						 new Word("J'thalux.", l),
//						 new Word("You know what, let me just check the back.", d), //only available if lie check 1 inconsistent
//						 new Word("Listen, buddy. Get out of here or I'll report you for trying to get" + 
//						 "human goods", d)},
//				new Message[][]{blank, 
//						//LEFT OFF COPYING FROM GOOGLE DOCS HERE 4/22
//						{new Message("He used to work here."), specialOrder}, 
//						{specialOrder}, 
//						{new Message("Oh okay... wait a sec. This is a grocery store. I don't know what you're"
//								   + "hiding, but i'm not gonna ask."), specialOrder}, 
//						{new Message("Damn. Guy had it coming, I guess..."), specialOrder}, 
//						{specialOrder}, 
//						{specialOrder}, 
//						{new Message("Oh... the name's Effi. Raffa was a friend."), specialOrder}, 
//						{new Prompt("What? What�s wrong with it? Do I have something on it?", 
//								new Expression[]{new Word("Oh, no. Nevermind. I must be seeing things.")},
//								new Message[][] {blank})}});
//		
//		Prompt specialOrder = new Prompt();
		
		
		
		
		// make some sentences
//		Constant eRef = new Constant(new E(), 6);
//		Constant nRef = new Constant(new E(), 7);
//		Constant pRef = new Constant(new E(), 8);
//		Constant fRef = new Constant(new E(), 9);
//		Constant placeRef = new Constant(new Arrow(new E(), new T()), 10);
//		Constant containsRef = new Constant(new Arrow(new E(), new Arrow(new E(), new T())), 11);
//		Constant bornRef = new Constant(new Arrow(new E(), new Arrow(new E(), new T())), 12);
//		Constant playRef = new Constant(new E(), 123);
//		
//		// Elmira is a place.
//		Application eIsPlace = new Application(placeRef, eRef);
//		// Bill is a place.
//		Application billIsPlace = new Application(placeRef, new Constant(new E(), 4));
//
//		// New York contains Elmira.
//		Application nContainsE = new Application(new Application(containsRef, nRef), eRef);
//
//		// Paris contains France
//		Application fContainsP = new Application(new Application(containsRef, fRef), pRef);
//
//		// New York does not contain France, vice versa
//		Not notNContainsF = new Not(new Application(new Application(containsRef, nRef), fRef));
//		Not notFContainsN = new Not(new Application(new Application(containsRef, fRef), nRef));
//		
//		// System.out.println(isPlace);
//		
//		// System.out.println("Elmira is a place. => " + m.satisfies(eIsPlace));
//		// System.out.println("Bill is a place. => " + m.satisfies(billIsPlace));
//		
//		// System.out.println("New York contains Elmira. => " + m.satisfies(nContainsE));
//		// System.out.println(contains);
//		m.update(nContainsE);
//		m.update(fContainsP);
//		m.update(notNContainsF);
//		m.update(notFContainsN);
//		// System.out.println("New York contains Elmira. => " + m.satisfies(nContainsE));
//		
//		// System.out.println(nContainsE);
//		
//		Variable iv = new Variable(new E(), 0);
//		Variable tv = new Variable(new E(), 1);
//		// Lambda nContains = new Lambda(iv, new Application(new Application(containsRef, iv), nRef));
//		//nContains = new Lambda(tv, new Application(nContains, tv));
//		// System.out.println(nContains);
//		// Application a = new Application(nContains, eRef);
//		// System.out.println(a + " reduces to " + ((Application) a.reduce()).reduce());
//		
//		// System.out.println(m.satisfies(a));
//		
//		// reflexivity
//		Rule reflexive = new Rule();
//		LogicalForm reflexivityFormula = new Application(new Application(containsRef, iv), iv);
//		reflexive.addBottom(reflexivityFormula);
//
//		// anti-symmetry
//		Rule antiSymmetric = new Rule();
//		LogicalForm antiSymmetricAnte = new Application(new Application(containsRef, iv), tv);
//		LogicalForm identity = new Equals(iv, tv);
//		LogicalForm antiSymmetricCons = new Application(new Application(containsRef, tv), iv);
//		antiSymmetric.addTop(antiSymmetricAnte);
//		antiSymmetric.addTop(antiSymmetricCons);
//		antiSymmetric.addBottom(identity);
//		
//		// transitivity
//		Variable v3 = new Variable(new E(), 2);
//		Rule transitive = new Rule();
//		LogicalForm t1 = new Application(new Application(containsRef, iv), tv);
//		LogicalForm t2 = new Application(new Application(containsRef, tv), v3);
//		LogicalForm t3 = new Application(new Application(containsRef, iv), v3);
//		transitive.addTop(t1);
//		transitive.addTop(t2);
//		transitive.addBottom(t3);
//
//		// exclusion
//		Rule exclusive = new Rule();
//		LogicalForm e1 = new Application(new Application(containsRef, iv), tv);
//		LogicalForm e2 = new Application(new Application(containsRef, v3), tv);
//		LogicalForm e3 = new Application(new Application(containsRef, iv), v3);
//		LogicalForm e4 = new Application(new Application(containsRef, v3), iv);
//		exclusive.addTop(e1);
//		exclusive.addTop(e2);
//		exclusive.addBottom(e3);
//		exclusive.addBottom(e4);
//		
//		// System.out.println(m.satisfies(new Equals(eRef, nRef)));
//		// System.out.println("model updating reflexive: " + m.update(reflexive));
//		// System.out.println("model updating antisymmetric: " + m.update(antiSymmetric));
//		// System.out.println("model updating transitive: " + m.update(transitive));
//		// System.out.println("model updating exclusive: " + m.update(exclusive));
//		// System.out.println(m.get(11));
//		
//		// Constant bornRef = new Constant(new Arrow(new E(), new Arrow (new E(), new T())), 12);
//		
//		// positive born-in rule
//		Rule bornEntail = new Rule();
//		LogicalForm b1 = new Application(new Application(bornRef, iv), tv);
//		LogicalForm b2 = e2;
//		LogicalForm b3 = new Application(new Application(bornRef, iv), v3);
//		bornEntail.addTop(b1);
//		bornEntail.addTop(b2);
//		bornEntail.addBottom(b3);
//		
//		// negative born-in rule
//		Rule bornReject = new Rule();
//		LogicalForm r1 = b1;
//		LogicalForm r2 = new Application(new Application(bornRef, iv), v3);
//		LogicalForm r3 = e2;
//		LogicalForm r4 = t2;
//		bornReject.addTop(r1);
//		bornReject.addTop(r2);
//		bornReject.addBottom(r3);
//		bornReject.addBottom(r4);
//		
		

		
//		m.update(bornEntail);
//		m.update(bornReject);
//		
//		m.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
//		m.update();
//		
//		// m.update(new Application(new Application(bornRef, new Constant(new E(), 4)), new Constant(new E(), 9)));
//		m.setNames();
//		// System.out.println(m.get(12));
//		
//		// System.out.println(((Function) ((Function) m.get(11)).apply(new Individual(6))).apply(new Individual(6)));
//		//System.out.println(m.get(12));
//		
//		// Phrase phr = new Phrase(billName, isPlaceName);
//		// System.out.println(phr + " => " + phr.meaning(m));
//		
//		SemanticType eToT = new Arrow(new E(), new T());
		
//		Prompt barrysIntro = new Prompt("What can I make you?",
//				new Expression[]{new Word("Blood Slurp.", s, ta),
//								 new Word("Blood Pop.", s, ta),
//								 new Word("Orange Juice", s, ta)},
//				new Message[][]{new Message[]{new Message("Blood slurp, coming right up.")},
//							    new Message[]{new Message("Blood pop? Bold choice.")},
//							    new Message[]{new Message("That's too hard to come by; can't pass customs.")}});
//		
//		Message barryExp1 = new Message("Here's what you need to know about this shindig...");
//		Message barryExp2 = new Message("I don't talk to anyone here...");
//		Message barryExp3 = new Message("And Pete and Polly hate each other...");
//		Message barryExp4 = new Message("But they both report to Ross the Boss.");
//		Message barryExp5 = new Message("He only likes New Yorkers...");
//		Message barryExp6 = new Message("So if you want to get on his good side, you better be from the Empire State.");
//		
//		Message barryPrompt = new Prompt("Let me know if you need anything else.",
//				new Expression[]{
//					new Word("Can you give me the low-down on the scene here?", new S(), ta),
//					new Word("That's all, thanks!", s, ta)},
//				new Message[][]{new Message[]{
//						barryExp1, barryExp2, barryExp3,
//						barryExp4, barryExp5, barryExp6}, new Message[]{new Message("Any time!")}});
//		
//		Message pollysIntro = new Message("Hello! I'm polly! I like crackers!");
//		Message petesIntro = new Message("How do you do? I'm Pete, a patronizing patron.");
//		Message rossIntro = new Message("I'm Ross, the boss. How's this fine evenin' treatin' you?");
//		
//		LogicalForm playerFromNewYork = new Application(playerWasBornIn2, new Constant(new E(), 7));
//		LogicalForm playerNotFromNewYork = new Not(playerFromNewYork);
//		
//		Message rossGiveKey = new Message("I like people from NEW YORK STATE. Here's the key to the door.",
//				new LogicalForm[]{playerFromNewYork});
//		
//		Message rossDenyKey = new Message("I see you're not from New York... No key for you.",
//				new LogicalForm[]{playerNotFromNewYork});
//		
//		Prompt p11 = new Prompt("Where are you from?", new Expression[]{e6, n2, p2 , f2},
//				new Message[][]{
//						new Message[]{new Message("Elmira sounds awful.")},
//						new Message[]{new Message("New York is all right.")},
//						new Message[]{new Message("Paris sucks.")},
//						new Message[]{new Message("Oh.")}});
//		
//		Message m1 = new Message("END OF CONVERSATION");
//		
//		Message[] barrysConvo = new Message[]{barrysIntro, barryPrompt, p11, m1};
//		Message[] pollysConvo = new Message[]{pollysIntro, p11 , m1};
//		Message[] petesConvo = new Message[]{petesIntro, p11, m1};
//		Message[] rossConvo = new Message[]{rossIntro, rossGiveKey, rossDenyKey};
//		
//		Model barrysModel = new Model();
//		barrysModel.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
//		barrysModel.update(m);
//		NPC barry = new NPC("Barry the Bartender", barrysModel, barrysConvo);
//		
//		Model pollysModel = new Model();
//		pollysModel.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
//		pollysModel.update(m);
//		NPC polly = new NPC("Polly the Patron", pollysModel, pollysConvo);
//		
//		Model petesModel = new Model();
//		petesModel.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
//		petesModel.update(m);
//		NPC pete = new NPC("Pete the Patron", petesModel, petesConvo);
//		
//		Model rossModel = new Model();
//		rossModel.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
//		rossModel.update(m);
//		NPC ross = new NPC("Ross the Boss", rossModel, rossConvo);
//		
//		Network net = new Network(barry, polly, pete, ross);
//		net.addConnection(polly, ross);
//		net.addConnection(pete, ross);
		
		try {
			farlo.talkWithPlayer();
		} catch (IOException | InterruptedException e5) {
			e5.printStackTrace();
		}
		
//		try {
//			barry.talkWithPlayer();
//		} catch (IOException | InterruptedException e5) {
//			e5.printStackTrace();
//		}
//		net.update(barry);
//		
//		try {
//			polly.talkWithPlayer();
//		} catch (IOException | InterruptedException e5) {
//			e5.printStackTrace();
//		}
//		net.update(polly);
//		
//		try {
//			pete.talkWithPlayer();
//		} catch (IOException | InterruptedException e5) {
//			e5.printStackTrace();
//		}
//		net.update(pete);
//		
//		System.out.print("Ross the boss: ");
//		if (ross.getModel().hasInconsistency()) {
//			System.out.println("You lied. So you died.");
//		} else {
//			try {
//				ross.talkWithPlayer();
//			} catch (IOException | InterruptedException e5) {
//				e5.printStackTrace();
//			}
//		}
		
//		try {
//			ross.talkWithPlayer();
//		} catch (IOException | InterruptedException e5) {
//			e5.printStackTrace();
//		}
//		net.update(ross);
		
		// System.out.println(((Function) m.get(12)).apply(new Individual(4)));
		// System.out.println(mo.get(new Individual(123)));
		// System.out.println(polly.getModel().get(12));
		
	}
}
