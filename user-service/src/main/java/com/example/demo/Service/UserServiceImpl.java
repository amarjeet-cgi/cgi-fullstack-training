package com.example.demo.Service;

import com.example.demo.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.Entity.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		log.info("within create user method of service layer");
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		userEntity.setUserId(UUID.randomUUID().toString());
		System.out.println(userEntity);
		userRepository.save(userEntity);
		log.debug("done updating data");
		UserResponseModel responseModel=modelMapper.map(userEntity, UserResponseModel.class);
		return responseModel;
	}


	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public UserResponseModel getUsersById(int id) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<UserEntity> user_res =  userRepository.findById(id);
		
		
		if (!user_res.isPresent()) {
			return null;
		}
		
		else {
			return modelMapper.map(user_res, UserResponseModel.class);
		}
		
		
	}
	
	

}