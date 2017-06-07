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

package com.github.dannil.scbjavaclient.client.environment.landuse;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.environment.landuse.buildings.EnvironmentLandUseBuildingsClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.planning.EnvironmentLandUsePlanningClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.usage.EnvironmentLandUseUsageClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnvironmentLandUseClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        EnvironmentLandUseClient client = new EnvironmentLandUseClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void buildingsClient() {
        EnvironmentLandUseClient client = new EnvironmentLandUseClient();

        assertEquals(client.buildings().getClass(), EnvironmentLandUseBuildingsClient.class);
    }

    @Test
    public void planningClient() {
        EnvironmentLandUseClient client = new EnvironmentLandUseClient();

        assertEquals(client.planning().getClass(), EnvironmentLandUsePlanningClient.class);
    }

    @Test
    public void usageClient() {
        EnvironmentLandUseClient client = new EnvironmentLandUseClient();

        assertEquals(client.usage().getClass(), EnvironmentLandUseUsageClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        EnvironmentLandUseClient client = new EnvironmentLandUseClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("MI/MI0803/"), client.getUrl());
    }

}