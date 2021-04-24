package info.startupbuilder.aws.cert.backend.dynamodb.app.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import info.startupbuilder.aws.cert.backend.dynamodb.app.repository.QuestionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Getter
@Configuration
@EnableDynamoDBRepositories(basePackageClasses = QuestionRepository.class)
public class DynamoDBConfig {

    private final AWSProperties.Credentials credentials;
    private final AWSProperties.DynamoDB dynamoDB;

    @Bean
    AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDB.endpoint, "us-east-1"))
                .withCredentials(amazonCredentials())
                .build();
    }

    @Bean
    AWSCredentialsProvider amazonCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(credentials.accessKey, credentials.secretKey));
    }
}
