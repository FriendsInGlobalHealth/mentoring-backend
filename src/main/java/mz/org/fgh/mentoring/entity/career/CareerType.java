package mz.org.fgh.mentoring.entity.career;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mz.org.fgh.mentoring.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CAREER_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class CareerType extends BaseEntity {

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "code", nullable = false)
    private  String code;
}
