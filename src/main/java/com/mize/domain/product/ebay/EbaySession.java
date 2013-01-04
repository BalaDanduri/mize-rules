package com.mize.domain.product.ebay;

public class EbaySession {
	private String sessionId;
	private String returnURL;
	
	
	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public String getReturnURL() {
		return returnURL;
	}


	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((returnURL == null) ? 0 : returnURL.hashCode());
		result = prime * result
				+ ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EbaySession other = (EbaySession) obj;
		if (returnURL == null) {
			if (other.returnURL != null)
				return false;
		} else if (!returnURL.equals(other.returnURL))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EbaySession [sessionId=" + sessionId + ", returnURL="
				+ returnURL + "]";
	}
	
	
}
