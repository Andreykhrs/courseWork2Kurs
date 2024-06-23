package pro.sky.course_work2kurs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2kurs.model.Question;
import pro.sky.course_work2kurs.service.ExaminerServiceImpl;
import pro.sky.course_work2kurs.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> questionsSet = Set.of(
            new Question("Как называется контейнер для хранения разных данных?",
                    "Переменная"),
            new Question("Что такое Итерация?",
                    "Один повтор какого-то действия."),
            new Question("Назовите три вида циклов.",
                    "For, while и do-while.")
    );

    @BeforeEach
    public void beforeEach() {
        when(javaQuestionService.getAll()).thenReturn(questionsSet);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                (0),
                (1),
                (2)
        );
    }

    @Test
    void getQuestionsTest() {
        Set<Question> expected = new HashSet<>();
        Question question1 = new Question("Как называется контейнер для хранения разных данных?",
                "Переменная");
        Question question2 = new Question("Что такое Итерация?",
                "Один повтор какого-то действия.");
        Question question3 = new Question("Назовите три вида циклов.",
                "For, while и do-while.");
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);

        Set<Question> actual = new HashSet<>(examinerService.getQuestions(3));

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
