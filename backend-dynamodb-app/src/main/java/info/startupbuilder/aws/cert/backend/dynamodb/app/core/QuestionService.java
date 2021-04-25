package info.startupbuilder.aws.cert.backend.dynamodb.app.core;

import info.startupbuilder.aws.cert.backend.dynamodb.app.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository repository;

    public Question addQuestion() {
        return repository.save(Question.builder()
                .value("Test" + LocalDateTime.now())
                .build());
    }

    public List<Question> listAllQuestions() {
        return repository.findAll();
    }
}
