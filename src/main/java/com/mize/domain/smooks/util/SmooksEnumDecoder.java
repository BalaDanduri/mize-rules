package com.mize.domain.smooks.util;

import org.milyn.javabean.DataDecodeException;
import org.milyn.javabean.DataDecoder;

import com.mize.domain.servicelocator.BusinessEntity;

public class SmooksEnumDecoder implements DataDecoder{

	private static final long serialVersionUID = -2857487602735806071L;
	
	@Override
	public Object decode(String data)throws DataDecodeException{
		BusinessEntity.TypeCode typeCode = null;
		if(data != null){
			try{
				typeCode = BusinessEntity.TypeCode.valueOf(data);
			}catch(Exception e){				
			}
		}		
		return typeCode;
	}
}
