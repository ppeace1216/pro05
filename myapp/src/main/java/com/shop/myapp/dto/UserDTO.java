package com.shop.myapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private String addr1;
	private String addr2;
	private String postcode;
	private String tel;
	private String email;
	private String regdate;
}
