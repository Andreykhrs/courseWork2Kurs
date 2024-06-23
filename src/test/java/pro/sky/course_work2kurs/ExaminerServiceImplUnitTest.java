package pro.sky.course_work2kurs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.course_work2kurs.exception.RequestLimitExceededException;
import pro.sky.course_work2kurs.exception.RequiredNumberOfQuestionsIsMissingException;
import pro.sky.course_work2kurs.service.ExaminerServiceImpl;
import pro.sky.course_work2kurs.service.JavaQuestionService;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExaminerServiceImplUnitTest {
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(new JavaQuestionService());

    @Test
    void getQuestions_RequestLimitExceededException_Negative_test() {
        assertThatExceptionOfType(RequestLimitExceededException.class)
                .isThrownBy(() -> examinerService.getQuestions(6));
    }

    @Test
    void getQuestions_RequiredNumberOfQuestionsIsMissingException_Negative_test() {
        assertThatExceptionOfType(RequiredNumberOfQuestionsIsMissingException.class)
                .isThrownBy(() -> examinerService.getQuestions(5));
    }

}
