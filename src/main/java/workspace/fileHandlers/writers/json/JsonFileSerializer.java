package workspace.fileHandlers.writers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.fileHandlers.writers.FileSerializer;
import workspace.models.Entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileSerializer extends FileSerializer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonFileSerializer(int maxRecords) {
        super(maxRecords);
    }

    @Override
    protected void serializeSingleFile(String fileName, List<Entity> entitiesList) throws IOException {
        System.out.println(entitiesList.size());
        this.objectMapper.writeValue(new File(fileName), entitiesList);
    }
}
