package com.mize.domain.jpa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import com.mize.domain.common.BigInteger;

public class BigIntegerJPA implements UserType {
		
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
		return 0;
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
	public Class<BigInteger> returnedClass() {		
		return BigInteger.class;
	}

	@Override
	public int[] sqlTypes() {
		 return new int[] {Types.TIMESTAMP};
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,SessionImplementor session, Object owner) throws HibernateException, SQLException {
		java.math.BigDecimal baseValue = rs.getBigDecimal(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		BigInteger bigInteger = null;
		if(baseValue != null){
			
			bigInteger = BigInteger.getInstance(java.math.BigInteger.valueOf(baseValue.longValue()));
		}
		return bigInteger;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor session) throws HibernateException, SQLException {
		java.math.BigInteger baseValue = null;
		if(value != null){
			BigInteger bigInteger = (BigInteger)value;
			if(bigInteger != null){
				baseValue = bigInteger.getBaseValue();
			}
			baseValue.longValue();
		}
		if(baseValue != null){
			st.setBigDecimal(index, BigDecimal.valueOf(baseValue.longValue()));
		}else{
			st.setBigDecimal(index, null);
		}
	}

}
