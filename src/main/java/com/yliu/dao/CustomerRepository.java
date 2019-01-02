package com.yliu.dao;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.yliu.bean.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);
}
