package mz.org.fgh.mentoring.dto.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import lombok.AllArgsConstructor;
import lombok.Data;
import mz.org.fgh.mentoring.base.BaseEntityDTO;
import mz.org.fgh.mentoring.dto.question.SectionDTO;
import mz.org.fgh.mentoring.entity.form.FormSection;
import mz.org.fgh.mentoring.entity.formQuestion.FormSectionQuestion;
import mz.org.fgh.mentoring.util.Utilities;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FormSectionDTO extends BaseEntityDTO {

    private Long formId;

    private String formUuid;

    @NotNull(message = "Section cannot be null")
    private SectionDTO section;

    private String sectionUuid;

    @JsonProperty("in_use")
    private boolean inUse;

    private Integer sequence;

    @JsonProperty(value = "formSectionQuestions")
    private List<FormSectionQuestionDTO> formSectionQuestions;

    @Creator
    public FormSectionDTO() {}

    public FormSectionDTO(FormSection formSection) {
        super(formSection);
        this.formId = formSection.getForm().getId();
        this.formUuid = formSection.getForm().getUuid();
        this.section = new SectionDTO(formSection.getSection());
        this.sectionUuid = formSection.getSection().getUuid();
        this.sequence = formSection.getSequence();
        if (Utilities.listHasElements(formSection.getFormSectionQuestions())) {
            this.formSectionQuestions = new ArrayList<>();
            for (FormSectionQuestion fsq : formSection.getFormSectionQuestions()) {
                this.formSectionQuestions.add(new FormSectionQuestionDTO(fsq));
            }
        }
    }
    public FormSectionDTO(FormSection formSection, boolean inUse) {
        super(formSection);
        this.formId = formSection.getForm().getId();
        this.formUuid = formSection.getForm().getUuid();
        this.section = new SectionDTO(formSection.getSection());
        this.sectionUuid = formSection.getSection().getUuid();
        this.sequence = formSection.getSequence();
        this.setInUse(inUse);
        if (Utilities.listHasElements(formSection.getFormSectionQuestions())) {
            this.formSectionQuestions = new ArrayList<>();
            for (FormSectionQuestion fsq : formSection.getFormSectionQuestions()) {
                this.formSectionQuestions.add(new FormSectionQuestionDTO(fsq));
            }
        }
    }
}
