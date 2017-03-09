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

package com.github.dannil.scbjavaclient.client.environment.landuse.buildings;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.landuse.buildings.Building;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment land use building data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseBuildingsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLandUseBuildingsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseBuildingsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all building data.</p>
     *
     * @return the building data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.buildings.Building
     *         Building} objects
     *
     * @see #getBuilding(Collection, Collection, Collection)
     */
    public List<Building> getBuilding() {
        return getBuilding(null, null, null);
    }

    /**
     * <p>Fetch all building data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param types
     *            the types to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the building data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.buildings.Building
     *         Building} objects
     */
    public List<Building> getBuilding(Collection<String> regions, Collection<Integer> types,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("MI0803AD", "MI0803AE"));
        mappings.put("Region", regions);
        mappings.put("Byggnadstyp", types);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "MarkanvByggnadLnKn", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(Building.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0803/MI0803B/";
    }

}