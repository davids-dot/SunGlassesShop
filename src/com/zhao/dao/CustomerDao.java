package com.zhao.dao;

import java.util.List;

import com.zhao.entity.Customer;

public interface CustomerDao {

	public void changeCustomerInfo(Customer cus);

	public List<Customer> queryCustomer(Customer cus);

}
