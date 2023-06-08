package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.UserEntity;
import com.example.demo.dto.UserDto;
import com.example.demo.ui.UserResponseModel;

public interface UserService {
	public UserResponseModel createUser(UserDto userDto);
	
	public List<UserEntity> getAllUsers();
	
	public UserResponseModel getUsersById(int id);
	

}
