package com.yurishchev.aem.components.model.slice;

import com.cognifide.slice.mapper.annotation.JcrProperty;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.yurishchev.aem.core.AlignmentEnum;
import com.yurishchev.aem.core.LinkComponentModel;

@SliceResource
public class CustomLinkModelImpl extends LinkModelImpl
        implements LinkComponentModel {

    @JcrProperty
    private AlignmentEnum alignment;

    @JcrProperty
    private String css;


    public AlignmentEnum getAlignment() {
        return alignment;
    }

    public String getCss() {
        return css;
    }

}
