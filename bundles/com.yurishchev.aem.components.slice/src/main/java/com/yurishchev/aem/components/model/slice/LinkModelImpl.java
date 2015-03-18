package com.yurishchev.aem.components.model.slice;

import com.cognifide.slice.mapper.annotation.MappingStrategy;
import com.cognifide.slice.mapper.annotation.SliceResource;

@SliceResource(MappingStrategy.ALL) // ALL mapping strategy
public class LinkModelImpl {

    protected String title;

    protected String tooltip;

    protected String path;

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