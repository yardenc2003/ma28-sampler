package workspace.models.labTest;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import workspace.models.Entity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class LabTest extends Entity {
    private int idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private Date resultDate;
    private Date birthDate;
    private String labCode;
    private String stickerNumber;
    private int resultTestCorona;
    private String variant;
    private String testType;
    private Date joinDate;
    private int healthCareId;
    private String healthCareName;

    public LabTest(int idNum, int idType, String firstName, String lastName, Date resultDate, Date birthDate,
                   String labCode, String stickerNumber, int resultTestCorona, String variant, String testType){
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
    }
}

