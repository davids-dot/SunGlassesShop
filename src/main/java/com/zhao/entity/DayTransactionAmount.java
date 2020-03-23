package com.zhao.entity;

import java.sql.Date;

public class DayTransactionAmount {

	private String date;
	private Double transaction_amount;

	public String getDate() {
		return date;
	}

	public void setString(String date) {
		this.date = date;
	}

	public Double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(Double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

}
