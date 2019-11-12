package com.waplak.pawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waplak.pawn.entity.AdvanceHeader;

@Repository
public interface AdvanceRepo extends JpaRepository<AdvanceHeader,String>{
	AdvanceHeader findByNic(String nic);
}
