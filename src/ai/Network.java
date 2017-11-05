package ai;

import java.util.HashMap;
import java.util.HashSet;

public class Network {
	private HashSet<NPC> npcs = new HashSet<NPC>();
	private HashMap<NPC, HashSet<NPC>> connections = new HashMap<NPC, HashSet<NPC>>();
	
	public Network(NPC... nodes) {
		for (NPC npc : nodes) {
			npcs.add(npc);
		}
	}
	
	public void addConnection(NPC from, NPC to) {
		if (connections.containsKey(from)) {
			connections.get(from).add(to);
		} else {
			HashSet<NPC> t = new HashSet<NPC>();
			t.add(to);
			connections.put(from, t);
		}
	}
	
	public void update(NPC source) {
		if (connections.containsKey(source)) { 
			for (NPC target : connections.get(source)) {
				if (target.getModel().update(source.getModel())) {
					update(target);
				}
			}
		}
	}
}
