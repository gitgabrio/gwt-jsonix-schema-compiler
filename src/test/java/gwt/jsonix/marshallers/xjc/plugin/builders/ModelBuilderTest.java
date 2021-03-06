/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gwt.jsonix.marshallers.xjc.plugin.builders;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import org.junit.Before;
import org.junit.Test;

import static gwt.jsonix.marshallers.xjc.plugin.TestUtils.getJDefinedClass;
import static org.junit.Assert.assertEquals;

public class ModelBuilderTest {

    private JCodeModel jCodeModel;

    @Before
    public void setup() {
        jCodeModel = new JCodeModel();
    }

    @Test
    public void getJNIRepresentation() throws JClassAlreadyExistsException {
        JDefinedClass testClass = getJDefinedClass(jCodeModel, "net.gwt.jsonix", "TestClass", null);
        String retrieved = ModelBuilder.getJNIRepresentation(testClass);
        assertEquals("Lnet/gwt/jsonix/TestClass", retrieved);
        testClass = getJDefinedClass(jCodeModel, "net.gwt.jsonix", "TestClass", "OuterClass");
        retrieved = ModelBuilder.getJNIRepresentation(testClass);
        assertEquals("Lnet/gwt/jsonix/OuterClass$TestClass", retrieved);
    }
}