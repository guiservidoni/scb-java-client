package org.dannil.scbapi.api.population;

import java.util.List;

import org.dannil.scbapi.model.PopulationCollection;

public interface PopulationOperations {

	public PopulationCollection getPopulation();

	public PopulationCollection getPopulation(List<String> regions, List<Integer> years);

}