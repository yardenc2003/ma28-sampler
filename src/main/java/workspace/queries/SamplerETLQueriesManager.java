
package workspace.queries;

import workspace.fileHandlers.readers.parsers.FileParser;
import workspace.fileHandlers.readers.parsers.csv.CSVFileParser;
import workspace.fileHandlers.writers.FileSerializer;
import workspace.fileHandlers.writers.json.JsonFileSerializer;
import workspace.models.Entity;
import workspace.models.EntityFactory;
import workspace.models.labTest.LabTestFactory;
import workspace.models.madaReport.MadaReportFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SamplerETLQueriesManager implements SamplerETLQueries {
    private final Map<String, FileParser> fileParsersMap = new HashMap<>();
    private final Map<String, FileSerializer> fileSerializersMap = new HashMap<>();
    private final Map<String, EntityFactory> entityFactoriesMap = new HashMap<>();

    public SamplerETLQueriesManager() {
        this.fileParsersMap.put("csv", new CSVFileParser());
        this.fileSerializersMap.put("json", new JsonFileSerializer());
        this.entityFactoriesMap.put("madaReport", new MadaReportFactory());
        this.entityFactoriesMap.put("labTest", new LabTestFactory());
    }

    public List<Entity> extractEntities(String fileType, String entityType, String fileName) throws IOException {
        return this.fileParsersMap.get(fileType).parseEntities(fileName, this.entityFactoriesMap.get(entityType));
    }

    public void loadEntities(int maxRecords, String fileType, String fileName, List<Entity> entitiesList) throws IOException {
        this.fileSerializersMap.get(fileType).serializeEntities(maxRecords, fileName, entitiesList);
    }

    @Override
    public List<Entity> extractMadaReports(String fileName) throws IOException {
        return this.extractEntities("csv", "madaReport", fileName);
    }

    @Override
    public void loadMadaReports(int maxRecords, String fileName, List<Entity> entitiesList) throws IOException {
        this.loadEntities(maxRecords, "json", fileName, entitiesList);
    }

    @Override
    public List<Entity> extractLabTests(String fileName) throws IOException {
        return this.extractEntities("csv", "labTest", fileName);

    }

    @Override
    public void loadLabTests(int maxRecords, String fileName, List<Entity> entitiesList) throws IOException {
    }
}







