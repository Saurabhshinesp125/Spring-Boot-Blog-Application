package in.saurabh.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.saurabh.entity.User;
import in.saurabh.exceptions.ResourceNotFoundException;
import in.saurabh.payloads.UserDto;
import in.saurabh.repositories.UserRepository;
import in.saurabh.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository repository;
	private ModelMapper mapper;
	
	
	
	
	public UserServiceImpl(UserRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public UserDto createUser(UserDto user) {
		User user1 = mapper.map(user,User.class);
		User saveUser = repository.save(user1);
		
		return mapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		User user2 = repository.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setAbout(user.getAbout());
		
		User save = repository.save(user2);
		UserDto userDto = mapper.map(save,UserDto.class);
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		repository.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return mapper.map(userId,UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> findAll = repository.findAll();
		//UserDto map = mapper.map(findAll,UserDto.class);
		List<User> collect = findAll.stream().collect(Collectors.toList());
		@SuppressWarnings("unchecked")
		List<UserDto> map = (List<UserDto>) mapper.map(collect,UserDto.class);
		return  map;
	}

	@Override
	public void deleteUser(Integer userId) {
		 User user = repository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		repository.delete(user);

	}

}
