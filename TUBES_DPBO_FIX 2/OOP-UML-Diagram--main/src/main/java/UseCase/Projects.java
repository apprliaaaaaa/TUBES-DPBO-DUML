// src/main/java/org/example/Projects.java
package UseCase;

import java.util.ArrayList;
import java.util.List;

public class Projects {
    private int id;
    private String name;
    private User owner;
    private List<User> collaborators;
    private List<Diagram> diagrams;

    public Projects(int id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.collaborators = new ArrayList<>();
        this.diagrams = new ArrayList<>();
    }

    public void tambahKolaborator(User user) {
        collaborators.add(user);
    }

    public void hapusUser(User user) {
        collaborators.remove(user);
    }

    public void createDiagram(String name) {
        diagrams.add(new Diagram(name));
    }

    public void editDiagram(int index, String newName) {
        if (index >= 0 && index < diagrams.size()) {
            diagrams.get(index).setName(newName);
        }
    }

    public List<Diagram> getDiagrams() {
        return diagrams;
    }

    public void shareProject() {
        // Implement sharing logic
    }

    public void shareDiagram() {
        // Implement sharing logic
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", collaborators=" + collaborators +
                ", diagrams=" + diagrams +
                '}';
    }
}