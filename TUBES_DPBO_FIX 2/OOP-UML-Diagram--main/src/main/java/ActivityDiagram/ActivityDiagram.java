package ActivityDiagram;

import java.util.*;

public class ActivityDiagram implements INodeTypes{
    private String name;
    private Map<String, Node> nodes;
    private String startNodeId;

    public ActivityDiagram(String name) {
        this.name = name;
        this.nodes = new HashMap<>();
    }

    public void addNode(String id, String type, String label) {
        Node node = new Node(id, type, label);
        if (type.equals(START)) {
            startNodeId = id;
        }
        nodes.put(id, node);
    }

    public void addFlow(String fromId, String toId) {
        Node fromNode = nodes.get(fromId);
        if (fromNode != null) {
            fromNode.addOutgoing(toId);
        }
    }

    private void calculateLevels() {
        // Reset all levels
        for (Node node : nodes.values()) {
            node.setLevel(0);
        }

        // Start from the start node and do BFS
        if (startNodeId == null) return;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startNodeId);
        visited.add(startNodeId);

        while (!queue.isEmpty()) {
            String currentId = queue.poll();
            Node current = nodes.get(currentId);

            for (String nextId : current.getOutgoing()) {
                Node next = nodes.get(nextId);
                if (next != null) {
                    next.setLevel(current.getLevel() + 1);
                    if (!visited.contains(nextId)) {
                        queue.offer(nextId);
                        visited.add(nextId);
                    }
                }
            }
        }
    }

    private String getIndentation(int level) {
        return "  ".repeat(level);
    }

    @Override
    public String toString() {
        calculateLevels();
        StringBuilder sb = new StringBuilder();
        sb.append("=== Activity Diagram: ").append(name).append(" ===\n\n");
        
        // Create a map of nodes by level
        Map<Integer, List<Node>> nodesByLevel = new TreeMap<>();
        for (Node node : nodes.values()) {
            nodesByLevel.computeIfAbsent(node.getLevel(), k -> new ArrayList<>()).add(node);
        }
        
        // Display nodes level by level
        for (Map.Entry<Integer, List<Node>> entry : nodesByLevel.entrySet()) {
            for (Node node : entry.getValue()) {
                // Add indentation based on level
                sb.append(getIndentation(node.getLevel()));
                
                // Add node symbol
                sb.append(getNodeSymbol(node));
                
                // Add arrows to outgoing nodes
                if (!node.getOutgoing().isEmpty()) {
                    sb.append("\n");
                    for (String targetId : node.getOutgoing()) {
                        Node target = nodes.get(targetId);
                        if (target != null) {
                            sb.append(getIndentation(node.getLevel() + 1));
                            sb.append("-> ");
                            sb.append(getNodeSymbol(target));
                            sb.append("\n");
                        }
                    }
                } else {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private String getNodeSymbol(Node node) {
        switch (node.getType().toLowerCase()) {
            case START:
                return "(*)";
            case END:
                return "(/)";
            case DECISION:
                return "<>";
            case MERGE:
                return "<>";
            case FORK:
                return "===";
            case JOIN:
                return "===";
            default:
                return "[" + node.getLabel() + "]";
        }
    }
}