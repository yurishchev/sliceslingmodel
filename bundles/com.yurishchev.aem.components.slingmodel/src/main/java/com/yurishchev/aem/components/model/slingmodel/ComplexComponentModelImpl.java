package com.yurishchev.aem.components.model.slingmodel;

import com.day.cq.wcm.api.Page;
import com.yurishchev.aem.core.AlignmentEnum;
import com.yurishchev.aem.core.ComplexComponentModel;
import com.yurishchev.aem.core.ImageComponentModel;
import com.yurishchev.aem.core.LinkComponentModel;
import com.yurishchev.aem.core.configuration.SampleConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.osgi.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class})
public class ComplexComponentModelImpl implements ComplexComponentModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexComponentModelImpl.class);

    @Inject
    private String text; // simple JCR types (String, Long, Double, Calendar) - mapped via DefaultFieldProcessor

    @Inject
    private boolean valid; // boolean JCR type (value can be string or boolean) - mapped via BooleanFieldProcessor

    @Inject
    @Named("cq:tags")
    private String[] tags; // multi-value JCR properties - mapped via ListFieldProcessor

    @Inject
    @Optional
    private AlignmentEnum alignment; // maps String value to enum - mapped via EnumFieldProcessor

    @Inject
    @Optional
    private ImageModelImpl image; // supports model composition if referred resource is annotated with @SliceResource

    @Inject
    @Optional
    private ImageComponentModel imageViaInterface; // supports model composition via referred resource's interface

    @Inject
    @Optional
    private List<LinkComponentModel> links;

    /**
     * Works only with installed ACS AEM Commons.
     * http://adobe-consulting-services.github.io/acs-aem-commons/features/aem-sling-models-injectors.html
     */
    @Inject
    @Optional
    private ResourceResolver resourceResolver;

    @Inject
    @Optional
    private SlingHttpServletRequest slingRequest;

    @Inject
    private LogService logService; // injected standard (OOB) OSGI service

    @Inject
    private SampleConfiguration configuration; // injected custom OSGI service

    private Resource currentResource;
    private Page currentPage;
    private String postModifiedValue;


    @Inject
    public ComplexComponentModelImpl(Resource resource) {
        this.currentResource = resource;
        this.currentPage = resource.adaptTo(Page.class);
    }

    @PostConstruct
    void init() {
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
    public ImageComponentModel getImage() {
        return image;
    }

    @Override
    public ImageComponentModel getImageViaInterface() {
        return imageViaInterface;
    }

    @Override
    public List<LinkComponentModel> getCustomLinks() {
        return links;
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
        logService.log(LogService.LOG_ERROR, "Logging some ERROR info!");
        return "Successfully logged entry!";
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
}
