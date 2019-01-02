package com.yliu.service;

import java.util.List;

import com.yliu.bean.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomerByName(String name);
}
