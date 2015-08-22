package com.plantatree.plantatree.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class DonationRecord {
	@Expose
	private Double donationAmount;
	@Expose
	private Date donationDate;
	@Expose
	private String region;


	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
}
