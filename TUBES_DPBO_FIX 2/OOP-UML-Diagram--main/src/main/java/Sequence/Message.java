// File: Message.java
package Sequence;

public class Message {
    private String fromLifeline;
    private String toLifeline;
    private String messageText;
    private String messageType; // sync, async, reply

    public Message(String from, String to, String text, String type) {
        this.fromLifeline = from;
        this.toLifeline = to;
        this.messageText = text;
        this.messageType = type;
    }

    @Override
    public String toString() {
        String arrow;
        switch (messageType.toLowerCase()) {
            case "sync": arrow = "->"; break;
            case "async": arrow = "-->"; break;
            case "reply": arrow = "-->"; break;
            default: arrow = "->";
        }
        return fromLifeline + " " + arrow + " " + toLifeline + ": " + messageText;
    }
}