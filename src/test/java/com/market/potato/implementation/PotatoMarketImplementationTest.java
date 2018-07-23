package com.market.potato.implementation;

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
import com.market.potato.repository.PotatoMarketRepository;
import com.market.potato.utils.PotatoMarketHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PotatoMarketImplementationTest {

	@Mock
	PotatoMarketRepository potatoMarketRepository;
	
	/** Json object mapper instance. */
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	
	@Test
	public void addPotatoBag() throws Exception {
		
		PotatoBag potatoBag = null;
		ClassLoader classLoader = getClass().getClassLoader();
		
	    File file = new File(classLoader.getResource("com/market/potato/request-potatobag.json").getFile());
	    JsonNode request = null;
	    PotatoBag potatoBagCreated;
	    try {
	    	request = PotatoMarketHelper.getJsonNodeFromFile(file);
	    	potatoBag = JSON_MAPPER.treeToValue(request, PotatoBag.class);
	    	potatoBag.setPackageTimestamp(LocalDateTime.now());
	    	potatoBag.setBagId(new Random().nextLong());
	    	potatoBagCreated = potatoMarketRepository.save(potatoBag);
	    	
	    }catch (PotatoMarketException e) {
	        assertNotNull("Potato Bag is required", e);
	    }
		
		assertThat(potatoBag).isNotNull();
	}

	
	
}
