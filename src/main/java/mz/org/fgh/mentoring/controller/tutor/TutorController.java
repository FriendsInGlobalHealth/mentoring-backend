package mz.org.fgh.mentoring.controller.tutor;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import mz.org.fgh.mentoring.api.RestAPIResponse;
import mz.org.fgh.mentoring.entity.tutor.Tutor;
import mz.org.fgh.mentoring.service.tutor.TutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/tutors")
public class TutorController {

    TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    public static final Logger LOG = LoggerFactory.getLogger(TutorController.class);

    @Get
    public List<Tutor> getAll() {
        return tutorService.findAll();
    }

    @Post(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<RestAPIResponse> create (@Body Tutor tutor) {


        LOG.debug("Created tutor {}", new Tutor());

        return HttpResponse.ok().body(new Tutor());
    }
}
