package com.yurishchev.aem.components.model.slice;

import com.cognifide.slice.mapper.annotation.JcrProperty;
import com.cognifide.slice.mapper.annotation.MappingStrategy;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.cognifide.slice.mapper.annotation.Unescaped;
import com.yurishchev.aem.core.ImageComponentModel;

@SliceResource(MappingStrategy.ANNOTATED) // ANNOTATED mapping strategy
public class ImageModelImpl implements ImageComponentModel {

    @JcrProperty
    private String fileReference;

    @JcrProperty
    @Unescaped
    private String altText;


    public String getFileReference() {
        return fileReference;
    }

    public String getAltText() {
        return altText;
    }
}