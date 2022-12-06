package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dto.UserDTO;
import com.shop.myapp.repository.UserDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserDAO userMapper;

	@Override
	public List<UserDTO> userList() {
		return userMapper.userList();
	}

	@Override
	public UserDTO getUser(String id) {
		return userMapper.getUser(id);
	}

	@Override
	public void joinUser(UserDTO udto) {
		userMapper.joinUser(udto);
		
	}
	@Override
	public UserDTO signIn(UserDTO udto) {
		return userMapper.signIn(udto);
	}

	@Override
	public UserDTO loginCheck(UserDTO udto) {
		return userMapper.loginCheck(udto);
	}

	@Override
	public void userUpdate(UserDTO udto) {
		userMapper.userUpdate(udto);
	}

	@Override
	public void userDelete(String id) {
		userMapper.userDelete(id);
	}
}
