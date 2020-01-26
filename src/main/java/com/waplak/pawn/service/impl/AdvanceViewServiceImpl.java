package com.waplak.pawn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waplak.pawn.entity.AdvanceView;
import com.waplak.pawn.repository.AdvanceViewRepo;
import com.waplak.pawn.service.AdvanceViewService;

@Service
public class AdvanceViewServiceImpl implements AdvanceViewService{

	private Logger logger;
	@Autowired
	private AdvanceViewRepo advanceViewRepo;
	
	public AdvanceViewServiceImpl() {
		this.logger = LoggerFactory.getLogger(this.getClass());

	}
	@Override
	public List<AdvanceView> getAdvanceDataFromSerial(String serialNo) {
		logger.info("Serial No from Service {} ",serialNo);
		return advanceViewRepo.findBySerialNo(serialNo);
	}
	@Override
	public List<AdvanceView> findAll() {
		// TODO Auto-generated method stub
		return advanceViewRepo.findAll();
	}

}
