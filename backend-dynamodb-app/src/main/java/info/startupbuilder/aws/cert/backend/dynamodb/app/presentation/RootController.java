package info.startupbuilder.aws.cert.backend.dynamodb.app.presentation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

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
}
