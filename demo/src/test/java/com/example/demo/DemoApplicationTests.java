package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	@Test
	void findbyname() {
		List<Customer> list = customerRepo.findByName("이순신");
		System.out.println(list);
		assertEquals("이순신", list.get(0).getName());
		
	}
	//@Test
	void findall() {
		Iterable<Customer> list = customerRepo.findAll();
		//방법1) forEach
		//list.forEach(cust -> System.out.println(cust.getName()));
		
		//방법2) iterator
		Iterator<Customer> iter = list.iterator();
		while(iter.hasNext()) {
			//다음 요소가 있다면 꺼내옴
			Customer cust = iter.next();
			System.out.println(cust.getName());
		}
	}
	
	//@Test
	void save() {
		Customer cust = new Customer();		
		cust.setName("김유신");
		cust.setPhone("010-3333-1111");
		
		//등록과 수정이 전부 save => 기본키가 있으면 수정, 없으면 등록
		Customer result = customerRepo.save(cust);
		
		//test의 결과가 반드시 true, false가 나와야 maven build시 오류가 안남
		//-> assert를 사용할 것
		assertEquals(cust.getName(), result.getName());
	}

}
