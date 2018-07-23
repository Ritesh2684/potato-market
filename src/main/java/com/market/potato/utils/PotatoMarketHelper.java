/**
 * 
 */
package com.market.potato.utils;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;
import com.market.potato.implementation.PotatoMarketServiceImplementation;

/**
 * @author ritesh
 *
 */
public final class PotatoMarketHelper {
	
	/** Json object mapper instance. */
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	  
	final static Logger logger = LoggerFactory.getLogger(PotatoMarketServiceImplementation.class);
	
	/**
	 * This method creates Json object from the file
	 * @param file
	 * @return JsonNode
	 * @throws PotatoMarketException
	 */
	public static JsonNode getJsonNodeFromFile(File file) throws PotatoMarketException {
	    
		String method = "getJsonNodeFromByteArray";
	    logger.info("Start of method" + method);
	    JsonNode node = null;
	    try {
	      node = JSON_MAPPER.readValue(file, JsonNode.class);	      
	      
	    } catch (JsonProcessingException e) {
	    	logger.debug(e.getMessage());
	    	throw new PotatoMarketException("Json cannot be parsed");
	    } catch (IOException e) {
	    	logger.debug(e.getMessage());
	    	throw new PotatoMarketException("Error while reading File");
	    }
	    
	    logger.info("End of method" + method);

	    return node;
	  }
	
	/**
	 * This method validates the Potato bag object for specified validations
	 * @param potatoBag PotatoBag
	 * @throws PotatoMarketException
	 */
	public static void validatePotatoBag(PotatoBag potatoBag) throws PotatoMarketException{
		String method = "validatePotatoBag";
	    logger.info("Start of method" + method);    
	    isValidNumberOfPotatoes(potatoBag.getNumberOfPotatos());
	    isValidPrice(potatoBag.getPrice());
	    logger.info("End of method" + method);
		
	}
	
	/**
	 * This method validates if the Price is between 1 & 50
	 * @param price price of the potato bag
	 * @throws PotatoMarketException
	 */
	public static void isValidPrice(double price) throws PotatoMarketException {
		String method = "isValidPrice";
	    logger.info("Start of method" + method);
	    
	    if(!(price>=1 && price<=50)) {
	    	throw new PotatoMarketException("Potato Bag price should be between 1 and 50");
	    }  
	    
	    logger.info("End of method" + method);
		
	}
	
	/**
	 * This method validates if the number of potatoes in the bag is between 1 and 100
	 * @param numberOfPotatoes
	 * @throws PotatoMarketException
	 */
	public static void isValidNumberOfPotatoes(int numberOfPotatoes) throws PotatoMarketException {
		String method = "isValidNumberOfPotatoes";
	    
		logger.info("Start of method" + method);
	    
	    if(!(numberOfPotatoes>=1 && numberOfPotatoes<=100)) {
	    	throw new PotatoMarketException("Number of Potatos in the Bag should be between 1 and 100");
	    }  
	    
	    logger.info("End of method" + method);
		
	}
	

}
