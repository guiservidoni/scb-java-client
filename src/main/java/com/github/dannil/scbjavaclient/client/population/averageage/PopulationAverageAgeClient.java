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

package com.github.dannil.scbjavaclient.client.population.averageage;

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
 * <p>Client which handles population average age data fetching.</p>
 *
 * @since 0.1.0
 */
public class PopulationAverageAgeClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationAverageAgeClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationAverageAgeClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all average age data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAverageAge(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAverageAge() {
        return getAverageAge(null, null, null);
    }

    /**
     * <p>Fetch all average age data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param genders
     *            the genders to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAverageAge(Collection<String> regions, Collection<String> genders,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("BE0101G9"));
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Kon", genders);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "BefolkningMedelAlder", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "BE/BE0101/BE0101B/";
    }

}
