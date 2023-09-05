package com.example.demo.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//롬복 이용해서 생성자 만들기
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessage {
	private String cmd;
	private String name;
}
