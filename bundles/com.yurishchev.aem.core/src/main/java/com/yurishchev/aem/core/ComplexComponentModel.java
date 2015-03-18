package com.yurishchev.aem.core;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.List;

public interface ComplexComponentModel {

    String getJCRString();

    Boolean getJCRBoolean();

    String[] getJCRMultiProperties();

    AlignmentEnum getEnumeratedType();

    List<LinkComponentModel> getCustomLinks();

    ImageComponentModel getImage();

    ImageComponentModel getImageViaInterface();

    String getCurrentResourceName();

    String getCurrentPageName();

    SlingHttpServletRequest getSlingRequest();

    ResourceResolver getResourceResolver();

    String getPostModifiedValue();

    String getOSGILogServiceStatus();

    String getOSGICustomServiceStatus();
}
