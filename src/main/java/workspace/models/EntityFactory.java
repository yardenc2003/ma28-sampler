package workspace.models;

public interface EntityFactory {
    Entity create(String... fields) throws IllegalArgumentException;
}
