package com.mize.domain.common;

public class State extends MizeEntity implements Comparable<State>{
	
	private static final long serialVersionUID = -1518811417788517045L;
	private String name;
	private String code;
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	@Deprecated
	public Long getStateId() {
		return id;
	}

	@Deprecated
	public void setStateId(Long id) {
		this.id = id;
	}	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Deprecated
	public String getStateName() {
		return name;
	}
	
	@Deprecated
	public void setStateName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
	
	@Deprecated
	public String getStateCode() {
		return code;
	}
	
	@Deprecated
	public void setStateCode(String code) {
		this.code = code;
	}
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((code == null) ? 0 : code.hashCode());
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
		State other = (State) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "State [name=" + name + ", code=" + code + ", id=" + id + "]";
	}
	
	public int compareTo(State state) {
		if ( this == state ) 
			return EQUAL;
		else if (this.id < state.id) 
			return BEFORE;
		else if (state.id == this.id) 
			return EQUAL;
		else if (this.id > state.id)
			return AFTER;
		return EQUAL;		
	}
	
}
