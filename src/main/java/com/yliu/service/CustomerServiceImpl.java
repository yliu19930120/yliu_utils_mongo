package com.yliu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yliu.bean.Customer;
import com.yliu.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomerByName(String name) {
		
		return customerRepository.findByLastName(name);
	}

}
