package com.waplak.pawn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@Data
@PropertySource("classpath:app.properties")
public class AppErrorConfig {

	@Value("${error.create}")
	private String create;
	@Value("${error.by-nic}")
	private String byNic;
	@Value("${error.not-exist}")
	private String notExist;
}
