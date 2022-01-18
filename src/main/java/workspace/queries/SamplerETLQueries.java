package workspace.queries;

import workspace.models.Entity;

import java.io.IOException;
import java.util.List;

public interface SamplerETLQueries {
    List<Entity> extractMadaReports(String fileName) throws IOException;
    void loadMadaReports(int maxRecords, String fileName, List<Entity>entitiesList) throws IOException;
    List<Entity> extractLabTests(String fileName) throws IOException;
    void loadLabTests(int maxRecords, String fileName, List<Entity>entitiesList) throws IOException;
    void addHealthServiceInfo(List<Entity> labTestList);
}

