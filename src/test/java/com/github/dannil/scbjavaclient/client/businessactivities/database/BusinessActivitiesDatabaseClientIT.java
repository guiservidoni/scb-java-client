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

package com.github.dannil.scbjavaclient.client.businessactivities.database;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BusinessActivitiesDatabaseClientIT extends RemoteIntegrationTestSuite {

    private BusinessActivitiesDatabaseClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().businessActivities().database();
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2002() {
        assertNotEquals(0, this.client.getEnterprisesAndEmployeesSNI2002().size());
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2002WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnterprisesAndEmployeesSNI2002(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2002WithParameters() {
        List<String> industrialClassifications = Arrays.asList("01.124", "01.2");
        List<String> sizeClasses = Arrays.asList("SGR3", "SGR5");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0,
                this.client.getEnterprisesAndEmployeesSNI2002(industrialClassifications, sizeClasses, years).size());
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2007() {
        assertNotEquals(0, this.client.getEnterprisesAndEmployeesSNI2007().size());
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnterprisesAndEmployeesSNI2007(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEnterprisesAndEmployeesSNI2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("01.199", "01.3");
        List<String> sizeClasses = Arrays.asList("SGR3", "SGR5");
        List<Integer> years = Arrays.asList(2010, 2014);

        assertNotEquals(0,
                this.client.getEnterprisesAndEmployeesSNI2007(industrialClassifications, sizeClasses, years).size());
    }

}