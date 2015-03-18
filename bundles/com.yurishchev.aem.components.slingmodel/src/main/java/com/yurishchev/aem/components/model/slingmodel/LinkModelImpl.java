package com.yurishchev.aem.components.model.slingmodel;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class LinkModelImpl {

    @Inject
    protected String title;

    @Inject
    @Optional
    protected String tooltip;

    @Inject
    protected String path;

    @Inject
    @Optional
    @Default(values = "_blank")
    protected String target;


    public String getTitle() {
        return title;
    }

    public String getTooltip() {
        return tooltip;
    }

    public String getPath() {
        return path;
    }

    public String getTarget() {
        return target;
    }
}