// File: Lifeline.java
package Sequence;

import java.util.ArrayList;
import java.util.List;


public class Lifeline {
    private String name;
    private String type; // actor, object, or component
    private List<Message> messages;

    public Lifeline(String name, String type) {
        this.name = name;
        this.type = type;
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lifeline: ").append(name).append(" (").append(type).append(")\n");
        for (Message message : messages) {
            sb.append("  ").append(message).append("\n");
        }
        return sb.toString();
    }
}