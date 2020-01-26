package com.waplak.pawn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waplak.pawn.config.AppErrorConfig;
import com.waplak.pawn.entity.Users;
import com.waplak.pawn.repository.UserRepo;
import com.waplak.pawn.request.UserRequest;
import com.waplak.pawn.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{

	private Logger logger;
	@Autowired
	private AppErrorConfig appErrorConfig;
	
	@Autowired
	private UserRepo userRepo;
	
	public UserServiceImpl() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	@Override
	public Users saveUsers(UserRequest userRequesr) {
		logger.info("save User Request {}",userRequesr);
		return userRepo.save(userRequesr.getUser());
	}

	@Override
	public Users getSearchedUser(String userName) {
		logger.info("find user {}",userName);
		return userRepo.findByUserName(userName);
	}
	@Override
	public List<Users> getAllUser() {
		logger.info("Get All User");
		return userRepo.findAll();
	}

}
