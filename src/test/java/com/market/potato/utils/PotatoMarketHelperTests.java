package com.market.potato.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PotatoMarketHelperTests {
	
	/** Json object mapper instance. */
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	
	@Test
	public void isValidMinPrice() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-3.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidPrice(potatoBag.getPrice());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isValidMaxPrice() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-4.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidPrice(potatoBag.getPrice());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isNotValidMaxPrice() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-5.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidPrice(potatoBag.getPrice());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Max price is not valid", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isNotValidMinPrice() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-6.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidPrice(potatoBag.getPrice());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Max price is not valid", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isValidMaxNumberOfPotatoes() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-1.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidNumberOfPotatoes(potatoBag.getNumberOfPotatos());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isNotValidMaxNumberOfPotatoes() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-7.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidNumberOfPotatoes(potatoBag.getNumberOfPotatos());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Max number of Potatoes should be less than 100", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void isValidMinNumberOfPotatoes() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag-2.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.isValidNumberOfPotatoes(potatoBag.getNumberOfPotatos());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	@Test
	public void validatePotatoBag() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	PotatoMarketHelper.validatePotatoBag(potatoBag);
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		assertThat(potatoBag).isNotNull();
	}
	
	

	
	


}
