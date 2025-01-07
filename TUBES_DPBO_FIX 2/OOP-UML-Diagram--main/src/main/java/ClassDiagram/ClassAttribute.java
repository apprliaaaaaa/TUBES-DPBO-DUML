package ClassDiagram;

public class ClassAttribute {
    private String name;
    private String type;
    private String visibility; // "+", "-", "#", "~"

    public ClassAttribute(String visibility, String name, String type) {
        this.visibility = visibility;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return visibility + " " + name + ": " + type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVisibility() {
        return visibility;
    }
}