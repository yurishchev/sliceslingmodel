package com.yurishchev.aem.components.model.slice;

import com.yurishchev.aem.core.ComplexComponentModel;
import org.apache.sling.api.resource.Resource;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ComplexComponentModelTest {

    @Test
    public void getTextTest() {
        Resource mockedResource = mock(Resource.class);
        ComplexComponentModel bean = new ComplexComponentModelImpl(null, mockedResource);
        Whitebox.setInternalState(bean, "text", "Some dummy test");
        assertEquals("Some dummy test", bean.getJCRString());
    }
}