package workspace.fileHandlers.readers.parsers;

import com.opencsv.exceptions.CsvValidationException;
import workspace.models.EntityFactory;
import workspace.models.Entity;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    List<Entity> extractEntities(EntityFactory entityFactory, String fileName) throws IOException, CsvValidationException;
}
