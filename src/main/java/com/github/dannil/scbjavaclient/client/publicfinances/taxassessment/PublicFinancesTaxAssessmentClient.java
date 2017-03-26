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

package com.github.dannil.scbjavaclient.client.publicfinances.taxassessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles public finances tax assessment data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesTaxAssessmentClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesTaxAssessmentClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesTaxAssessmentClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all assessed and taxable earned income data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssessedAndTaxableEarnedIncome(Collection, Collection)
     */
    public List<ResponseModel> getAssessedAndTaxableEarnedIncome() {
        return getAssessedAndTaxableEarnedIncome(null, null);
    }

    /**
     * <p>Fetch all assessed and taxable earned income data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssessedAndTaxableEarnedIncome(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE,
                Arrays.asList("OE0701AA", "OE0701AB", "OE0701AC", "OE0701AD", "OE0701AE"));
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "ForvInkomsterA", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    /**
     * <p>Fetch all assessment for national capital income tax data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssessmentForNationalCapitalIncomeTax(Collection, Collection)
     */
    public List<ResponseModel> getAssessmentForNationalCapitalIncomeTax() {
        return getAssessmentForNationalCapitalIncomeTax(null, null);
    }

    /**
     * <p>Fetch all assessment for national capital income tax data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssessmentForNationalCapitalIncomeTax(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE,
                Arrays.asList("OE0701CA", "OE0701CB", "OE0701CC", "OE0701CD", "OE0701CE", "OE0701CF"));
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "KapInkomsterA", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "OE/OE0701/";
    }

}
