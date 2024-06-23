package pro.sky.course_work2kurs.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2kurs.model.Question;

import java.util.Collection;

@Service
public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);

}
