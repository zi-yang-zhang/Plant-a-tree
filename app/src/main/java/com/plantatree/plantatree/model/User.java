package com.plantatree.plantatree.model;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class User {
	@Expose
	private String email;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("email='").append(email).append('\'');
		sb.append(", donationRecords=").append(Arrays.toString(donationRecords));
		sb.append(", region='").append(region).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public DonationRecord[] getDonationRecords() {
		return donationRecords;
	}

	public void setDonationRecords(DonationRecord[] donationRecords) {
		this.donationRecords = donationRecords;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Expose
	private DonationRecord[] donationRecords;
	@Expose
	private String region;
}
