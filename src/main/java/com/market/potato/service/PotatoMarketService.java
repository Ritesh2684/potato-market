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
	
	/**
	 * This method adds Potato bag to the store
	 * @param potatoBag object of potato bag
	 * @return PotatoBag object created
	 * @throws PotatoMarketException
	 */
	public PotatoBag addPotatoBag(PotatoBag potatoBag) throws PotatoMarketException;
	
	/**
	 * This method retrieves Potato bag by id	
	 * @param Id id of the potato bag
	 * @return PotatoBag Object of potato bag
	 * @throws PotatoMarketException
	 */
	public PotatoBag getPotatoBagById(Long Id) throws PotatoMarketException;
	
	/**
	 * This method delete the object of potato bag by id.
	 * @param bagId id of the potato bag
	 */
	public void deletePotatoBagById(Long bagId);
	
	/**
	 * This method retrieves list of all the potato bags in the store.
	 * @return List<PotatoBag>
	 * @throws PotatoMarketException
	 */
	public List<PotatoBag> getListOfAllPotatoBags() throws PotatoMarketException;
	
	/**
	 * This method retrievs the specified number of Potato bags
	 * @param numberOfBags number of potato bags to be retrieved
	 * @return List<PotatoBag>
	 */
	public List<PotatoBag> getListOfPotatoBags(int numberOfBags);
	

}
