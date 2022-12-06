package com.shop.myapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.UserDTO;

@Mapper
@Repository
public interface UserDAO {
	List<UserDTO> userList();
	UserDTO getUser(String id);
	void joinUser(UserDTO udto);
	UserDTO signIn(UserDTO udto);
	UserDTO loginCheck(UserDTO udto);
	void userUpdate(UserDTO udto);
	void userDelete(String id);
}
