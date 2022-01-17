package workspace.fileHandlers.configurations;

import java.io.IOException;

public interface ConfigurationsHandler {
    void load(String fileName) throws IOException;
    String getField(String fieldName);
}