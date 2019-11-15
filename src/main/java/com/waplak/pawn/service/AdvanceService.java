package com.waplak.pawn.service;

import com.waplak.pawn.exception.PawnException;
import com.waplak.pawn.request.AdvanceRequest;
import com.waplak.pawn.response.AdvanceResponse;
import com.waplak.pawn.response.NicResponse;

public interface AdvanceService {
	AdvanceResponse saveAdvance(AdvanceRequest request) throws PawnException;
	NicResponse getByNic(String nic) throws PawnException;
}
