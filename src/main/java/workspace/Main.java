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
        ConfigurationsHandler configurationsHandler = new PropertiesHandler();
        configurationsHandler.load(configurationsFileName);

        int maxRecords = Integer.parseInt(configurationsHandler.getField("maxRecords"));
        String madaReportsSrc = configurationsHandler.getField("madaReportsSrc");
        String madaReportsDst = configurationsHandler.getField("madaReportsDst");

        SamplerETLQueries samplerETLQueries = new SamplerETLQueriesManager();
        List<Entity> madaReportsList = samplerETLQueries.extractMadaReports(madaReportsSrc);
        samplerETLQueries.loadMadaReports(maxRecords, madaReportsDst, madaReportsList);
    }
}