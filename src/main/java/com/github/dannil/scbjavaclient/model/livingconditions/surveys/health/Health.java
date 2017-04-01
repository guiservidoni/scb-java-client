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

package com.github.dannil.scbjavaclient.model.livingconditions.surveys.health;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for health data.</p>
 *
 * @since 0.3.0
 */
public class Health extends AbstractTimeAndValueModel<String, String> {

    @JsonProperty("Indikator")
    private String indicator;

    @JsonProperty("Alder")
    private String age;

    @JsonProperty("Kon")
    private Integer sex;

    /**
     * <p>Default constructor.</p>
     */
    public Health() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param indicator
     *            the indicator
     * @param age
     *            the age
     * @param sex
     *            the sex
     * @param period
     *            the period
     * @param values
     *            the values
     */
    public Health(String indicator, String age, Integer sex, String period, List<ValueNode<String>> values) {
        super(period, values);
        this.indicator = indicator;
        this.age = age;
        this.sex = sex;
    }

    /**
     * <p>Getter for indicator.</p>
     *
     * @return the indicator
     */
    public String getIndicator() {
        return this.indicator;
    }

    /**
     * <p>Setter for indicator.</p>
     *
     * @param indicator
     *            the indicator
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    /**
     * <p>Getter for age.</p>
     *
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * <p>Setter for age.</p>
     *
     * @param age
     *            the age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * <p>Getter for sex.</p>
     *
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * <p>Setter for sex.</p>
     *
     * @param sex
     *            the sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.indicator, this.age, this.sex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Health)) {
            return false;
        }
        Health other = (Health) obj;
        return super.equals(obj) && Objects.equals(this.indicator, other.indicator)
                && Objects.equals(this.age, other.age) && Objects.equals(this.sex, other.sex);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("indicator", this.indicator);
        variables.put("age", this.age);
        variables.put("sex", this.sex);
        return super.buildToString(variables);
    }

}