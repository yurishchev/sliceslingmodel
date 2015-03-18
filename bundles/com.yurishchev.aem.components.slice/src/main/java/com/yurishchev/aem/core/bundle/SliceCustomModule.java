package com.yurishchev.aem.core.bundle;

import com.cognifide.slice.api.scope.ContextScoped;
import com.cognifide.slice.mapper.SliceReferencePathResolverFactory;
import com.cognifide.slice.mapper.api.Mapper;
import com.cognifide.slice.mapper.api.SliceReferencePathResolver;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;

public class SliceCustomModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @ContextScoped
    public SliceReferencePathResolver getSliceReferencePathResolver(Injector injector) {
        SliceReferencePathResolver resolver = SliceReferencePathResolverFactory.createResolver(injector);
        //resolver.addPlaceholder("language", Language.class);
        return resolver;
    }
}
