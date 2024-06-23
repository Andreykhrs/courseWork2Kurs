package pro.sky.course_work2kurs.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.course_work2kurs.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        add("Как называется контейнер для хранения разных данных?",
                "Переменная");
        add("Что значит объявление переменной?",
                "Это создание переменной (выделение ячейки памяти, присвоение ей имени).");
        add("Как называется процесс присваивание какого-то значения переменной?",
                "Инициализация");
        add("Как называется стандартная функция, которая помогает нам вывести результат " +
                        "нашего кода в консоль и посмотреть, что получилось",
                "System.out.println ();");
        add("Чтобы узнать остаток от деления, нужно?",
                "Большее число, поделить на меньшее");
        add("Какой символ используется в операции остаток от деления?",
                "%");
        add("Конструкция кода, которая повторяет одно и то же действие " +
                        "несколько (столько, сколько нам потребуется) раз, называется?",
                "Цикл");
        add("Что такое Итерация?",
                "Один повтор какого-то действия.");
        add("Назовите три вида циклов.", "For, while и do-while.");
        add("Что такое метод?",
                "Код, который решает определенную задачу и может использоваться много раз в разных местах");

    }

    @Override
    public Question add(String question, String answer) {
        Question questionModel = new Question(question, answer);
        questions.add(questionModel);
        return questionModel;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionModel = new Question(question, answer);
        questions.remove(questionModel);
        return questionModel;
    }

//    @Override
//    public Question add(Question question) {
//        Question questionModel = new Question(question.getQuestion(), question.getAnswer());
//        questions.add(questionModel);
//        return questionModel;
//    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public int getRandomQuestion() {
        return new Random().nextInt(questions.size());
    }
}
