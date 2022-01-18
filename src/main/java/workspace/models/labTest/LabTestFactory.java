package workspace.models.labTest;

import lombok.SneakyThrows;
import workspace.extensions.DateGenerator;
import workspace.models.EntityFactory;

import java.util.Date;

public class LabTestFactory implements EntityFactory {
    @SneakyThrows
    @Override
    public LabTest create(String... fields) throws IllegalArgumentException {
        if (fields.length < 11) {
            throw new IllegalArgumentException("Exactly 11 args are required");
        }
        String idNum = fields[0];
        int idType = Integer.parseInt(fields[1]);
        String firstName = fields[2];
        String lastName = fields[3];
        Date resultDate = DateGenerator.generateSlashDate(fields[4]);
        Date birthDate = DateGenerator.generateSlashDate(fields[5]);
        String labCode = fields[6];
        String stickerNumber = fields[7];
        int resultTestCorona = Integer.parseInt(fields[8]);
        String variant = fields[9];
        String testType = fields[10];
        return new LabTest(idNum, idType, firstName, lastName, resultDate, birthDate, labCode, stickerNumber,
                resultTestCorona, variant, testType);
    }
}