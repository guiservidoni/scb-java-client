package org.dannil.scbapi.api.population;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.PopulationCollection;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ArrayListMultimap;

public final class StatisticsAPI extends AbstractAPI implements PopulationOperations {

	private String url;

	public StatisticsAPI() {
		this.locale = Locale.getDefault();

		buildUrl();
	}

	public StatisticsAPI(Locale locale) {
		this();
		this.locale = locale;

		buildUrl();
	}

	@Override
	public final void setLocale(Locale locale) {
		this.locale = locale;

		buildUrl();
	}

	public final void buildUrl() {
		this.url = "http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy";
	}

	public final List<String> getAvailableRegions() {
		String response = RequestPoster.doGet(this.url);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(0);

			List<String> years = new ArrayList<String>(node.size());
			for (int i = 0; i < node.size(); i++) {
				years.add(node.get(i).asText());
			}
			return years;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final List<Integer> getAvailableYears() {
		String response = RequestPoster.doGet(this.url);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(nodes.size() - 1);

			List<Integer> years = new ArrayList<Integer>(node.size());
			for (int i = 0; i < node.size(); i++) {
				years.add(node.get(i).asInt());
			}
			return years;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final PopulationCollection getPopulation() {
		return this.getPopulation(null, null);
	}

	public final PopulationCollection getPopulation(List<String> regions, List<Integer> years) {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "BE0101N1");
		if (regions != null) {
			for (String region : regions) {
				map.put("Region", region);
			}
		}
		if (years != null) {
			for (Integer year : years) {
				map.put("Tid", year.toString());
			}
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost(this.url, query);
		return new PopulationCollection(JsonUtility.getNode(response));
	}
}