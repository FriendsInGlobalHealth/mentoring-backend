package mz.org.fgh.mentoring.entity.answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mz.org.fgh.mentoring.base.BaseEntity;
import mz.org.fgh.mentoring.entity.form.Form;
import mz.org.fgh.mentoring.entity.indicator.Indicator;
import mz.org.fgh.mentoring.entity.mentorship.MentorShip;
import mz.org.fgh.mentoring.entity.question.Question;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "answer")
@Table(name = "ANSWERS")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORM_ID", nullable = false)
   private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENTORSHIP_ID")
    private MentorShip mentorship;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDICATOR_ID")
    private Indicator indicator;

}
