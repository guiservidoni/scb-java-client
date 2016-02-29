/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.model;

import java.util.Objects;

/**
 * Abstract model which handles region, year and value. Since these values are used by almost every
 * single Client response, this class will be extended by a majority of the implemented models.
 * 
 * @author Daniel Nilsson
 *
 * @param <R>
 *            the region
 * @param <Y>
 *            the year
 * @param <V>
 *            the value
 */
public class AbstractRegionAndYearModel<R, Y, V> extends AbstractModel<V> {

	protected R region;
	protected Y year;

	/**
	 * Default constructor.
	 */
	protected AbstractRegionAndYearModel() {
		// To enable derived classes to use their default constructor
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param region
	 *            the region
	 * @param year
	 *            the year
	 * @param value
	 *            the value
	 */
	protected AbstractRegionAndYearModel(R region, Y year, V value) {
		super(value);
		this.region = region;
		this.year = year;
	}

	/**
	 * Getter for region
	 * 
	 * @return the region
	 */
	public R getRegion() {
		return this.region;
	}

	/**
	 * Setter for
	 * 
	 * @param region
	 *            the region
	 */
	public void setRegion(R region) {
		this.region = region;
	}

	/**
	 * Getter for year
	 * 
	 * @return the year
	 */
	public Y getYear() {
		return this.year;
	}

	/**
	 * Setter for year
	 * 
	 * @param year
	 *            the year
	 */
	public void setYear(Y year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.region, this.year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractRegionAndYearModel<?, ?, ?>)) {
			return false;
		}

		AbstractRegionAndYearModel<?, ?, ?> other = (AbstractRegionAndYearModel<?, ?, ?>) obj;
		return super.equals(other) && Objects.equals(this.region, other.region)
				&& Objects.equals(this.year, other.year);
	}

}