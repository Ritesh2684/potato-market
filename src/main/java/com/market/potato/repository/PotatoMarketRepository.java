/**
 * 
 */
package com.market.potato.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.market.potato.data.PotatoBag;

/**
 * @author ritesh
 *
 */
public interface PotatoMarketRepository extends MongoRepository<PotatoBag,Long>{
	


}
