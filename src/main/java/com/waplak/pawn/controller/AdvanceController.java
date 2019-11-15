package com.waplak.pawn.controller;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waplak.pawn.common.CommonConstantValue;
import com.waplak.pawn.common.GsonUtil;
import com.waplak.pawn.config.AppErrorConfig;
import com.waplak.pawn.exception.PawnException;
import com.waplak.pawn.request.AdvanceRequest;
import com.waplak.pawn.service.AdvanceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/advance")
public class AdvanceController {
	private Logger logger;
	@Autowired
	private AdvanceService advanceService;
	@Autowired
	private AppErrorConfig appErrorConfig;

	public AdvanceController() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}

	@ApiOperation(value = "Create Advance")
	@PostMapping
	public Map<String, Object> saveAdvanve(@RequestBody AdvanceRequest request) {
		logger.info("Start save advance controller {}", GsonUtil.getToString(request, AdvanceRequest.class));
		Map<String, Object> response = new HashMap<>();
		try {
			response.put(CommonConstantValue.STATUS, true);
			response.put(CommonConstantValue.DATA, advanceService.saveAdvance(request));
		} catch(PawnException e) {
			response.put(CommonConstantValue.STATUS, false);
			response.put(CommonConstantValue.DATA, appErrorConfig.getNotExist());
			logger.error("Add Advance {} -> {}", CommonConstantValue.STATUS_FAILED, e.getMessage());
			
		} catch (Exception e) {
			response.put(CommonConstantValue.STATUS, false);
			response.put(CommonConstantValue.DATA, appErrorConfig.getCreate());
			logger.error("Add Advance {} -> {}", CommonConstantValue.STATUS_FAILED, e.getMessage());
		}

		return response;
	}

	@ApiOperation(value = "Get User Details From NIC")
	@GetMapping(value = "/user_details/{nic}")
	public Map<String, Object> getUserDetails(
			@ApiParam(required = true, name = "nic", value = "NIC canot be Missing or Empty.") @PathVariable String nic) {
		logger.info("Get Data From NIC {}", nic);
		Map<String, Object> response = new HashMap<>();
		try {
			response.put(CommonConstantValue.STATUS, true);
			response.put(CommonConstantValue.DATA, advanceService.getByNic(nic));
		
		}catch(PawnException e) {
			response.put(CommonConstantValue.STATUS, false);
			response.put(CommonConstantValue.DATA, appErrorConfig.getNotExist());
			logger.info("Failed Get Data From NIC {}", e.getMessage());
			
		}catch (Exception e) {
			response.put("STATUS", false);
			response.put("DATA", appErrorConfig.getByNic());
			logger.info("Failed Get Data From NIC {}", e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Check Swagger")
	@GetMapping(value = "/test")
	public String getSwagerString() {

		return "welcome to swagger";
	}

}
