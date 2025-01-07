// File: SequenceDiagram.java
package Sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Sequence.Message;
import Sequence.Lifeline;

public class SequenceDiagram {
    private String name;
    private Map<String, Lifeline> lifelines;
    private List<Message> messages;

    public SequenceDiagram(String name) {
        this.name = name;
        this.lifelines = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public void addLifeline(String name, String type) {
        lifelines.put(name, new Lifeline(name, type));
    }

    public void addMessage(String from, String to, String text, String type) {
        Message msg = new Message(from, to, text, type);
        messages.add(msg);
        if (lifelines.containsKey(from)) {
            lifelines.get(from).addMessage(msg);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Sequence Diagram: ").append(name).append(" ===\n\n");

        sb.append("Lifelines:\n");
        for (Lifeline lifeline : lifelines.values()) {
            sb.append(lifeline).append("\n");
        }

        sb.append("\nMessages:\n");
        for (Message message : messages) {
            sb.append(message).append("\n");
        }

        return sb.toString();
    }
}