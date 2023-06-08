package com.example.demo.Controler;
import java.util.List;
import java.util.*;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;
import com.example.demo.ui.ErrorModel;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/users")
@AllArgsConstructor

public class UserController {
	
	private final ModelMapper modelMapper;
	private final UserService userService;
	
	@ExceptionHandler(value = NumberFormatException.class)	
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e)
	{
		ErrorModel errorModel=new ErrorModel(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}
	
	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel requestModel)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto=modelMapper.map(requestModel, UserDto.class);
		System.out.println(userDto);
		StringBuffer sb=new StringBuffer();
		sb.append(requestModel.getPassword());
		userDto.setEncrytedPassword(sb.reverse().toString());
		System.out.println(userDto);
	 UserResponseModel responseModel=	userService.createUser(userDto);
	 
	 return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
			 
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseModel>> getUsers(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> models = new ArrayList<UserResponseModel>();
		
		List<UserEntity> list = userService.getAllUsers();
		
		for (UserEntity entity: list) {
			models.add(modelMapper.map(entity, UserResponseModel.class));
		
		}
		
		return ResponseEntity.ok(models);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getUsersById(@PathVariable("id") Integer id)throws NumberFormatException{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		
		System.out.println(id);
		UserResponseModel val = userService.getUsersById(id);
		
		if (val==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user with id: "+id+" not found");
		
		}
		
		else {
		return ResponseEntity.status(HttpStatus.OK).body(val);
		}
	

	
	}
	

}