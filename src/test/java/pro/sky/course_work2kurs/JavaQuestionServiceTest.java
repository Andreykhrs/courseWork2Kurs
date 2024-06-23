package pro.sky.course_work2kurs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.course_work2kurs.model.Question;
import pro.sky.course_work2kurs.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void addTest() {
        Question expected = new Question("Что такое логический тип переменных?",
                "Тип, в котором хранится информация в формате true/false(т.е. истина/ложь)");
        Question actual = javaQuestionService.add("Что такое логический тип переменных?",
                "Тип, в котором хранится информация в формате true/false(т.е. истина/ложь)");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void removeTest() {
        Question expected = new Question("Что такое логический тип переменных?",
                "Тип, в котором хранится информация в формате true/false(т.е. истина/ложь)");
        Question actual = javaQuestionService.remove("Что такое логический тип переменных?",
                "Тип, в котором хранится информация в формате true/false(т.е. истина/ложь)");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllTest() {
        Question question1 = new Question("Как называется контейнер для хранения разных данных?",
                "Переменная");
        Question question2 = new Question("Что такое Итерация?",
                "Один повтор какого-то действия.");
        Question question3 = new Question("Назовите три вида циклов.",
                "For, while и do-while.");

        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);

        javaQuestionService.add("Как называется контейнер для хранения разных данных?",
                "Переменная");
        javaQuestionService.add("Что такое Итерация?",
                "Один повтор какого-то действия.");
        javaQuestionService.add("Назовите три вида циклов.",
                "For, while и do-while.");

        Set<Question> actual = new HashSet<>(javaQuestionService.getAll());
        assertIterableEquals(expected, actual);

    }
}
