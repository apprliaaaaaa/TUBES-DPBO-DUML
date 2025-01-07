package ClassDiagram;

import java.util.*;
public class ClassMethod {
    private String name;
    private String returnType;
    private List<String> parameters;
    private String visibility; // "+", "-", "#", "~"

    public ClassMethod(String visibility, String name, String returnType, List<String> parameters) {
        this.visibility = visibility;
        this.name = name;
        this.returnType = returnType;
        this.parameters = new ArrayList<>(parameters);
    }

    @Override
    public String toString() {
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            params.append(parameters.get(i));
            if (i < parameters.size() - 1) {
                params.append(", ");
            }
        }
        return visibility + " " + name + "(" + params + "): " + returnType;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<String> getParameters() {
        return new ArrayList<>(parameters);
    }

    public String getVisibility() {
        return visibility;
    }
}