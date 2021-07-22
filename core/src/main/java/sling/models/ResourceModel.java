package sling.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class ResourceModel {

    @Inject
    private String firstName;
    private String value;

    @PostConstruct
    public void activate() {
        value = "Hi! " + firstName;
    }

    public String getValue() {
        return value;
    }
}