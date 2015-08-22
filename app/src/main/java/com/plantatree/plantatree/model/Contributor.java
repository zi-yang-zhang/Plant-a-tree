package com.plantatree.plantatree.model;

import com.google.gson.annotations.Expose;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class Contributor {
	@Expose
	private String name;
	@Expose
	private Double donation;
	@Expose
	private Integer frequency;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Contributor{");
		sb.append("name='").append(name).append('\'');
		sb.append(", donation=").append(donation);
		sb.append(", frequency=").append(frequency);
		sb.append('}');
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDonation() {
		return donation;
	}

	public void setDonation(Double donation) {
		this.donation = donation;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
}
