package pro.sky.course_work2kurs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequiredNumberOfQuestionsIsMissingException extends RuntimeException {
}
