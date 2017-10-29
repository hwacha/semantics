package ai;

import java.util.HashMap;
import java.util.HashSet;

public class Network {
	private HashSet<NPC> npcs = new HashSet<NPC>();
	private HashMap<NPC, NPC> connections = new HashMap<NPC, NPC>();
	
	public Network(NPC... nodes) {
		for (NPC npc : nodes) {
			npcs.add(npc);
		}
	}
	
	public void addConnection(NPC from, NPC to) {
		connections.put(from, to);
	}
}
