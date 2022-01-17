package workspace.fileHandlers.readers.parsers.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import workspace.fileHandlers.readers.parsers.FileParser;
import workspace.models.EntityFactory;
import workspace.models.Entity;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements FileParser {

    @Override
    public List<Entity> extractEntities(EntityFactory entityFactory, String fileName) throws IOException, CsvValidationException {
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


