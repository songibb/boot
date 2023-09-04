package com.example.demo.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository<테이블, 기본키타입>
//@Repository -> mapper interface와 같은 역할
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByName(String name);
}
