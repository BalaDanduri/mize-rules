package com.mize.domain.jpa;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.ResultSetIdentifierConsumer;
import org.hibernate.usertype.UserType;

import com.mize.domain.common.Number;

public class NumberJPA implements UserType, ResultSetIdentifierConsumer {
		
	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		return arg0;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		return (Serializable) arg0;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		if(arg0 == null && arg1 == null){
			return true;
		}else if(arg0 != null && arg1 != null){
			return arg0.equals(arg1);
		}
		return false;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		if(arg0 != null){
			return arg0.hashCode();
		}else{
			return 0;
		}
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		return arg0;
	}

	@Override
	public Class<Number> returnedClass() {		
		return Number.class;
	}

	@Override
	public int[] sqlTypes() {
		 return new int[] {Types.BIGINT};
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,SessionImplementor session, Object owner) throws HibernateException, SQLException {
		Long baseValue = rs.getLong(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		Number number = null;
		if(baseValue != null){
			number = Number.getInstance(baseValue);
		}
		return number;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor session) throws HibernateException, SQLException {
		Long baseValue = null;
		if(value != null){
			baseValue = ((Number)value).getBaseValue();
		}
		st.setLong(index, baseValue);
	}
	
	@Override
	public Serializable consumeIdentifier(ResultSet resultSet){
		try {
			Number number = Number.getInstance(resultSet.getLong(1));
			return number;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}