package com.plantatree.plantatree.model;

import com.google.gson.annotations.Expose;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class User {
	@Expose
	private String email;


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


	@Expose
	private DonationRecord[] donationRecords;

	@Expose
	private Forest forest;

}
