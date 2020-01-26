package com.waplak.pawn.service;

import java.util.List;

import com.waplak.pawn.entity.AdvanceView;

public interface AdvanceViewService {
	List<AdvanceView> getAdvanceDataFromSerial(String serialNo);

	List<AdvanceView> findAll();
}
