package workspace.transformation.labTest;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.models.PersonInsured;
import lombok.SneakyThrows;
import workspace.models.Entity;
import workspace.models.labTest.LabTest;
import workspace.transformation.Transformer;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

public class HealthCareTransformation extends Transformer {
    private final HealthCareInfoProvider healthCareInfoProvider= new HealthCareInfoProvider();

    @SneakyThrows
    @Override
    public void transformSingleEntity(Entity entity) {
        LabTest labTest = (LabTest) entity;
        PersonInsured personInsured = this.healthCareInfoProvider.fetchInfo(labTest.getIdNum(), labTest.getIdType());
        labTest.setJoinDate(Date.from(personInsured.getJoinDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        labTest.setHealthCareId(personInsured.getHealthCareId());
        labTest.setHealthCareName(personInsured.getHealthCareName());
    }

    @Override
    public void transformEntities(List<Entity> entitiesList) {
        for(Entity entity:entitiesList){
            this.transformSingleEntity(entity);
        }
    }
}
