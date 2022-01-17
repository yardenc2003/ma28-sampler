package workspace.fileHandlers.configurations;

import lombok.Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
public class PropertiesHandler implements ConfigurationsHandler{
    private Properties properties = new Properties();

    @Override
    public void load(String fileName) throws IOException {
        properties.load(new FileReader("C:\\Users\\yarde\\Documents\\Exercises\\Solutions\\MyGitProjects\\ma28-sampler\\src\\main\\resources\\sampler_configurations.properties"));
    }

    @Override
    public String getField(String fieldName) {
        return properties.getProperty(fieldName);
    }
}
