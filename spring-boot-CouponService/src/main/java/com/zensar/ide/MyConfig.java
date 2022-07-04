package com.zensar.ide;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@Component
@RefreshScope
public class MyConfig {
	@Value("${code.applicableTo}")
	private String applicableTo;

	public String getApplicableTo() {
		return applicableTo;
	}

	public void setApplicableTo(String applicableTo) {
		this.applicableTo = applicableTo;
	}
	
	
	
}
