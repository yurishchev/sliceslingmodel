package com.yurishchev.aem.components.model.slingmodel;

import com.yurishchev.aem.core.AlignmentEnum;
import com.yurishchev.aem.core.LinkComponentModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class CustomLinkModelImpl extends LinkModelImpl implements LinkComponentModel {

    @Inject
    @Optional
    private AlignmentEnum alignment;

    @Inject
    @Optional
    private String css;


    public AlignmentEnum getAlignment() {
        return alignment;
    }

    public String getCss() {
        return css;
    }

}
