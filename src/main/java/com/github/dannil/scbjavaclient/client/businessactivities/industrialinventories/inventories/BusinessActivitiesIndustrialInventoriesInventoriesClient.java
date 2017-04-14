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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.inventories;

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
 * <p>Client which handles business activities industrial inventories inventories data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesIndustrialInventoriesInventoriesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesIndustrialInventoriesInventoriesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesIndustrialInventoriesInventoriesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all changes in inventories data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getChangesInInventories(Collection, Collection, Collection)
     */
    public List<ResponseModel> getChangesInInventories() {
        return getChangesInInventories(null, null, null);
    }

    /**
     * <p>Fetch all changes in inventories data which match the input constraints.</p>
     *
     * @param inventoryTypes
     *            the inventory types
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getChangesInInventories(Collection<String> inventoryTypes,
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Lagertyp", inventoryTypes);
        mappings.put("SNI2007", industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("IndLagerSNI07Kv", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0602/NV0602A/");
    }

}