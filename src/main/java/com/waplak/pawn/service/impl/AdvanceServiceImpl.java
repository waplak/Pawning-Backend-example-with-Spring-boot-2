package com.waplak.pawn.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waplak.pawn.common.GsonUtil;
import com.waplak.pawn.config.AppErrorConfig;
import com.waplak.pawn.entity.AdvanceHeader;
import com.waplak.pawn.repository.AdvanceRepo;
import com.waplak.pawn.request.AdvanceRequest;
import com.waplak.pawn.response.AdvanceResponse;
import com.waplak.pawn.response.NicResponse;
import com.waplak.pawn.service.AdvanceService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdvanceServiceImpl implements AdvanceService {

	private Logger logger;
	@Autowired
	private AppErrorConfig appErrorConfig;

	@Autowired
	private AdvanceRepo advanceRepo;

	public AdvanceServiceImpl() {
		this.logger = LoggerFactory.getLogger(this.getClass());

	}

	@Override
	public AdvanceResponse saveAdvance(AdvanceRequest request) {
		logger.info("Start service save Advance{}", GsonUtil.getToString(request, AdvanceRequest.class));
		return buildResponse(advanceRepo.save(buildEntity(new AdvanceHeader(), request)));

	}

	private AdvanceHeader buildEntity(AdvanceHeader advHeader, AdvanceRequest request) {
		long rowCount = advanceRepo.count();
		advHeader.setSerialNumber(String.format("%06d", ++rowCount));
		advHeader.setNic(request.getNic());
		advHeader.setCustFirstName(request.getCustFirstName());
		advHeader.setCustLastName(request.getCustLastName());
		advHeader.setAddressLine1(request.getAddressLine1());
		advHeader.setAddressLine2(request.getAddressLine2());
		advHeader.setAddressLine3(request.getAddressLine3());
		advHeader.setKaratCode(request.getKaratCode());
		advHeader.setBranchId(request.getBranchId());
		advHeader.setTotFullWeight(request.getTotFullWeight());
		advHeader.setTotNetWeight(request.getTotNetWeight());
		return advHeader;
	}

	private AdvanceResponse buildResponse(AdvanceHeader advHeader) {
		return AdvanceResponse.builder().serialNumber(advHeader.getSerialNumber()).build();

	}

	@Override
	public NicResponse getByNic(String nic) throws Exception{
		AdvanceHeader advHeader =  advanceRepo.findByNic(nic);
		if (advHeader!=null) {
			return NicResponse.builder()
					.serialNumber(advHeader.getSerialNumber())
					.custFirstName(advHeader.getCustFirstName())
					.custLastName(advHeader.getCustLastName()).build();
		}
		throw new Exception(appErrorConfig.getNotExist());
		
	}
}
