package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;

public class ProductImage {
	private String imageType;
	private String url;
	private Map<String,Dimention> dimentions;
	
	
	public ProductImage(String imageType, String url, Map<String, Dimention> dimentions) {
		super();
		this.imageType = imageType;
		this.url = url;
		this.dimentions = dimentions;
	}
	public enum ImageType{
		SwatchImage,SmallImage,ThumbnailImage,TinyImage,MediumImage,LargeImage;
	}
	public ProductImage(){
		dimentions = new  HashMap<String,Dimention>();	
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, Dimention> getDimentions() {
		return dimentions;
	}
	public void setDimentions(Map<String, Dimention> dimentions) {
		this.dimentions = dimentions;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
		
}
