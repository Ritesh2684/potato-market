/**
 * 
 */
package com.market.potato.service;

import java.util.List;

import com.market.potato.data.PotatoBag;
import com.market.potato.exception.PotatoMarketException;

/**
 * @author ritesh
 *
 */

public interface PotatoMarketService {
		
	public PotatoBag addPotatoBag(PotatoBag potatoBag) throws PotatoMarketException;
	
	public PotatoBag getPotatoBagById(Long Id) throws PotatoMarketException;
	
	public void deletePotatoBagById(Long bagId);
	
	public List<PotatoBag> getListOfAllPotatoBags() throws PotatoMarketException;
	
	public List<PotatoBag> getListOfPotatoBags(int numberOfBags);
	

}
