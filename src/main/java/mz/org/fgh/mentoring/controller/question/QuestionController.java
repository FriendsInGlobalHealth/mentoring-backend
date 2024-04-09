package mz.org.fgh.mentoring.controller.question;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import mz.org.fgh.mentoring.api.RESTAPIMapping;
import mz.org.fgh.mentoring.base.BaseController;
import mz.org.fgh.mentoring.dto.question.QuestionDTO;
import mz.org.fgh.mentoring.entity.question.Question;
import mz.org.fgh.mentoring.service.question.QuestionService;

import java.util.List;
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller(RESTAPIMapping.QUESTION)
public class QuestionController extends BaseController {

    @Inject
    private QuestionService questionService;

    public QuestionController() {
    }

    @Get("/{formCode}")
    public List<Question> getByFormCode(@PathVariable String formCode) {
        return questionService.getQuestionsByFormCode(formCode);
    }

    @Operation(summary = "Return a list off all Questions")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Tag(name = "Question")
    @Get("/getAll")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
