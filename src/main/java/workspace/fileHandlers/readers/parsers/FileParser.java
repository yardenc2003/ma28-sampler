package workspace.fileHandlers.readers.parsers;

import com.opencsv.exceptions.CsvValidationException;
import workspace.fileHandlers.readers.parsers.csv.EntityFactory;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    <T> List<T> extractEntities(EntityFactory entityFactory, String fileName) throws IOException, CsvValidationException;
}
