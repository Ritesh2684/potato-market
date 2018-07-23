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
	
	@RequestMapping(method = RequestMethod.POST, value="/addPotatoBag")
	@ResponseStatus(HttpStatus.CREATED)
	public PotatoBag addPotatoBag(@RequestBody @Valid PotatoBag potatoBag) throws PotatoMarketException{	
		
		PotatoBag potatoBagCreated = potatoMarketService.addPotatoBag(potatoBag);
		logger.info("Bag Successfully added" + potatoBagCreated.toString());
		return potatoBagCreated;
		
	}
	
	@GetMapping(value="/getPotatoBagById/{bagId}")
	public PotatoBag getPotatoBagById(@PathVariable("bagId") Long bagId) throws PotatoMarketException{
		return potatoMarketService.getPotatoBagById(bagId);		
	}
	
	@DeleteMapping(value="/deletePotatoBagById/{bagId}")
	public void deletePotatoBagById(@PathVariable("bagId") Long bagId){		
		potatoMarketService.deletePotatoBagById(bagId);	
	}
	
	@GetMapping(value="/getListOfAllPotatoBags")
	public List<PotatoBag> getListOfAllPotatoBags() throws PotatoMarketException{		
		return potatoMarketService.getListOfAllPotatoBags();		
	}
	
	@GetMapping(value= {"/getListOfPotatoBags" , "/getListOfPotatoBags/{numberOfBags}" })
	public List<PotatoBag> getListOfPotatoBags(@PathVariable(name = "numberOfBags", required = false) Optional<Integer> numberOfBags) throws PotatoMarketException{
		List<PotatoBag> potatoBagList;
		
		if(numberOfBags.isPresent()) {
			potatoBagList = potatoMarketService.getListOfPotatoBags(numberOfBags.get());
		}else {
			potatoBagList = potatoMarketService.getListOfPotatoBags(Integer.parseInt(potatoMarketConfig.getDefaultNumberOfBags()));
		}
		
		return potatoBagList;
				
	}

}
