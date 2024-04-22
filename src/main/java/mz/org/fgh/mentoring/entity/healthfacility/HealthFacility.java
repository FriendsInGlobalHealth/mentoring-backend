package mz.org.fgh.mentoring.entity.healthfacility;

import io.micronaut.core.annotation.Creator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mz.org.fgh.mentoring.base.BaseEntity;
import mz.org.fgh.mentoring.dto.healthFacility.HealthFacilityDTO;
import mz.org.fgh.mentoring.entity.location.District;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "HealthFacility")
@Table(name = "health_facilities")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
public class HealthFacility extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISTRICT_ID", nullable = false)
    private District district;

    @NotEmpty
    @Column(name = "HEALTH_FACILITY", nullable = false, length = 80)
    private String healthFacility;

    @Creator
    public HealthFacility(){}
    public HealthFacility(HealthFacilityDTO healthFacilityDTO) {
        super(healthFacilityDTO);
        this.setDistrict(new District(healthFacilityDTO.getDistrictDTO()));
        this.setHealthFacility(healthFacilityDTO.getHealthFacility());
    }

    @Override
    public String toString() {
        return "HealthFacility{" +
                "district=" + district +
                ", healthFacility='" + healthFacility + '\'' +
                '}';
    }
}
