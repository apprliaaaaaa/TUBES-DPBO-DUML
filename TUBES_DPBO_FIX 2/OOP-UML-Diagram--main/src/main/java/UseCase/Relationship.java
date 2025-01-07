// File: Relationship.java
package UseCase;

public class Relationship {
    private Actor actor;
    private UseCase useCase;
    private String type; // "includes", "extends", "association"

    public Relationship(Actor actor, UseCase useCase, String type) {
        this.actor = actor;
        this.useCase = useCase;
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public UseCase getUseCase() {
        return useCase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return actor.getName() + " --" + type + "--> " + useCase.getName();
    }
}