package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.zhao.entity.DayTransactionAmount;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;

public class DayTransactionDaoImpl {

	@SuppressWarnings("unchecked")
	public List<DayTransactionAmount> queryDayAmount() {
		String sql = "select date,transaction_amount  from day_transaction_amount ";

		try {
			return (List<DayTransactionAmount>) DBUtil2.executeQuery(sql, null,
					new BeanListHandler<DayTransactionAmount>(DayTransactionAmount.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
