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

package com.github.dannil.scbjavaclient.client.environment.airpollutants;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class EnvironmentAirPollutantsClientIT {

    private EnvironmentAirPollutantsClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentAirPollutantsClient();
    }

    @Test
    @Date("2017-04-13")
    public void getTotalEmissions() {
        assertNotEquals(0, this.client.getTotalEmissions().size());
    }

    @Test
    @Date("2017-04-13")
    public void getTotalEmissionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTotalEmissions(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getTotalEmissionsWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> sectors = Arrays.asList("1.0", "5.0");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getTotalEmissions(airPollutants, sectors, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromOffroadVehiclesAndMachinery() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> subSectors = Arrays.asList("1.0", "1.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromOffroadVehiclesAndMachinery(airPollutants, subSectors, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromWaste() {
        assertNotEquals(0, this.client.getEmissionsFromWaste().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromWasteWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> subSectors = Arrays.asList("2.0", "2.1.1");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromWaste(airPollutants, subSectors, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromElectricityAndHeating() {
        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromElectricityAndHeatingParametersWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromElectricityAndHeatingWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> fuelTypes = Arrays.asList("3.0", "3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating(airPollutants, fuelTypes, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromIndustry() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromIndustryWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromIndustryWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> industries = Arrays.asList("4.1.1", "4.1.3");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromIndustry(airPollutants, industries, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromDomesticTransport() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromDomesticTransportWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromDomesticTransportWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> modesOfTransportations = Arrays.asList("8.4", "8.4.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromDomesticTransport(airPollutants, modesOfTransportations, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromAgriculture() {
        assertNotEquals(0, this.client.getEmissionsFromAgriculture().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromAgricultureWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromAgricultureWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> subSectors = Arrays.asList("6.3", "6.3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromAgriculture(airPollutants, subSectors, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromSolventUse() {
        assertNotEquals(0, this.client.getEmissionsFromSolventUse().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromSolventUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromSolventUseWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> areas = Arrays.asList("7.2.1", "7.2.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromSolventUse(airPollutants, areas, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromHeatingOfHousesAndBuildings() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> subSectors = Arrays.asList("9.1.1", "9.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromHeatingOfHousesAndBuildings(airPollutants, subSectors, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromInternationalTransport() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport().size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromInternationalTransportWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getEmissionsFromInternationalTransportWithParameters() {
        List<String> airPollutants = Arrays.asList("NH3", "Cd");
        List<String> activities = Arrays.asList("5.4", "5.6");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport(airPollutants, activities, years).size());
    }

}
