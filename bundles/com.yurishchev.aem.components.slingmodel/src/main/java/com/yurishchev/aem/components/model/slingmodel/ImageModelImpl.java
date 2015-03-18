package com.yurishchev.aem.components.model.slingmodel;

import com.yurishchev.aem.core.ImageComponentModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class ImageModelImpl implements ImageComponentModel {

    @Inject
    private String fileReference;

    @Inject
    private String altText;


    public String getFileReference() {
        return fileReference;
    }

    public String getAltText() {
        return altText;
    }
}