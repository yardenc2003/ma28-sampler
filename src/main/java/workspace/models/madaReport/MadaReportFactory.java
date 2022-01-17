package workspace.models.madaReport;

import lombok.SneakyThrows;
import workspace.models.EntityFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MadaReportFactory implements EntityFactory {
    private final static SimpleDateFormat dotDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final static SimpleDateFormat slashDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @SneakyThrows
    @Override
    public MadaReport create(String... fields) throws IllegalArgumentException {
        if (fields.length < 12) {
            throw new IllegalArgumentException("Exactly 12 args are required");
        }
        String madaCode = fields[0];
        String idNum = fields[1];
        int idType = Integer.parseInt(fields[2]);
        String firstName = fields[3];
        String lastName = fields[4];
        String city = fields[5];
        String street = fields[6];
        int buildingNumber = Integer.parseInt(fields[7]);
        String barCode = fields[8];
        Date getDate = dotDateFormat.parse(fields[9]);
        Date takeDate = dotDateFormat.parse(fields[10]);
        Date resultDate = slashDateFormat.parse(fields[11]);
        return new MadaReport(madaCode, idNum, idType, firstName, lastName, city, street, buildingNumber, barCode, getDate, takeDate, resultDate);
    }
}