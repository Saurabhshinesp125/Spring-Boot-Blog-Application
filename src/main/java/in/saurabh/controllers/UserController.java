package in.saurabh.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import in.saurabh.payloads.ApiResponse;
import in.saurabh.payloads.UserDto;
import in.saurabh.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
//	public UserController(UserService userService) {
//		super();
//		this.userService = userService;
//	}

    @PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
	{
		UserDto createUser = userService.createUser(user);
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}
    
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user,Integer userId)
    {
    	UserDto updateUser = userService.updateUser(user,userId);
    	return  ResponseEntity.ok(updateUser);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId")Integer uid)
    {
    	this.userService.deleteUser(uid);
    	return ResponseEntity.ok( new ApiResponse("User Is Deleted",true));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
    	return ResponseEntity.ok(this.userService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
    {
    	return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
