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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.depositandlending;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles financial markets statistics deposit and lending data
 * fetching.</p>
 *
 * @since 0.5.0
 */
public class FinancialMarketsStatisticsDepositAndLendingClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsStatisticsDepositAndLendingClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsDepositAndLendingClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all lending rates breakdown by remaining maturity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesBreakdownByRemainingMaturity(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesBreakdownByRemainingMaturity() {
        return getLendingRatesBreakdownByRemainingMaturity(null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates breakdown by remaining maturity data which match the
     * input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param remainingMaturity
     *            the remaining maturity
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesBreakdownByRemainingMaturity(Collection<String> referenceSectors,
            Collection<Integer> counterpartySectors, Collection<String> remainingMaturity, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Referenssektor", referenceSectors);
        mappings.put("Motpartssektor", counterpartySectors);
        mappings.put("AterstRantebtid", remainingMaturity);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT02", mappings);
    }

    /**
     * <p>Fetch all lending rates to households for housing loans breakdown by remaining
     * maturity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesToHouseholdsForHousingLoansBreakdownByRemainingMaturity(Collection,
     *      Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesToHouseholdsForHousingLoansBreakdownByRemainingMaturity() {
        return getLendingRatesToHouseholdsForHousingLoansBreakdownByRemainingMaturity(null, null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates to households for housing loans breakdown by remaining
     * maturity data which match the input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param agreements
     *            the agreements
     * @param originalRateFixations
     *            the original rate fixations
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesToHouseholdsForHousingLoansBreakdownByRemainingMaturity(
            Collection<String> referenceSectors, Collection<String> counterpartySectors, Collection<String> agreements,
            Collection<String> originalRateFixations, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Referenssektor", referenceSectors);
        mappings.put("Motpartssektor", counterpartySectors);
        mappings.put("Avtal", agreements);
        mappings.put("Rantebindningstid", originalRateFixations);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT04", mappings);
    }

    // TODO IMPLEMENT

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/FM5001C/");
    }

}
