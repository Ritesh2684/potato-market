/**
 * 
 */
package com.market.potato.data;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author AG0226
 *
 */

public class PotatoBag extends ResourceSupport{
	
	@Id
	private Long bagId;
	
	@Min(1)
	@Max(100)
	private int numberOfPotatos;
	
	private Supplier supplier;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime packageTimestamp;
	
	@Min(1)
	@Max(50)
	private double price;

	public Long getBagId() {
		return bagId;
	}

	public void setBagId(Long bagId) {
		this.bagId = bagId;
	}

	public int getNumberOfPotatos() {
		return numberOfPotatos;
	}

	public void setNumberOfPotatos(int numberOfPotatos) {
		this.numberOfPotatos = numberOfPotatos;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public LocalDateTime getPackageTimestamp() {
		return packageTimestamp;
	}

	public void setPackageTimestamp(LocalDateTime packageTimestamp) {
		this.packageTimestamp = packageTimestamp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PotatoBag [bagId=" + bagId + ", numberOfPotatos=" + numberOfPotatos + ", supplier=" + supplier
				+ ", packageTimestamp=" + packageTimestamp + ", price=" + price + "]";
	}

	public PotatoBag(Long bagId, @Min(1) @Max(100) int numberOfPotatos, Supplier supplier, LocalDateTime packageTimestamp,
			@Min(1) @Max(50) double price) {
		super();
		this.bagId = bagId;
		this.numberOfPotatos = numberOfPotatos;
		this.supplier = supplier;
		this.packageTimestamp = packageTimestamp;
		this.price = price;
	}

	public PotatoBag() {
		super();
	}	
	
	

	

}
