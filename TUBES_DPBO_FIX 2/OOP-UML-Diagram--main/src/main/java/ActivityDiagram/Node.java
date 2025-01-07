// File: Node.java
package ActivityDiagram;

import java.util.ArrayList;
import java.util.List;

public class Node extends Element{
    private List<String> outgoing;

    public Node(String id, String type, String label) {
        super(id,type,label,0);
        this.outgoing = new ArrayList<>();
    }
    
    public List<String> getOutgoing() { 
        return outgoing; 
    }

    public void addOutgoing(String targetId) {
        outgoing.add(targetId);
    }

    public String getSymbol() {
        switch (type) {
            case "start": return "(●)";
            case "end": return "(◉)";
            case "activity": return "[" + label + "]";
            case "decision": return "<>" + label;
            case "merge": return "<>";
            case "fork": return "===";
            case "join": return "===";
            default: return label;
        }
    }
}