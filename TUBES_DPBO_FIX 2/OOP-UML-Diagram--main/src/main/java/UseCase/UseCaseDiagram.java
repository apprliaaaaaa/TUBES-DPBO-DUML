// File: UseCaseDiagram.java
package UseCase;

import java.util.*;

public class UseCaseDiagram {
    private String name;
    private List<Actor> actors;
    private List<UseCase> useCases;
    private List<Relationship> relationships;

    public UseCaseDiagram(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.useCases = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addUseCase(UseCase useCase) {
        useCases.add(useCase);
    }

    public void addRelationship(Actor actor, UseCase useCase, String type) {
        relationships.add(new Relationship(actor, useCase, type));
    }

 @Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    // Hitung dimensi diagram
    int maxActorWidth = actors.stream()
            .mapToInt(a -> a.getName().length())
            .max()
            .orElse(10);
    int maxUseCaseWidth = useCases.stream()
            .mapToInt(uc -> uc.getName().length())
            .max()
            .orElse(15);
    int totalWidth = maxActorWidth + maxUseCaseWidth + 20;

    // Tambahkan validasi
    if (actors.isEmpty() || useCases.isEmpty()) {
        return "Diagram kosong. Tambahkan aktor dan use case terlebih dahulu!";
    }

    // Gambarkan boundary diagram
    sb.append(centerText("[" + name + "]", totalWidth)).append("\n");
    sb.append("+" + "-".repeat(totalWidth - 2) + "+\n");

    drawDiagramContent(sb, maxActorWidth, maxUseCaseWidth, totalWidth);

    sb.append("+" + "-".repeat(totalWidth - 2) + "+\n");
    return sb.toString();
}

private void drawDiagramContent(StringBuilder sb, int maxActorWidth, int maxUseCaseWidth, int totalWidth) {
    // Pastikan aktor dan use case sesuai urutan
    int actorIndex = 0;
    int useCaseIndex = 0;

    for (int i = 0; i < Math.max(actors.size(), useCases.size()); i++) {
        sb.append("| ");

        // Tambahkan aktor (jika ada)
        if (actorIndex < actors.size()) {
            String actorName = actors.get(actorIndex).getName();
            sb.append(centerText(actorName, maxActorWidth));
            actorIndex++;
        } else {
            sb.append(" ".repeat(maxActorWidth));
        }

        sb.append(" ---> ");

        // Tambahkan use case (jika ada)
        if (useCaseIndex < useCases.size()) {
            String useCaseName = useCases.get(useCaseIndex).getName();
            sb.append(centerText("(" + useCaseName + ")", maxUseCaseWidth));
            useCaseIndex++;
        } else {
            sb.append(" ".repeat(maxUseCaseWidth));
        }

        sb.append(" |\n");
    }
}





    private void drawActorHead(StringBuilder sb, int width, int index) {
        sb.append(String.format("%-" + width + "s", "     o     "));
    }

    private void drawActorBody(StringBuilder sb, int width) {
        sb.append(String.format("%-" + width + "s", "    /|\\    "));
    }

    private void drawActorLegs(StringBuilder sb, int width) {
        sb.append(String.format("%-" + width + "s", "    / \\    "));
    }

    private void drawActorName(StringBuilder sb, String name, int width) {
        sb.append(centerText(name, width));
    }

    private void drawBlankLine(StringBuilder sb, int width) {
        sb.append(" ".repeat(width));
    }

    private void drawConnection(StringBuilder sb) {
        sb.append(" ──────► ");
    }

    private void drawBlankConnection(StringBuilder sb) {
        sb.append("         ");
    }

    private void drawUseCase(StringBuilder sb, String name, int width) {
        String useCase = "(" + name + ")";
        sb.append(centerText(useCase, width));
    }

    private void drawBlankUseCase(StringBuilder sb, int width) {
        sb.append(" ".repeat(width));
    }

    private String centerText(String text, int width) {
    int padding = (width - text.length()) / 2;
    return " ".repeat(Math.max(padding, 0)) + text + " ".repeat(Math.max(padding, 0));
}


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<UseCase> getUseCases() {
        return useCases;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }
}