package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;

public class ProductImage {
	private String imageType;
	private String url;
	private Map<String,Dimension> dimensions;
	
	
	public ProductImage(String imageType, String url, Map<String, Dimension> dimensions) {
		super();
		this.imageType = imageType;
		this.url = url;
		this.dimensions = dimensions;
	}
	public enum ImageType{
		SwatchImage,SmallImage,ThumbnailImage,TinyImage,MediumImage,LargeImage;
	}
	public ProductImage(){
		dimensions = new  HashMap<String,Dimension>();	
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, Dimension> getDimensions() {
		return dimensions;
	}
	public void setDimensions(Map<String, Dimension> dimensions) {
		this.dimensions = dimensions;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
		
}
