package com.market.potato.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PotatoMarketConfig {
	
	@Value("${potato.numberOfBags.default}")
	private String defaultNumberOfBags;

	public String getDefaultNumberOfBags() {
		return defaultNumberOfBags;
	}
	
}
