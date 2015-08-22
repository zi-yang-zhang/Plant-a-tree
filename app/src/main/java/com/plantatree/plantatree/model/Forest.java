package com.plantatree.plantatree.model;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class Forest {
	@Expose
	private String name;
	@Expose
	private Double[] averageHeights;
	@Expose
	private Integer[] numberOfTrees;
	@Expose
	private Integer[] typesOfTrees;
	@Expose
	private Integer[] typesOfSpecies;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Forest{");
		sb.append("name='").append(name).append('\'');
		sb.append(", averageHeights=").append(Arrays.toString(averageHeights));
		sb.append(", numberOfTrees=").append(Arrays.toString(numberOfTrees));
		sb.append(", typesOfTrees=").append(Arrays.toString(typesOfTrees));
		sb.append(", typesOfSpecies=").append(Arrays.toString(typesOfSpecies));
		sb.append(", contributors=").append(Arrays.toString(contributors));
		sb.append('}');
		return sb.toString();
	}

	public Contributor[] getContributors() {
		return contributors;
	}

	public void setContributors(Contributor[] contributors) {
		this.contributors = contributors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double[] getAverageHeights() {
		return averageHeights;
	}

	public void setAverageHeights(Double[] averageHeights) {
		this.averageHeights = averageHeights;
	}

	public Integer[] getNumberOfTrees() {
		return numberOfTrees;
	}

	public void setNumberOfTrees(Integer[] numberOfTrees) {
		this.numberOfTrees = numberOfTrees;
	}

	public Integer[] getTypesOfTrees() {
		return typesOfTrees;
	}

	public void setTypesOfTrees(Integer[] typesOfTrees) {
		this.typesOfTrees = typesOfTrees;
	}

	public Integer[] getTypesOfSpecies() {
		return typesOfSpecies;
	}

	public void setTypesOfSpecies(Integer[] typesOfSpecies) {
		this.typesOfSpecies = typesOfSpecies;
	}

	@Expose

	private Contributor[] contributors;
}
