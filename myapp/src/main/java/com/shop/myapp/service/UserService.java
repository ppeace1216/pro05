package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.UserDTO;

public interface UserService {
	List<UserDTO> userList();
	UserDTO getUser(String id);
	void joinUser(UserDTO udto);
	UserDTO signIn(UserDTO udto);
	UserDTO loginCheck(UserDTO udto);
	void userUpdate(UserDTO udto);
	void userDelete(String id);
}
