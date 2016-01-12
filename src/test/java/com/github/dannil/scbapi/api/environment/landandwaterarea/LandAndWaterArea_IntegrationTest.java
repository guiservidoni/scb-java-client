/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.api.environment.landandwaterarea;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.api.SCBAPI;

@RunWith(JUnit4.class)
public class LandAndWaterArea_IntegrationTest {

	private LandAndWaterAreaAPI landAndWaterAreaApi;

	@Before
	public final void init() {
		this.landAndWaterAreaApi = new SCBAPI().environment().landAndWaterArea();
	}

	// TODO Enable tests in the future

	// @Test
	// public final void getRegions() {
	// assertNotEquals(0, this.landAndWaterAreaApi.getRegions().size());
	// }
	//
	// @Test
	// public final void getYears() {
	// assertNotEquals(0, this.landAndWaterAreaApi.getYears().size());
	// }

	@Test
	public final void getArea() {
		assertNotEquals(0, this.landAndWaterAreaApi.getArea().size());
	}

}
