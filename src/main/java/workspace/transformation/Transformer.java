package workspace.transformation;

import workspace.models.Entity;

import java.util.List;

public abstract class Transformer {
    protected abstract void transformSingleEntity(Entity entity);

    public abstract void transformEntities(List<Entity> entitiesList);
}
