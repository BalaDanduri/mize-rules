package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ProductFeedback extends MizeEntity implements Comparable<ProductFeedback>{	
	private static final long serialVersionUID = -2093598764541271160L;
	private String feedback;
	private String feebackTitle;
	private Integer rating;
	private User user;
	private UserProductFeedbackReviews review;
	private List<UserComment> comments= new ArrayList<UserComment>();
    private Integer countOfComments;
    private Integer countOfThumbsUp;
	private Integer countOfThumbsDown;
    private Integer countOfSpam;
    
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
           this.id= id;		
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getFeebackTitle() {
		return feebackTitle;
	}

	public void setFeebackTitle(String feebackTitle) {
		this.feebackTitle = feebackTitle;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProductFeedbackReviews getReview() {
		return review;
	}

	public void setReview(UserProductFeedbackReviews review) {
		this.review = review;
	}

	public Integer getCountOfComments() {
		return countOfComments;
	}

	public void setCountOfComments(Integer countOfComments) {
		this.countOfComments = countOfComments;
	}
    
	public Integer getCountOfThumbsUp() {
		return countOfThumbsUp;
	}

	public void setCountOfThumbsUp(Integer countOfThumbsUp) {
		this.countOfThumbsUp = countOfThumbsUp;
	}

	public Integer getCountOfThumbsDown() {
		return countOfThumbsDown;
	}

	public void setCountOfThumbsDown(Integer countOfThumbsDown) {
		this.countOfThumbsDown = countOfThumbsDown;
	}

	public Integer getCountOfSpam() {
		return countOfSpam;
	}

	public void setCountOfSpam(Integer countOfSpam) {
		this.countOfSpam = countOfSpam;
	}
	

	@Column(name = "created_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Override
	public int compareTo(ProductFeedback arg0) {
		return 0;
	}

	public List<UserComment> getComments() {
		return comments;
	}

	public void setComments(List<UserComment> comments) {
		this.comments = comments;
	}

	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	public String toString() {
		return "ProductFeedback [feedback=" + feedback + ", feebackTitle="
				+ feebackTitle + ", rating=" + rating + ", user=" + user
				+ ", review=" + review + ", comments=" + comments
				+ ", countOfComments=" + countOfComments + ", countOfThumbsUp="
				+ countOfThumbsUp + ", countOfThumbsDown=" + countOfThumbsDown
				+ ", countOfSpam=" + countOfSpam + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((countOfComments == null) ? 0 : countOfComments.hashCode());
		result = prime * result
				+ ((countOfSpam == null) ? 0 : countOfSpam.hashCode());
		result = prime
				* result
				+ ((countOfThumbsDown == null) ? 0 : countOfThumbsDown
						.hashCode());
		result = prime * result
				+ ((countOfThumbsUp == null) ? 0 : countOfThumbsUp.hashCode());
		result = prime * result
				+ ((feebackTitle == null) ? 0 : feebackTitle.hashCode());
		result = prime * result
				+ ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductFeedback other = (ProductFeedback) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (countOfComments == null) {
			if (other.countOfComments != null)
				return false;
		} else if (!countOfComments.equals(other.countOfComments))
			return false;
		if (countOfSpam == null) {
			if (other.countOfSpam != null)
				return false;
		} else if (!countOfSpam.equals(other.countOfSpam))
			return false;
		if (countOfThumbsDown == null) {
			if (other.countOfThumbsDown != null)
				return false;
		} else if (!countOfThumbsDown.equals(other.countOfThumbsDown))
			return false;
		if (countOfThumbsUp == null) {
			if (other.countOfThumbsUp != null)
				return false;
		} else if (!countOfThumbsUp.equals(other.countOfThumbsUp))
			return false;
		if (feebackTitle == null) {
			if (other.feebackTitle != null)
				return false;
		} else if (!feebackTitle.equals(other.feebackTitle))
			return false;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
