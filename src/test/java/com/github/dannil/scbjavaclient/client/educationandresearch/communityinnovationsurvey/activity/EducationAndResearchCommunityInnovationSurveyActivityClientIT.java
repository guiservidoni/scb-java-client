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

package com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.activity;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class EducationAndResearchCommunityInnovationSurveyActivityClientIT extends RemoteIntegrationTestSuite {

    private EducationAndResearchCommunityInnovationSurveyActivityClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().educationAndResearch().communityInnovationSurvey().activity();
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprises() {
        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises().size());
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNumberOfInnovativeEnterprises(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprisesWithParameters() {
        List<String> industrialClassifications = Arrays.asList("SA14", "SA12");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2008-2010", "2010-2012");

        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises(industrialClassifications, sizeClasses,
                typesOfValues, periods).size());
    }

}