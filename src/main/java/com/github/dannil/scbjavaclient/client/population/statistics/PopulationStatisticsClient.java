/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.statistics.adoptees.PopulationStatisticsAdopteesClient;
import com.github.dannil.scbjavaclient.client.population.statistics.amount.PopulationStatisticsAmountClient;
import com.github.dannil.scbjavaclient.client.population.statistics.averageage.PopulationStatisticsAverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.statistics.density.PopulationStatisticsDensityClient;
import com.github.dannil.scbjavaclient.client.population.statistics.livebirths.PopulationStatisticsLiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.partnership.PopulationStatisticsPartnershipClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles population statistics data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationStatisticsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PopulationStatisticsClient() {
        super();

        addClient("adoptees", new PopulationStatisticsAdopteesClient());
        addClient("amount", new PopulationStatisticsAmountClient());
        addClient("averageage", new PopulationStatisticsAverageAgeClient());
        addClient("density", new PopulationStatisticsDensityClient());
        addClient("livebirths", new PopulationStatisticsLiveBirthsClient());
        addClient("partnership", new PopulationStatisticsPartnershipClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population statistics adoptees
     * data.</p>
     *
     * @return a client for population statistics adoptees data
     */
    public PopulationStatisticsAdopteesClient adoptees() {
        return (PopulationStatisticsAdopteesClient) getClient("adoptees");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics amount data.</p>
     *
     * @return a client for population statistics amount data
     */
    public PopulationStatisticsAmountClient amount() {
        return (PopulationStatisticsAmountClient) getClient("amount");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics average age data.
     * </p>
     *
     * @return a client for population statistics average age data
     */
    public PopulationStatisticsAverageAgeClient averageAge() {
        return (PopulationStatisticsAverageAgeClient) getClient("averageage");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics density data.
     * </p>
     *
     * @return a client for population statistics density data
     */
    public PopulationStatisticsDensityClient density() {
        return (PopulationStatisticsDensityClient) getClient("density");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics live births data.
     * </p>
     *
     * @return a client for population statistics live births data
     */
    public PopulationStatisticsLiveBirthsClient liveBirths() {
        return (PopulationStatisticsLiveBirthsClient) getClient("livebirths");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics partnership
     * data.</p>
     *
     * @return a client for population statistics partnership data
     */
    public PopulationStatisticsPartnershipClient partnership() {
        return (PopulationStatisticsPartnershipClient) getClient("partnership");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/");
    }

}