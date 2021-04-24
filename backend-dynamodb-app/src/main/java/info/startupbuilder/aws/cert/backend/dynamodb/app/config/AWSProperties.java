package info.startupbuilder.aws.cert.backend.dynamodb.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

public class AWSProperties {

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "aws.credentials")
    public static class Credentials {
        String accessKey, secretKey;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "aws.dynamodb")
    public static class DynamoDB {
        String endpoint;
    }
}
