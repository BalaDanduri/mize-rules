package com.mize.domain.product;

import java.util.List;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;

public class ProdAverageCalculation extends MizeEntity implements Comparable<ProdAverageCalculation> {

	private static final long serialVersionUID = 5514877109183117116L;
	private Long productId;
	private Integer rating;
	private Integer count;
	private String listName;
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public int compareTo(ProdAverageCalculation o) {
		return 0;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	
	
	@Override
	public String toString() {
		return "ProdAverageCalculation [productId=" + productId + ", rating="
				+ rating + ", count=" + count + ", listName=" + listName + "]";
	}
	
	public static ProductRatingSummary getRatingSummary(List<ProdAverageCalculation> list,Long prodId){
		ProductRatingSummary summary = new ProductRatingSummary();
		summary.setProductId(prodId);
		if (Formatter.size(list) > 0 ) {
			for (ProdAverageCalculation prodRating : list) {				
				int rating = prodRating.getRating().intValue();
				switch (rating) {
				case 1:
					summary.setRating1Count(prodRating.getCount());
					break;
				case 2:
					summary.setRating2Count(prodRating.getCount());
					break;
				case 3:
					summary.setRating3Count(prodRating.getCount());
					break;
				case 4:
					summary.setRating4Count(prodRating.getCount());
					break;
				case 5:
					summary.setRating5Count(prodRating.getCount());
					break;
				}
			}
		}
		return summary;
	}	
	
	public static void populateListNamesCount(List<ProdAverageCalculation> list,ProductRatingSummary summary){			
		if (Formatter.size(list) > 0 ) {
			for (ProdAverageCalculation prodRating : list) {				
				if (prodRating.getListName() != null) {
					if (prodRating.getListName().equalsIgnoreCase(UserProduct.Wownit.own.toString())) {
						summary.setCountOwn(prodRating.getCount());
					}
					if (prodRating.getListName().equalsIgnoreCase(UserProduct.Wownit.want.toString())) {
						summary.setCountWant(prodRating.getCount());
					}
					if (prodRating.getListName().equalsIgnoreCase(UserProduct.Wownit.gift.toString())) {
						summary.setCountGift(prodRating.getCount());
					}
				}
			}
		}		
		long feedbackCount = summary.getRating1Count()
				+ summary.getRating2Count() + summary.getRating3Count()
				+ summary.getRating4Count() + summary.getRating5Count();
		long sumOfRating =  summary.getRating1Count() 
				+ (2 * summary.getRating2Count())
				+ (3 * summary.getRating3Count())
				+ (4 * summary.getRating4Count())
				+ (5 * summary.getRating5Count());
		if(sumOfRating != 0 && feedbackCount != 0){
			double average = Double.valueOf(sumOfRating)/feedbackCount;
			summary.setRating(Formatter.formattedDouble(average));
		}else{
			summary.setRating(null);
		}
	}
}
