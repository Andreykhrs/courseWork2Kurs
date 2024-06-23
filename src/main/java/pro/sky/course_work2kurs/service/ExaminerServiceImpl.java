package pro.sky.course_work2kurs.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2kurs.exception.RequestLimitExceededException;
import pro.sky.course_work2kurs.exception.RequiredNumberOfQuestionsIsMissingException;
import pro.sky.course_work2kurs.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int maxSet = 5;
        Set<Question> questionSet = new HashSet<>(maxSet);
        List<Question> elements = new ArrayList<>(javaQuestionService.getAll());
        if (amount <= maxSet) {
            if (javaQuestionService.getAll().size() >= amount) {
                while (questionSet.size() < amount) {
                    questionSet.add(elements.get(javaQuestionService.getRandomQuestion()));
                }
            } else {
                throw new RequiredNumberOfQuestionsIsMissingException();
            }
        } else {
            throw new RequestLimitExceededException();
        }
        return Collections.unmodifiableCollection(questionSet);
    }
}
