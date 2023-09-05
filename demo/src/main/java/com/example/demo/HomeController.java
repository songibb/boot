package com.example.demo;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.chat.Greeting;
import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@RestController
public class HomeController {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	//index.html과 충돌
//	@GetMapping("/")
//	public String greet() {
//		return "hello";
//	}
	
	@GetMapping("/cust")
	public Iterator<Customer> cust(){
		//topic 추가 할때마다 메시지 요청
		String text = "[" + new Date() + "]:" + "cust select";
		
		//this.template.convertAndSend("/topic/cust", new Greeting(text));  

		this.template.convertAndSend("/topic/cust", text);  
		
		return repo.findAll().iterator();
		
	}
}
