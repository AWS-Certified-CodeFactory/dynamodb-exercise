package info.startupbuilder.aws.cert.backend.dynamodb.app.presentation;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class RootController {

    private final AmazonDynamoDB dynamoDB;

    @Getter
    @Setter
    public static class RootResource extends RepresentationModel<RootResource> {

        String status;
    }

    @GetMapping
    public RootResource home() {
        RootResource rootResource = new RootResource();
        rootResource.setStatus("OK");
        rootResource.add(Link.of("https://localhost:8080"));

        return rootResource;
    }

    @PostMapping
    public void setup() {
        var createTable = new CreateTableRequest("Question", Arrays.asList(
                new KeySchemaElement("id", KeyType.HASH),
                new KeySchemaElement("value", KeyType.RANGE)
        ));
        createTable.setAttributeDefinitions(Arrays.asList(
                new AttributeDefinition("id", ScalarAttributeType.S),
                new AttributeDefinition("value", ScalarAttributeType.S)
        ));
        createTable.setProvisionedThroughput(new ProvisionedThroughput(10L, 10L));


        dynamoDB.createTable(createTable);
    }
}
