package com.mize.domain.common;

public class BusinessRule extends MizeSceEntity{
	private static final long serialVersionUID = 6704968972378606177L;
	private String ruleFileName;
	
	public BusinessRule(){
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getRuleFileName() {
		return ruleFileName;
	}

	public void setRuleFileName(String ruleFileName) {
		this.ruleFileName = ruleFileName;
	}

	@Override
	public String toString() {
		return "BusinessRule [ruleFileName=" + ruleFileName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((ruleFileName == null) ? 0 : ruleFileName.hashCode());
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
		BusinessRule other = (BusinessRule) obj;
		if (ruleFileName == null) {
			if (other.ruleFileName != null)
				return false;
		} else if (!ruleFileName.equals(other.ruleFileName))
			return false;
		return true;
	}

	
	

}
