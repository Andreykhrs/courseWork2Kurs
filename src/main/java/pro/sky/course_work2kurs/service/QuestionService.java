package pro.sky.course_work2kurs.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2kurs.model.Question;

import java.util.Collection;

@Service
public interface QuestionService {

    public Question add(String question, String answer);

    public Question remove(String question, String answer);

//    public Question add(Question question);

    public Collection<Question> getAll();

    public int getRandomQuestion();


}
