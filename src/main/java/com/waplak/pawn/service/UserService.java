package com.waplak.pawn.service;

import java.util.List;

import com.waplak.pawn.entity.Users;
import com.waplak.pawn.request.UserRequest;

public interface UserService {
	
	Users saveUsers(UserRequest userRequesr);
	Users getSearchedUser(String userName);
	List<Users> getAllUser();
}
