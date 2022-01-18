package workspace.models.labTest;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import workspace.models.Entity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class LabTest extends Entity {
    private String idNum;
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
}
