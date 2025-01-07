/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDiagram;

/**
 *
 * @author dell
 */
import java.util.ArrayList;
import java.util.List;
public class ClassDiagram {
    private String className;
    private List<ClassAttribute> attributes;
    private List<ClassMethod> methods;
    private List<String> interfaces;
    private String superClass;
    private boolean isAbstract;
    private boolean isInterface;

    public ClassDiagram(String className) {
        this.className = className;
        this.attributes = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.interfaces = new ArrayList<>();
        this.isAbstract = false;
        this.isInterface = false;
    }

    public void addAttribute(String visibility, String name, String type) {
        attributes.add(new ClassAttribute(visibility, name, type));
    }

    public void addMethod(String visibility, String name, String returnType, List<String> parameters) {
        methods.add(new ClassMethod(visibility, name, returnType, parameters));
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public void addInterface(String interfaceName) {
        interfaces.add(interfaceName);
    }

    public String getClassName() {
        return className;
    }

    public List<ClassAttribute> getAttributes() {
        return new ArrayList<>(attributes);
    }

    public List<ClassMethod> getMethods() {
        return new ArrayList<>(methods);
    }

    public List<String> getInterfaces() {
        return new ArrayList<>(interfaces);
    }

    public String getSuperClass() {
        return superClass;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isInterface() {
        return isInterface;
    }

    @Override
    public String toString() {
        StringBuilder diagram = new StringBuilder();
        int width = Math.max(40, className.length() + 10);

        // Class name section with stereotypes
        StringBuilder titleLine = new StringBuilder();
        if (isInterface) {
            titleLine.append("<<interface>>\n");
        } else if (isAbstract) {
            titleLine.append("<<abstract>>\n");
        }
        titleLine.append(className);

        // Top border
        diagram.append("+").append("-".repeat(width - 2)).append("+\n");

        // Class name
        diagram.append("|").append(centerText(titleLine.toString(), width - 2)).append("|\n");

        // Separator
        diagram.append("+").append("-".repeat(width - 2)).append("+\n");

        // Attributes
        for (ClassAttribute attr : attributes) {
            diagram.append("| ").append(attr.toString())
                    .append(" ".repeat(width - attr.toString().length() - 3))
                    .append("|\n");
        }

        // Separator
        diagram.append("+").append("-".repeat(width - 2)).append("+\n");

        // Methods
        for (ClassMethod method : methods) {
            String methodStr = method.toString();
            // Handle method wrapping if too long
            if (methodStr.length() > width - 3) {
                while (methodStr.length() > width - 3) {
                    diagram.append("| ").append(methodStr.substring(0, width - 3))
                            .append("|\n");
                    methodStr = "  " + methodStr.substring(width - 3);
                }
            }
            diagram.append("| ").append(methodStr)
                    .append(" ".repeat(width - methodStr.length() - 3))
                    .append("|\n");
        }

        // Bottom border
        diagram.append("+").append("-".repeat(width - 2)).append("+\n");

        // Add inheritance relationship
        if (superClass != null) {
            diagram.append(" ".repeat(width/2 - 1)).append("^\n");
            diagram.append(" ".repeat(width/2 - 1)).append("|\n");
            diagram.append(" ".repeat(width/2 - superClass.length()/2 - 1))
                    .append(superClass).append("\n");
        }

        // Add interface implementations
        if (!interfaces.isEmpty()) {
            diagram.append(" ".repeat(width/2 - 1)).append("^\n");
            diagram.append(" ".repeat(width/2 - 1)).append("|\n");
            for (String iface : interfaces) {
                diagram.append(" ".repeat(width/2 - iface.length()/2 - 1))
                        .append(iface).append("\n");
            }
        }

        return diagram.toString();
    }

    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }
}