package com.yurishchev.aem.core.bundle;

import com.cognifide.slice.api.injector.InjectorRunner;
import com.cognifide.slice.commons.SliceModulesFactory;
import com.cognifide.slice.core.internal.module.OsgiToGuiceAutoBindModule;
import com.cognifide.slice.cq.module.CQModulesFactory;
import com.google.inject.Module;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class Activator implements BundleActivator {

    private static final String BUNDLE_NAME_FILTER = "com.yurishchev.aem.sliceslingmodel-components-slice.*";

    private static final String BASE_PACKAGE = "com.yurishchev.aem.components.model.slice";

    private static final String INJECTOR_NAME = "sliceslingmodel";

    private static final Logger logger = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        final InjectorRunner injectorRunner =
                new InjectorRunner(bundleContext, INJECTOR_NAME, BUNDLE_NAME_FILTER, BASE_PACKAGE);
        logger.debug("Configuring Injector - {}, for bundles - {}",
                INJECTOR_NAME, BUNDLE_NAME_FILTER);
        final List<Module> sliceModules = SliceModulesFactory.createModules(bundleContext);
        final List<Module> cqModules = CQModulesFactory.createModules();
        final List<Module> customModules = createCustomModules();

        injectorRunner.installModules(sliceModules);
        injectorRunner.installModules(cqModules);
        injectorRunner.installModule(new OsgiToGuiceAutoBindModule(bundleContext, BUNDLE_NAME_FILTER, BASE_PACKAGE));
        injectorRunner.installModules(customModules);

        injectorRunner.start();
        logger.debug("Started Slice injector runner");
    }

    @Override
    public void stop(BundleContext context) throws Exception {

    }

    private List<Module> createCustomModules() {
        List<Module> result = new ArrayList<Module>();
        result.add(new SliceCustomModule());
        return result;
    }
}
