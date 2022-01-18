package workspace.fileHandlers.readers.parsers.csv;

import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import workspace.fileHandlers.readers.parsers.FileParser;
import workspace.models.Entity;
import workspace.models.EntityFactory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements FileParser {

    @SneakyThrows
    @Override
    public List<Entity> parseEntities(String fileName, EntityFactory entityFactory) {
        List<Entity> entitiesList = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        String[] record;
           csvReader.readNext(); // skips the first record (cells names)
        while ((record = csvReader.readNext()) != null) {
            entitiesList.add(entityFactory.create(record));
        }
        return entitiesList;
    }
}


