package testing;

import java.io.IOException;

import ai.*;
import model.*;
import proof.*;
import syntax.*;

public class Testing {
	
	public static void main(String[] args) throws InvalidTypeException {
		
		// people
		Individual bill = new Individual(4);
		Individual mike = new Individual(5);
		Individual dan = new Individual(20);
		Individual player = new Individual(123);
		
		Word billName = new Word("Bill", new NP(), 4);
		Word mikeName = new Word("Mike", new NP(), 5);
		Word danName = new Word("Dan", new NP(), 20);
		
		// places
		Individual e = new Individual(6);
		Individual n = new Individual(7);
		Individual p = new Individual(8);
		Individual f = new Individual(9);
		
		Word elmiraName = new Word("Elmira", new NP(), 6);
		Word newYorkName = new Word("New York", new NP(), 7);
		Word parisName = new Word("Paris", new NP(), 8);
		Word franceName = new Word("France", new NP(), 9);
		
		// 1-place functions
		// x is a place
		Function isPlace = new Function(10);
		isPlace.set(bill, new TruthValue(false));
		isPlace.set(mike, new TruthValue(false));
		isPlace.set(player, new TruthValue(false));
		isPlace.set(e, new TruthValue(true));
		isPlace.set(n, new TruthValue(true));
		isPlace.set(p, new TruthValue(true));
		isPlace.set(f, new TruthValue(true));
		
		Word isPlaceName = new Word("is a place", new Left(new S(), new NP()), 10);
		
		// 2-place functions
		
		// x contains y
		Function containsE = new Function();
		containsE.set(e, new TruthValue());
		containsE.set(n, new TruthValue());
		containsE.set(p, new TruthValue());
		containsE.set(f, new TruthValue());
		
		Function containsN = new Function();
		containsN.set(e, new TruthValue());
		containsN.set(n, new TruthValue());
		containsN.set(p, new TruthValue());
		containsN.set(f, new TruthValue());
		
		Function containsP = new Function();
		containsP.set(e, new TruthValue());
		containsP.set(n, new TruthValue());
		containsP.set(p, new TruthValue());
		containsP.set(f, new TruthValue());
		
		Function containsF = new Function();
		containsF.set(e, new TruthValue());
		containsF.set(n, new TruthValue());
		containsF.set(p, new TruthValue());
		containsF.set(f, new TruthValue());
		
		Function contains = new Function(11);
		
		contains.set(e, containsE);
		contains.set(n, containsN);
		contains.set(p, containsP);
		contains.set(f, containsF);
		
		Function bornin = new Function(12);
		Function billWasBornIn = new Function();
		Function mikeWasBornIn = new Function();
		Function danWasBornIn = new Function();
		Function playerWasBornIn = new Function();
		
		billWasBornIn.set(e, new TruthValue(true));
		billWasBornIn.set(n, new TruthValue());
		billWasBornIn.set(p, new TruthValue());
		billWasBornIn.set(f, new TruthValue());
		
		mikeWasBornIn.set(e, new TruthValue());
		mikeWasBornIn.set(n, new TruthValue());
		mikeWasBornIn.set(p, new TruthValue(true));
		mikeWasBornIn.set(f, new TruthValue());
		
		danWasBornIn.set(e, new TruthValue());
		danWasBornIn.set(n, new TruthValue());
		danWasBornIn.set(p, new TruthValue(true));
		danWasBornIn.set(f, new TruthValue());
		
		playerWasBornIn.set(e, new TruthValue());
		playerWasBornIn.set(n, new TruthValue());
		playerWasBornIn.set(p, new TruthValue());
		playerWasBornIn.set(f, new TruthValue());
		
		bornin.set(bill, billWasBornIn);
		bornin.set(mike, mikeWasBornIn);
		bornin.set(dan, danWasBornIn);
		bornin.set(player, playerWasBornIn);
		
		Model m = new Model();
		m.add(bill, mike, e, n, p, f, isPlace, contains, bornin);
		m.addName(4, billName);
		m.addName(5, mikeName);
		m.addName(20, danName);
		m.addName(6, elmiraName);
		m.addName(7, newYorkName);
		m.addName(8, parisName);
		m.addName(9, franceName);
		m.addName(10, isPlaceName);
		
		// make some sentences
		Constant eRef = new Constant(new E(), 6);
		Constant nRef = new Constant(new E(), 7);
		Constant pRef = new Constant(new E(), 8);
		Constant fRef = new Constant(new E(), 9);
		Constant placeRef = new Constant(new Arrow(new E(), new T()), 10);
		Constant containsRef = new Constant(new Arrow(new E(), new Arrow(new E(), new T())), 11);
		
		// Elmira is a place.
		Application eIsPlace = new Application(placeRef, eRef);
		// Bill is a place.
		Application billIsPlace = new Application(placeRef, new Constant(new E(), 4));
		
		// New York contains Elmira.
		Application nContainsE = new Application(new Application(containsRef, nRef), eRef);
		
		// Paris contains France
		Application fContainsP = new Application(new Application(containsRef, fRef), pRef);
		
		// New York does not contain France, vice versa
		Not notNContainsF = new Not(new Application(new Application(containsRef, nRef), fRef));
		Not notFContainsN = new Not(new Application(new Application(containsRef, fRef), nRef));
		
		// System.out.println(isPlace);
		
		// System.out.println("Elmira is a place. => " + m.satisfies(eIsPlace));
		// System.out.println("Bill is a place. => " + m.satisfies(billIsPlace));
		
		// System.out.println("New York contains Elmira. => " + m.satisfies(nContainsE));
		// System.out.println(contains);
		// System.out.println("updating..." + m.update(nContainsE));
		// System.out.println("updating..." + m.update(fContainsP));
		// System.out.println("updating..." + m.update(notNContainsF));
		// System.out.println("updating..." + m.update(notFContainsN));
		// System.out.println("New York contains Elmira. => " + m.satisfies(nContainsE));
		
		// System.out.println(nContainsE);
		
		Variable iv = new Variable(new E(), 0);
		Variable tv = new Variable(new E(), 1);
		// Lambda nContains = new Lambda(iv, new Application(new Application(containsRef, iv), nRef));
		//nContains = new Lambda(tv, new Application(nContains, tv));
		// System.out.println(nContains);
		// Application a = new Application(nContains, eRef);
		// System.out.println(a + " reduces to " + ((Application) a.reduce()).reduce());
		
		// System.out.println(m.satisfies(a));
		
		// reflexivity
		Rule reflexive = new Rule();
		LogicalForm reflexivityFormula = new Application(new Application(containsRef, iv), iv);
		reflexive.addBottom(reflexivityFormula);

		// anti-symmetry
		Rule antiSymmetric = new Rule();
		LogicalForm antiSymmetricAnte = new Application(new Application(containsRef, iv), tv);
		LogicalForm identity = new Equals(iv, tv);
		LogicalForm antiSymmetricCons = new Application(new Application(containsRef, tv), iv);
		antiSymmetric.addTop(antiSymmetricAnte);
		antiSymmetric.addTop(antiSymmetricCons);
		antiSymmetric.addBottom(identity);
		
		// transitivity
		Variable v3 = new Variable(new E(), 2);
		Rule transitive = new Rule();
		LogicalForm t1 = new Application(new Application(containsRef, iv), tv);
		LogicalForm t2 = new Application(new Application(containsRef, tv), v3);
		LogicalForm t3 = new Application(new Application(containsRef, iv), v3);
		transitive.addTop(t1);
		transitive.addTop(t2);
		transitive.addBottom(t3);

		// exclusion
		Rule exclusive = new Rule();
		LogicalForm e1 = new Application(new Application(containsRef, iv), tv);
		LogicalForm e2 = new Application(new Application(containsRef, v3), tv);
		LogicalForm e3 = new Application(new Application(containsRef, iv), v3);
		LogicalForm e4 = new Application(new Application(containsRef, v3), iv);
		exclusive.addTop(e1);
		exclusive.addTop(e2);
		exclusive.addBottom(e3);
		exclusive.addBottom(e4);
		
		// System.out.println(m.satisfies(new Equals(eRef, nRef)));
		// System.out.println("model updating reflexive: " + m.update(reflexive));
		// System.out.println("model updating antisymmetric: " + m.update(antiSymmetric));
		// System.out.println("model updating transitive: " + m.update(transitive));
		// System.out.println("model updating exclusive: " + m.update(exclusive));
		// System.out.println(m.get(11));
		
		Constant bornRef = new Constant(new Arrow(new E(), new Arrow (new E(), new T())), 12);
		
		// positive born-in rule
		Rule bornEntail = new Rule();
		LogicalForm b1 = new Application(new Application(bornRef, iv), tv);
		LogicalForm b2 = e2;
		LogicalForm b3 = new Application(new Application(bornRef, iv), v3);
		bornEntail.addTop(b1);
		bornEntail.addTop(b2);
		bornEntail.addBottom(b3);
		
		Rule bornReject = new Rule();
		LogicalForm r1 = b1;
		LogicalForm r2 = new Application(new Application(bornRef, iv), v3);
		LogicalForm r3 = e2;
		LogicalForm r4 = t2;
		bornReject.addTop(r1);
		bornReject.addTop(r2);
		bornReject.addBottom(r3);
		bornReject.addBottom(r4);
		
		// m.update(bornEntail);
		// m.update(bornReject);
		
		m.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
		m.update();
		
		// m.update(new Application(new Application(bornRef, new Constant(new E(), 4)), new Constant(new E(), 9)));
		m.setNames();
		// System.out.println(m.get(11));
		// System.out.println(m.get(12));
		
		// Phrase phr = new Phrase(billName, isPlaceName);
		// System.out.println(phr + " => " + phr.meaning(m));
		
		Model pollysModel = new Model();
		pollysModel.add(reflexive, antiSymmetric, transitive, exclusive, bornEntail, bornReject);
		pollysModel.update(m);
		
		NPC polly = new NPC(pollysModel);
		try {
			polly.talkWithPlayer();
		} catch (IOException | InterruptedException e5) {
			e5.printStackTrace();
		}
		
		// System.out.println(((Function) m.get(12)).apply(new Individual(123)));
		// System.out.println(mo.get(new Individual(123)));
		System.out.println(polly.getModel().get(12));
		
	}
}
