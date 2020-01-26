package com.waplak.pawn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waplak.pawn.config.AppErrorConfig;
import com.waplak.pawn.entity.Users;
import com.waplak.pawn.request.UserRequest;
import com.waplak.pawn.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger;
	
	@Autowired
	private AppErrorConfig appErrorConfig;
	
	@Autowired
	private UserService userService;

	public UserController() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ApiOperation(value="Create New User")
	@PostMapping("/newUser")
	public Users saveNewUser(@RequestBody UserRequest userReq) {
		logger.info("save User Request {}",userReq);
		return userService.saveUsers(userReq);
	}
	
	@ApiOperation(value="Get User Details")
	@GetMapping("/getSelectedUser/{userName}")
	public Users getSelectedUserDetails(@ApiParam(required = true, name = "userName", value = "User Name canot be Missing or Empty.") @PathVariable String userName) {
		logger.info("Get Selected User {}", userName);
		
		return userService.getSearchedUser(userName);
	}
	
	@ApiOperation(value="Get All Users")
	@GetMapping("/getAllUser")
	public List<Users> getAllUsers(){
		logger.info("Get All Users");
		
		return userService.getAllUser();
	}
}
