/**
 * 
 */
package com.market.potato.implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;
import com.market.potato.repository.PotatoMarketRepository;
import com.market.potato.service.PotatoMarketService;

/**
 * @author ritesh
 *
 */
@Service
public class PotatoMarketServiceImplementation implements PotatoMarketService {
	
	final Logger logger = LoggerFactory.getLogger(PotatoMarketServiceImplementation.class);
	
	@Autowired
	PotatoMarketRepository potatoMarketRepository;
	
	public PotatoBag addPotatoBag(PotatoBag potatoBag) {
		logger.info(potatoBag.toString());
		logger.debug(potatoBag.toString());
		return potatoMarketRepository.save(potatoBag);
	}
	
	public PotatoBag getPotatoBagById(Long Id) throws PotatoMarketException {
		Optional<PotatoBag> optionalPotatoBag = potatoMarketRepository.findById(Id);
		if(null != optionalPotatoBag.get()) {
			return optionalPotatoBag.get();
		}else {
			throw new PotatoMarketException("No PotatoBag found with given ID");
		}
	}
	
	public void deletePotatoBagById(Long bagId) {
		potatoMarketRepository.deleteById(bagId);
		logger.info("Potato Bag successfully deleted");
	}
	
	public List<PotatoBag> getListOfAllPotatoBags() throws PotatoMarketException {
		List<PotatoBag> potatoBagList = potatoMarketRepository.findAll();
		return potatoBagList;
	}
	
	public List<PotatoBag> getListOfPotatoBags(int numberOfBags) {
		Page<PotatoBag> pagePpotatoBag = potatoMarketRepository.findAll(new PageRequest(0, numberOfBags));
		return pagePpotatoBag.getContent();
	} 
	

}
