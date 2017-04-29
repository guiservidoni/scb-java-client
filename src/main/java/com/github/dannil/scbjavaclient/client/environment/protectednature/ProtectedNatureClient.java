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

package com.github.dannil.scbjavaclient.client.environment.protectednature;

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
 * <p>Client which handles environment protected nature data fetching.</p>
 *
 * @since 0.3.0
 */
public class ProtectedNatureClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public ProtectedNatureClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public ProtectedNatureClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all wildlife sanctuaries data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWildlifeSanctuaries(Collection, Collection)
     */
    public List<ResponseModel> getWildlifeSanctuaries() {
        return getWildlifeSanctuaries(null, null);
    }

    /**
     * <p>Fetch all wildlife sanctuaries data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWildlifeSanctuaries(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DjurVaxtskydd", mappings);
    }

    /**
     * <p>Fetch all Natura 2000 sites data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNatura2000Sites(Collection, Collection)
     */
    public List<ResponseModel> getNatura2000Sites() {
        return getNatura2000Sites(null, null);
    }

    /**
     * <p>Fetch all Natura 2000 sites data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNatura2000Sites(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Natura2000", mappings);
    }

    /**
     * <p>Fetch all protected areas data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProtectedAreas(Collection, Collection)
     */
    public List<ResponseModel> getProtectedAreas() {
        return getProtectedAreas(null, null);
    }

    /**
     * <p>Fetch all protected areas data which match the input constraints.</p>
     *
     * @param natureTypes
     *            the nature types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProtectedAreas(Collection<String> natureTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Naturtyp", natureTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NaturTypSkyddOmr", mappings);
    }

    /**
     * <p>Fetch all productive forest land data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProductiveForestLand(Collection, Collection)
     */
    public List<ResponseModel> getProductiveForestLand() {
        return getProductiveForestLand(null, null);
    }

    /**
     * <p>Fetch all productive forest land data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProductiveForestLand(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ProdSkogsmark", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0603/");
    }

}