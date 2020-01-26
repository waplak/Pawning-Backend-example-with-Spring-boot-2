package com.waplak.pawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waplak.pawn.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	Users findByUserName(String userName);
}
