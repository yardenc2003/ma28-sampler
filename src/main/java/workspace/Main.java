package workspace;

import workspace.fileHandlers.configurations.ConfigurationsHandler;
import workspace.fileHandlers.configurations.PropertiesHandler;
import workspace.models.Entity;
import workspace.queries.SamplerETLQueries;
import workspace.queries.SamplerETLQueriesManager;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String configurationsFileName = "C:\\Users\\yarde\\Documents\\Exercises\\Solutions\\MyGitProjects\\ma28-sampler\\src\\main\\resources\\sampler_configurations.properties";

    public static void main(String[] args) throws IOException {
        // configurations-handler initialization
        ConfigurationsHandler configurationsHandler = new PropertiesHandler();
        configurationsHandler.load(configurationsFileName);

        // retrieve configuration field
        int maxRecords = Integer.parseInt(configurationsHandler.getField("maxRecords"));

        // sampler-etl-queries-manager initialization
        SamplerETLQueries samplerETLQueries = new SamplerETLQueriesManager();

        // part A testing (MadaReport)
        String madaReportsSrc = configurationsHandler.getField("madaReportsSrc");
        String madaReportsDst = configurationsHandler.getField("madaReportsDst");
        List<Entity> madaReportsList = samplerETLQueries.extractMadaReports(madaReportsSrc);
        samplerETLQueries.loadMadaReports(maxRecords, madaReportsDst, madaReportsList);

        // part B testing (LabTest)
        String labTestsSrc = configurationsHandler.getField("labTestsSrc");
        String labTestsDst = configurationsHandler.getField("labTestsDst");
        List<Entity> labTestsList = samplerETLQueries.extractLabTests(labTestsSrc);
        samplerETLQueries.addHealthServiceInfo(labTestsList);
        samplerETLQueries.loadLabTests(maxRecords, labTestsDst, labTestsList);
    }
}