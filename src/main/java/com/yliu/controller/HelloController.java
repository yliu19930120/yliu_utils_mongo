package com.yliu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yliu.bean.Customer;
import com.yliu.service.CustomerService;

@RestController
@RequestMapping("/")
public class HelloController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/hello")
	public String hello(){
		return "hello world";
	}
	@GetMapping("/customer/{name}")
	public Integer getCustomer(@PathVariable("name")String name){
		List<Customer> list = customerService.getCustomerByName(name);
		return list.size();
	}
}
