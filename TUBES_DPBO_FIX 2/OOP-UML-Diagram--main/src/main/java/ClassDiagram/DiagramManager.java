package ClassDiagram;

import java.util.*;

public class DiagramManager {
    private Map<String, ClassDiagram> classDiagrams;

    public DiagramManager() {
        this.classDiagrams = new HashMap<>();
    }

    public void addClass(String className, boolean isAbstract, boolean isInterface) {
        ClassDiagram classDiagram = new ClassDiagram(className);
        classDiagram.setAbstract(isAbstract);
        classDiagram.setInterface(isInterface);
        classDiagrams.put(className, classDiagram);
    }

    public void addAttribute(String className, String visibility, String attributeName, String type) {
        ClassDiagram classDiagram = classDiagrams.get(className);
        if (classDiagram != null) {
            classDiagram.addAttribute(visibility, attributeName, type);
        }
    }

    public void addMethod(String className, String visibility, String methodName,
                          String returnType, List<String> parameters) {
        ClassDiagram classDiagram = classDiagrams.get(className);
        if (classDiagram != null) {
            classDiagram.addMethod(visibility, methodName, returnType, parameters);
        }
    }

    public void addRelationship(String sourceClass, String targetClass, boolean isInheritance) {
        ClassDiagram source = classDiagrams.get(sourceClass);
        if (source != null) {
            if (isInheritance) {
                source.setSuperClass(targetClass);
            } else {
                source.addInterface(targetClass);
            }
        }
    }

    public ClassDiagram getClassDiagram(String className) {
        return classDiagrams.get(className);
    }

    public Set<String> getClassNames() {
        return classDiagrams.keySet();
    }

    public boolean hasClass(String className) {
        return classDiagrams.containsKey(className);
    }
}