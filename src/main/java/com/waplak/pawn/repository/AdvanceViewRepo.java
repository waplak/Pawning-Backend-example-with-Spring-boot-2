package com.waplak.pawn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waplak.pawn.entity.AdvanceView;

public interface AdvanceViewRepo extends JpaRepository<AdvanceView, String>{
	List <AdvanceView> findBySerialNo(String serialNo);
}
