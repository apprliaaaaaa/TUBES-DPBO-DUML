// File: Actor.java
package UseCase;

public class Actor {
    private int id;
    private String name;
    private String type; // Primary or Secondary actor

    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
        this.type = "Primary";
    }

    public Actor(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}