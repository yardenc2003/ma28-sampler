package workspace.fileHandlers.writers.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import workspace.fileHandlers.writers.FileSerializer;
import workspace.models.Entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLFileSerializer extends FileSerializer {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    protected void serializeSingleFile(String fileName, List<Entity> entitiesList) throws IOException {
        this.xmlMapper.writeValue(new File(fileName), entitiesList);
    }
}
