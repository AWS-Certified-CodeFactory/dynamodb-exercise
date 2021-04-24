package info.startupbuilder.aws.cert.backend.dynamodb.app.repository;

import info.startupbuilder.aws.cert.backend.dynamodb.app.core.Question;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface QuestionRepository extends CrudRepository<Question, String> {

    List<Question> findAll();
}
