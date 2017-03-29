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

package com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.EndpointURL;
import com.github.dannil.scbjavaclient.model.financialmarkets.investmentfunds.OwnershipOfInvestmentFundShares;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles financial markets investment funds data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsInvestmentFundsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsInvestmentFundsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsInvestmentFundsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all ownership of investment fund shares data.</p>
     *
     * @return the ownership of investment fund shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.investmentfunds.OwnershipOfInvestmentFundShares
     *         OwnershipOfInvestmentFundShares} objects
     *
     * @see #getOwnershipOfInvestmentFundShares(Collection, Collection, Collection)
     */
    public List<OwnershipOfInvestmentFundShares> getOwnershipOfInvestmentFundShares() {
        return getOwnershipOfInvestmentFundShares(null, null, null);
    }

    /**
     * <p>Fetch all ownership of investment fund shares data which match the input
     * constraints.</p>
     *
     * @param types
     *            the types to fetch data for
     * @param sectors
     *            the sectors to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the ownership of investment fund shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.investmentfunds.OwnershipOfInvestmentFundShares
     *         OwnershipOfInvestmentFundShares} objects
     */
    public List<OwnershipOfInvestmentFundShares> getOwnershipOfInvestmentFundShares(Collection<String> types,
            Collection<String> sectors, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Fondtyp", types);
        mappings.put("Sektor", sectors);
        mappings.put(APIConstants.TIME_CODE, quarters);

        String response = doPostRequest(getUrl() + "VPfondKv", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfInvestmentFundShares.class);
    }

    @Override
    public EndpointURL getUrl() {
        return getRootUrl().append("FM/FM0403/");
    }

}
