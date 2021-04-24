package info.startupbuilder.aws.cert.backend.dynamodb.app.presentation;


import info.startupbuilder.aws.cert.backend.dynamodb.app.core.Question;
import info.startupbuilder.aws.cert.backend.dynamodb.app.core.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService service;

    @GetMapping
    public List<Question> listAll() {
        return service.listAllQuestions();
    }

}
