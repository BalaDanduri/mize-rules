package com.mize.domain.common;

public class State {
	
	private int stateId;
	private String stateName;
	private String stateCode;
	
	public State(){
		
	}
	public State(int stateId, String stateName, String stateCode) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateCode = stateCode;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStareCode() {
		return stateCode;
	}
	public void setStareCode(String stareCode) {
		this.stateCode = stareCode;
	}
	
}
