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

package com.github.dannil.scbjavaclient.client.livingconditions.families.legalguardians;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.livingconditions.families.legalguardians.LegalGuardians;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles living conditions families legal guardians data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsFamiliesLegalGuardiansClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsFamiliesLegalGuardiansClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsFamiliesLegalGuardiansClient(Locale locale) {
        super(locale);
    }

    public List<LegalGuardians> getLegalGuardians() {
        return getLegalGuardians(null, null, null, null);
    }

    public List<LegalGuardians> getLegalGuardians(Collection<String> sexes, Collection<String> caregivers,
            Collection<String> familyTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("000000T0"));
        mappings.put("Kon", sexes);
        mappings.put("Vardnadshavare", caregivers);
        mappings.put("Familjetyp", familyTypes);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "LE0102T28", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(LegalGuardians.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0102/LE0102O/";
    }

}
