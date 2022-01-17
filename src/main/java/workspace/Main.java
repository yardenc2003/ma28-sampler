package workspace;

import com.opencsv.exceptions.CsvValidationException;
import workspace.fileHandlers.configurations.ConfigurationsHandler;
import workspace.fileHandlers.configurations.PropertiesHandler;
import workspace.fileHandlers.readers.parsers.csv.CSVFileParser;
import workspace.models.Entity;
import workspace.models.madaReport.MadaReportFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String configurationsFileName = "C:\\Users\\yarde\\Documents\\Exercises\\Solutions\\MyGitProjects\\ma28-sampler\\src\\main\\resources\\sampler_configurations.properties";

    public static void main(String[] args) throws CsvValidationException, IOException {
        List<Entity> madaReportList = new CSVFileParser().extractEntities(new MadaReportFactory(), "C:\\Users\\yarde\\Documents\\Exercises\\Solutions\\MyGitProjects\\ma28-sampler\\src\\main\\resources\\MadaReports.csv");
        Entity e = madaReportList.get(0);
        System.out.println(e.toString());
        ConfigurationsHandler configurationsHandler = new PropertiesHandler();
        configurationsHandler.load(configurationsFileName);
        System.out.println(configurationsHandler.getField("madaReportsSrc"));
    }
}
