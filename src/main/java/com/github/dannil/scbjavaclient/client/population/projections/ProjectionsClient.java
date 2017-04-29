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

package com.github.dannil.scbjavaclient.client.population.projections;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.projections.latestassumptions.LatestAssumptionsClient;
import com.github.dannil.scbjavaclient.client.population.projections.latestprojections.LatestProjectionsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles population projections data fetching.</p>
 *
 * @since 0.3.0
 */
public class ProjectionsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public ProjectionsClient() {
        super();

        addClient("latestassumptions", new LatestAssumptionsClient());
        addClient("latestprojections", new LatestProjectionsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public ProjectionsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population projections latest
     * assumptions data.</p>
     *
     * @return a client for population projections latest assumptions data
     */
    public LatestAssumptionsClient latestAssumptions() {
        return (LatestAssumptionsClient) getClient("latestassumptions");
    }

    /**
     * <p>Retrieve the client for interacting with population projections latest
     * projections data.</p>
     *
     * @return a client for population projections latest projections data
     */
    public LatestProjectionsClient latestProjections() {
        return (LatestProjectionsClient) getClient("latestprojections");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0401/");
    }

}