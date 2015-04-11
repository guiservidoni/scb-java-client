package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.environment.landandwaterarea.LandAndWaterAreaAPI;
import org.dannil.scbapi.api.population.statistic.StatisticAPI;
import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import org.dannil.scbapi.model.population.demography.AverageAgeFirstChild;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("en");
		SCBAPI api = new SCBAPI(locale);

		List<String> regions = new ArrayList<String>();
		// regions.add("00");
		regions.add("1267");

		List<Type> types = new ArrayList<Type>();
		types.add(Type.INLANDWATEREXCLUDINGTHEFOURLARGELAKES);

		List<Integer> years = new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);

		List<String> ages = new ArrayList<String>();
		ages.add("18");
		ages.add("20");

		Map<String, String> map = api.getRegionMappings();
		for (String key : map.keySet()) {
			// System.out.println(key + " : " + map.get(key));
		}

		StatisticAPI statisticApi = api.population().statistic();

		// List<Statistic> collection8 =
		// api.population().statistic().getPopulation(regions, null, ages, null,
		// years);
		// for (Statistic p : collection8) {
		// System.out.println(p);
		// }
		//
		// // WORKS
		// List<Statistic> collection4 =
		// api.population().statistic().getPopulation();
		// for (Statistic p : collection4) {
		// System.out.println(p);
		// }
		//
		LandAndWaterAreaAPI lawApi = api.environment().landAndWaterArea();
		//
		// List<Area> collection5 = lawApi.getArea(regions, null, years);
		// for (Area a : collection5) {
		// System.out.println(a);
		// }

		List<Area> collection6 = lawApi.getArea(regions, types, years);
		for (Area a : collection6) {
			System.out.println(a);
		}

		List<AverageAgeFirstChild> collection7 = api.population().demography().getAverageAgeFirstChild(regions, null, null);
		for (AverageAgeFirstChild a : collection7) {
			System.out.println(a);
		}

	}
}
