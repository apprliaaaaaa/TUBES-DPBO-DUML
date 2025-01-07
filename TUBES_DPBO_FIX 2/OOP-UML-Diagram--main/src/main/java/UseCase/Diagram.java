// src/main/java/org/example/Diagram.java
package UseCase;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private String name;
    private List<Actor> actors;
    private List<UseCase> useCases;

    public Diagram(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.useCases = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addUseCase(UseCase useCase) {
        useCases.add(useCase);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder diagram = new StringBuilder();

        // Calculate dimensions
        int diagramWidth = 80;
        List<String> lines = new ArrayList<>();

        // Add title
        lines.add("«" + name + "»");
        lines.add("");

        // Calculate positions for actors and use cases
        int actorStartY = 3;
        int useCaseStartX = 35;

        // Draw actors
        for (int i = 0; i < actors.size(); i++) {
            int actorY = actorStartY + (i * 6);

            // Add stick figure for actor
            lines.add("     o     ");
            lines.add("    /|\\    ");
            lines.add("    / \\    ");
            lines.add(centerText(actors.get(i).getName(), 11));
            lines.add("");
            lines.add("");
        }

        // Draw system boundary
        StringBuilder boundary = new StringBuilder();
        boundary.append("    ").append("┌");
        boundary.append("─".repeat(40)).append("┐");
        lines.set(1, boundary.toString());

        // Add right boundary
        for (int i = 2; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            while (currentLine.length() < useCaseStartX + 41) {
                currentLine += " ";
            }
            if (i != lines.size() - 1) {
                currentLine = currentLine.substring(0, useCaseStartX - 1) + "│" +
                        currentLine.substring(useCaseStartX, useCaseStartX + 40) + "│";
            }
            lines.set(i, currentLine);
        }

        // Add bottom boundary
        StringBuilder bottomBoundary = new StringBuilder();
        bottomBoundary.append("    ").append("└");
        bottomBoundary.append("─".repeat(40)).append("┘");
        lines.add(bottomBoundary.toString());

        // Draw use cases
        for (int i = 0; i < useCases.size(); i++) {
            int useCaseY = actorStartY + (i * 4);
            if (useCaseY >= lines.size()) {
                // Add empty lines if needed
                while (lines.size() <= useCaseY) {
                    lines.add("");
                }
            }

            // Draw use case oval
            String useCaseLine = lines.get(useCaseY);
            String useCaseStr = "(" + useCases.get(i).getName() + ")";
            useCaseStr = centerText(useCaseStr, 20);

            // Insert use case at the right position
            while (useCaseLine.length() < useCaseStartX + useCaseStr.length()) {
                useCaseLine += " ";
            }
            useCaseLine = useCaseLine.substring(0, useCaseStartX) + useCaseStr +
                    useCaseLine.substring(useCaseStartX + useCaseStr.length());

            lines.set(useCaseY, useCaseLine);

            // Draw connection line if there's a corresponding actor
            if (i < actors.size()) {
                String connectorLine = lines.get(useCaseY);
                connectorLine = connectorLine.substring(0, 11) + "─────────────" +
                        connectorLine.substring(24);
                lines.set(useCaseY, connectorLine);
            }
        }

        // Combine all lines
        for (String line : lines) {
            diagram.append(line).append("\n");
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
