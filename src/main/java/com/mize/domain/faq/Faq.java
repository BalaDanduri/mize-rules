package com.mize.domain.faq;

import com.mize.domain.common.Entity;

public class Faq extends Entity{
	private static final long serialVersionUID = 5713977396952999898L;
	private String brandName;
	private String productName;
	private Long seqNo;
	private String question;
	private String answer;
	private int pageIndex;
	private Integer count;
	private String videoName;
	private String videoLink;

	
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Faq [brandName=" + brandName + ", productName=" + productName + ", seqNo=" + seqNo + ", question="
				+ question + ", answer=" + answer + ", pageIndex=" + pageIndex + ", count=" + count + ", videoName="
				+ videoName + ", videoLink=" + videoLink + "]";
	}
	
	
}
