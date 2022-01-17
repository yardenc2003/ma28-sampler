package workspace.fileHandlers.writers;

import workspace.extensions.FileNameGenerator;
import workspace.models.Entity;

import java.io.IOException;
import java.util.List;

public abstract class FileSerializer {
    protected int maxRecords;

    public FileSerializer(int maxRecords) {
        this.maxRecords = maxRecords;
    }

    protected abstract void serializeSingleFile(String fileName, List<Entity> entitiesList) throws IOException;

    public void serializeEntities(String fileName, List<Entity> entitiesList) throws IOException {
        int fileNo = 1;
        String generatedFileName = FileNameGenerator.generateFileName(fileName);
        for (int i = 0; i < entitiesList.size(); i += this.maxRecords) {
            this.serializeSingleFile(String.format(generatedFileName, fileNo), entitiesList.subList(i,
                    Math.min(entitiesList.size(), i + this.maxRecords)));
            fileNo++;
        }
    }
}
