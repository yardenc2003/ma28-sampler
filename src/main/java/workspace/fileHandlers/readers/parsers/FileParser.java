package workspace.fileHandlers.readers.parsers;

import workspace.models.Entity;
import workspace.models.EntityFactory;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    List<Entity> parseEntities(String fileName, EntityFactory entityFactory) throws IOException;
}
