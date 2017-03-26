/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResponseModelTest {

    private Map<String, String> keys;
    private List<ValueNode<String>> values;

    @Before
    public void setup() {
        this.keys = new HashMap<>();
        this.keys.put("k1", "value1");
        this.keys.put("k2", "value2");

        this.values = new ArrayList<ValueNode<String>>();
        ValueNode<String> value1 = new ValueNode<String>("48403", "BE0101N1", "Population");
        values.add(value1);
        ValueNode<String> value2 = new ValueNode<String>("1007", "BE0101N2", "Population growth");
        values.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        ResponseModel model = new ResponseModel();

        assertNotNull(model);
    }

    @Test
    public void createWithOverloadedConstructor() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertNotNull(model);
        assertEquals(this.keys, model.getKeys());
        assertEquals(this.values, model.getValues());
    }

    @Test
    public void getKeys() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(this.keys, model.getKeys());
    }

    @Test
    public void setKeys() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(this.keys, model.getKeys());
    }

    @Test
    public void getValues() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(this.values, model.getValues());
    }

    @Test
    public void setValues() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(this.values, model.getValues());
    }

    @Test
    public void getValue() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals("48403", model.getValue("BE0101N1").getValue());
    }

    @Test
    public void getValueNullInput() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(null, model.getValue(null));
    }

    @Test
    public void getValueNonExistingCode() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertEquals(null, model.getValue("XXX"));
    }

    @Test
    public void setValue() {
        ResponseModel model = new ResponseModel(this.keys, this.values);
        model.setValue("BE0101N1", "789");

        assertEquals("789", model.getValue("BE0101N1").getValue());
    }

    @Test
    public void setValueNonExistingCode() {
        ResponseModel model = new ResponseModel(this.keys, this.values);
        model.setValue("NON_EXISTING_CODE", "789");

        assertEquals("48403", model.getValue("BE0101N1").getValue());
        assertEquals("1007", model.getValue("BE0101N2").getValue());
    }

    @Test
    public void equals() {
        ResponseModel model1 = new ResponseModel();
        ResponseModel model2 = new ResponseModel();

        assertEquals(model1, model2);
    }

    @Test
    public void equalsItself() {
        ResponseModel model = new ResponseModel();

        assertEquals(model, model);
    }

    @Test
    public void equalsItselfWithValues() {
        ResponseModel model1 = new ResponseModel(this.keys, this.values);
        ResponseModel model2 = new ResponseModel(this.keys, this.values);

        assertEquals(model1, model2);
    }

    @Test
    public void notEqualsNull() {
        ResponseModel model = new ResponseModel();

        assertNotEquals(model, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ResponseModel model = new ResponseModel();

        assertNotEquals(model, new Object());
    }

    @Test
    public void equalsHashCode() {
        ResponseModel model1 = new ResponseModel(this.keys, this.values);
        ResponseModel model2 = new ResponseModel(this.keys, this.values);

        assertEquals(Integer.valueOf(model1.hashCode()), Integer.valueOf(model2.hashCode()));
    }

    @Test
    public void toStringValues() {
        ResponseModel model = new ResponseModel(this.keys, this.values);

        assertTrue(model.toString().contains("k1"));
        assertTrue(model.toString().contains("value1"));
        assertTrue(model.toString().contains("k2"));
        assertTrue(model.toString().contains("value2"));
        assertTrue(model.toString().contains("48403"));
        assertTrue(model.toString().contains("BE0101N1"));
        assertTrue(model.toString().contains("Population"));
        assertTrue(model.toString().contains("1007"));
        assertTrue(model.toString().contains("BE0101N2"));
        assertTrue(model.toString().contains("Population growth"));
    }

    @Test
    public void toStringNull() {
        ResponseModel model = new ResponseModel();

        assertNotNull(model);
    }

    @Test
    public void toStringNoKeys() {
        ResponseModel model = new ResponseModel();

        assertFalse(model.toString().contains("k1"));
        assertFalse(model.toString().contains("value1"));
        assertFalse(model.toString().contains("k2"));
        assertFalse(model.toString().contains("value2"));
    }

    @Test
    public void toStringNoValues() {
        ResponseModel model = new ResponseModel();

        assertFalse(model.toString().contains("48403"));
        assertFalse(model.toString().contains("BE0101N1"));
        assertFalse(model.toString().contains("Population"));
        assertFalse(model.toString().contains("1007"));
        assertFalse(model.toString().contains("BE0101N2"));
        assertFalse(model.toString().contains("Population growth"));
    }

}
