package proof;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Rule {
	private List<LogicalForm> top;
	private List<LogicalForm> bot;
	
	public Rule() {
		top = new LinkedList<LogicalForm>();
		bot = new LinkedList<LogicalForm>();
	}
	
	public List<LogicalForm> getTop() {
		return top;
	}
	
	public List<LogicalForm> getBottom() {
		return bot;
	}
	
	public boolean addTop(LogicalForm l) {
		if (l.isFormula()) {
			top.add(l);
			return true;
		} return false;
	}
	
	public boolean addBottom(LogicalForm l) {
		if (l.isFormula()) {
			bot.add(l);
			return true;
		} return false;
	}
	
	private boolean move(LogicalForm l, List<LogicalForm> from, List<LogicalForm> to) {
		if (from.contains(l)) {
			from.remove(l);
			if (l instanceof Not) {
				Not n = ((Not) l);
				to.add(n.getSubsentence());
			} else {
				try {
					to.add(new Not(l));
				} catch (InvalidTypeException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean moveUp(LogicalForm l) {
		return move(l, bot, top);
	}
	
	public boolean moveDown(LogicalForm l) {
		return move(l, top, bot);
	}
	
	public Rule toContradiction() {
		Rule nr = clone();
		for (LogicalForm l : bot) {
			nr.moveUp(l);
		}
		return nr;
	}
	
	public Rule toTautology() {
		Rule nr = clone();
		for (LogicalForm l : bot) {
			nr.moveDown(l);
		}
		return nr;
	}
	
	public List<Rule> getCanonicalRules() {
		Rule contradiction = toContradiction();
		LinkedList<Rule> canonicalRules = new LinkedList<Rule>();
		for (LogicalForm l : contradiction.top) {
			Rule nr = contradiction.clone();
			nr.moveDown(l);
			canonicalRules.add(nr);
		}
		return canonicalRules;
	}
	
	@Override
	public Rule clone() {
		Rule nr = new Rule();
		for (LogicalForm l : top) {
			nr.addTop(l);
		}
		for (LogicalForm l : bot) {
			nr.addBottom(l);
		}
		return nr;
	}
	
	public Set<Variable> getFreeVariables() {
		HashSet<Variable> vars = new HashSet<Variable>();
		for (LogicalForm l : top) {
			vars.addAll(l.getFreeVariables(new HashSet<Variable>()));
		}
		for (LogicalForm l : bot) {
			vars.addAll(l.getFreeVariables(new HashSet<Variable>()));
		}
		return vars;
	}
	
	public Rule bind(int id, LogicalForm replace) {
		Rule newRule = new Rule();
		for (LogicalForm l : top) {
			newRule.addTop(l.bind(id, replace));
		}
		for (LogicalForm l : bot) {
			newRule.addBottom(l.bind(id, replace));
		}
		
		return newRule;
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (LogicalForm l : top) {
			s.append(l);
			s.append(",");
		}
		s.append("\u22A4 \u22A2 ");
		
		for (LogicalForm l : bot) {
			s.append(l);
			s.append(",");
		}
		
		s.append("\u22A5");
		
		return s.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("A, B, \u22A4 \u22A2 C, D, \u22A5");
	}
}
