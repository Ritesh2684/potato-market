package com.market.potato.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;
import com.market.potato.implementation.PotatoMarketServiceImplementation;
import com.market.potato.repository.PotatoMarketRepository;
import com.market.potato.utils.PotatoMarketHelper;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PotatoMarketControllerTest {
	
	/** Json object mapper instance. */
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	
	@Autowired
	PotatoMarketServiceImplementation potatoMarketService;
	@Mock
	PotatoMarketRepository potatoMarketRepository;

	@Test
	public void addPotatoBag() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag.json").getFile());
	    JsonNode request = null;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Topic name is required", e);
	    }
		PotatoBag potatoBagCreated = potatoMarketService.addPotatoBag(potatoBag);
		assertThat(potatoBagCreated).isNotNull();
	}
	
	@Test
	public void getListOfPotatoBags1() throws Exception {		
		
		for(int i=0; i<=5; i++) {
			addPotatoBag();
		}
		List<PotatoBag> listOfPotatoBags = potatoMarketService.getListOfPotatoBags(3);
		assertThat(listOfPotatoBags.size()).isEqualTo(3);
		
	}
	
	@Test
	public void getListOfPotatoBags2() throws Exception {		
		
		for(int i=0; i<=5; i++) {
			addPotatoBag();
		}
		List<PotatoBag> listOfPotatoBags = potatoMarketService.getListOfPotatoBags(2);
		assertThat(listOfPotatoBags.size()).isEqualTo(2);
		
	}

}
