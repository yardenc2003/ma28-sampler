package workspace.models.madaReport;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import workspace.models.Entity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class MadaReport extends Entity {
    private String madaCode;
    private String idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNumber;
    private String barCode;
    private Date getDate;
    private Date takeDate;
    private Date resultDate;
}
