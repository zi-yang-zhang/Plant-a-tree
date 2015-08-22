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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DonationRecord{");
		sb.append("donationAmount=").append(donationAmount);
		sb.append(", donationDate=").append(donationDate);
		sb.append('}');
		return sb.toString();
	}

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
