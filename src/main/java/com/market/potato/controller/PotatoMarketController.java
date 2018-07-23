/**
 * 
 */
package com.market.potato.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;
import com.market.potato.implementation.PotatoMarketServiceImplementation;
import com.market.potato.utils.PotatoMarketConfig;

/**
 * @author ritesh
 *
 */
@RestController
@RequestMapping("/market")
@CrossOrigin
public class PotatoMarketController {	
	
	final Logger logger = LoggerFactory.getLogger(PotatoMarketController.class);
	
	@Autowired
	PotatoMarketServiceImplementation potatoMarketService;
	
	@Autowired
	PotatoMarketConfig potatoMarketConfig;
	
	/**
	 * This end point adds potato bag to the store.
	 * @param potatoBag
	 * @return potatoBag PotatoBag
	 * @throws PotatoMarketException
	 */
	@RequestMapping(method = RequestMethod.POST, value="/addPotatoBag")
	@ResponseStatus(HttpStatus.CREATED)
	public PotatoBag addPotatoBag(@RequestBody @Valid PotatoBag potatoBag) throws PotatoMarketException{
		String method = "addPotatoBag";
		logger.info("Start of method" + method);
		
		PotatoBag potatoBagCreated = potatoMarketService.addPotatoBag(potatoBag);
		logger.info("Bag Successfully added" + potatoBagCreated.toString());
		
		logger.info("End of method" + method);
		
		return potatoBagCreated;
		
	}
	
	/**
	 * This end point gets potato bag by id
	 * @param bagId id of the potato bag
	 * @return PotatoBag 
	 * @throws PotatoMarketException
	 */
	@GetMapping(value="/getPotatoBagById/{bagId}")
	public PotatoBag getPotatoBagById(@PathVariable("bagId") Long bagId) throws PotatoMarketException{
		
		return potatoMarketService.getPotatoBagById(bagId);	
		
	}
	
	/**
	 * This end point deletes the potoato bag from the store based on badId
	 * @param bagId Id of the potato bag
	 */
	@DeleteMapping(value="/deletePotatoBagById/{bagId}")
	public void deletePotatoBagById(@PathVariable("bagId") Long bagId){		
		potatoMarketService.deletePotatoBagById(bagId);	
	}
	
	/**
	 * This method returns list of all the potato bags in the store
	 * @return List<PotatoBag> list of potatobags in the store
	 * @throws PotatoMarketException
	 */
	@GetMapping(value="/getListOfAllPotatoBags")
	public List<PotatoBag> getListOfAllPotatoBags() throws PotatoMarketException{		
		return potatoMarketService.getListOfAllPotatoBags();		
	}
	
	/**
	 * This method has two end points with optional value of number of bags. If specified number of bags returned will be equal to the list of specified value else
	 * it will return 3 bags by default
	 * @param numberOfBags number of bags to be fetched.
	 * @return List<PotatoBag> list of potato bags
	 * @throws PotatoMarketException
	 */
	@GetMapping(value= {"/getListOfPotatoBags" , "/getListOfPotatoBags/{numberOfBags}" })
	public List<PotatoBag> getListOfPotatoBags(@PathVariable(name = "numberOfBags", required = false) Optional<Integer> numberOfBags) throws PotatoMarketException{
		
		String method = "getListOfPotatoBags";
		
		logger.info("Start of method" + method);
		
		List<PotatoBag> potatoBagList;
		
		if(numberOfBags.isPresent()) {
			potatoBagList = potatoMarketService.getListOfPotatoBags(numberOfBags.get());
		}else {
			potatoBagList = potatoMarketService.getListOfPotatoBags(Integer.parseInt(potatoMarketConfig.getDefaultNumberOfBags()));
		}
		
		logger.info("End of method" + method);
		
		return potatoBagList;
				
	}

}
 