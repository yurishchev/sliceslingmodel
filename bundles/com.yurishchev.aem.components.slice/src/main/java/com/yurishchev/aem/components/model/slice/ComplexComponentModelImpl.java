package com.yurishchev.aem.components.model.slice;

import com.cognifide.slice.api.annotation.OsgiService;
import com.cognifide.slice.api.model.InitializableModel;
import com.cognifide.slice.api.provider.ModelProvider;
import com.cognifide.slice.cq.qualifier.CurrentPage;
import com.cognifide.slice.mapper.annotation.*;
import com.day.cq.wcm.api.Page;
import com.google.inject.Inject;
import com.yurishchev.aem.core.AlignmentEnum;
import com.yurishchev.aem.core.ComplexComponentModel;
import com.yurishchev.aem.core.ImageComponentModel;
import com.yurishchev.aem.core.LinkComponentModel;
import com.yurishchev.aem.core.configuration.SampleConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.log.LogService;

import java.util.List;

@SliceResource
public class ComplexComponentModelImpl implements ComplexComponentModel, InitializableModel { // post-processed model

    @JcrProperty
    @Unescaped // avoids default HTML escaping (e.g. when a property represents a part of HTML markup)
    private String text; // simple JCR types (String, Long, Double, Calendar) - mapped via DefaultFieldProcessor

    @JcrProperty
    private boolean valid; // boolean JCR type (value can be string or boolean) - mapped via BooleanFieldProcessor

    @JcrProperty(value = "cq:tags")
    private String[] tags; // multi-value JCR properties - mapped via ListFieldProcessor

    @JcrProperty
    private AlignmentEnum alignment; // maps String value to enum - mapped via EnumFieldProcessor

    @JcrProperty
    private ImageModelImpl image; // supports model composition if referred resource is annotated with @SliceResource

    @JcrProperty
    private ImageComponentModel imageViaInterface; // supports model composition via referred resource's interface

    @Children(CustomLinkModelImpl.class) // maps list of models annotated with @SliceResource
    @JcrProperty
    private List<LinkComponentModel> links;

    @Inject
    private ResourceResolver resourceResolver;

    @Inject
    private SlingHttpServletRequest slingRequest;

    @Inject
    @OsgiService
    private LogService logService; // injected standard (OOB) OSGI service

    @Inject
    @OsgiService
    private SampleConfiguration configuration; // injected custom OSGI service

    private Resource currentResource;
    private Page currentPage;
    private String postModifiedValue;

    @Inject
    private ModelProvider modelProvider; // OOB Slice injected objects

    @JcrProperty
    @SliceReference(value = "/content/sliceslingmodel/en/jcr:content/complexComponent/links/linkcomponent")
    private LinkModelImpl referredAbsoluteLink; // maps resource using different (absolute) path than a current resource

    @JcrProperty
    @SliceReference(value = "links/linkcomponent_0")
    private LinkModelImpl referredRelativeLink; // maps resource using different (relative) path than a current resource


    @Inject
    public ComplexComponentModelImpl(@CurrentPage final Page currentPage, Resource resource) { // injected Sling and CQ objects
        this.currentResource = resource;
        this.currentPage = currentPage;
    }

    @Override
    public void afterCreated() { // post-processing
        if (currentResource != null) {
            postModifiedValue = currentResource.getName() + " - post modified!"; // use already mapped data
        }
    }

    @Override
    public String getJCRString() {
        return text;
    }

    @Override
    public Boolean getJCRBoolean() {
        return valid;
    }

    @Override
    public String[] getJCRMultiProperties() {
        return tags;
    }

    @Override
    public AlignmentEnum getEnumeratedType() {
        return alignment;
    }

    @Override
    public List<LinkComponentModel> getCustomLinks() {
        return links;
    }

    @Override
    public ImageComponentModel getImage() {
        return image;
    }

    @Override
    public ImageComponentModel getImageViaInterface() {
        return imageViaInterface;
    }

    @Override
    public String getCurrentResourceName() {
        return currentResource != null ? currentResource.getName() : null;
    }

    @Override
    public String getCurrentPageName() {
        return currentPage != null ? currentPage.getName() : null;
    }

    @Override
    public SlingHttpServletRequest getSlingRequest() {
        return slingRequest;
    }

    @Override
    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    @Override
    public String getPostModifiedValue() {
        return postModifiedValue;
    }

    @Override
    public String getOSGICustomServiceStatus() {
        return configuration != null ? configuration.getInstanceName() : null;
    }

    @Override
    public String getOSGILogServiceStatus() {
        if (logService != null) {
            logService.log(LogService.LOG_ERROR, "Logging some ERROR info!");
            return "Successfully logged entry!";
        }
        return null;
    }

    public LinkModelImpl getReferredAbsoluteLink() {
        return referredAbsoluteLink;
    }

    public LinkModelImpl getReferredRelativeLink() {
        return referredRelativeLink;
    }
}