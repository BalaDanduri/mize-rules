package com.mize.domain.util;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class MizeDateTimeJPA implements UserType{
		
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
	public Class<MizeDateTime> returnedClass() {		
		return MizeDateTime.class;
	}

	@Override
	public int[] sqlTypes() {
		 return new int[] {Types.TIMESTAMP};
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,SessionImplementor session, Object owner) throws HibernateException, SQLException {
		Timestamp timestamp = rs.getTimestamp(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		String datetime =  MizeDateTimeUtils.getMizeDateTimeAsString(timestamp);
		MizeDateTime mizeDateTime = MizeDateTime.getInstance(datetime,MizeDateTimeUtils.getDateTimeFormat(),MizeDateTimeUtils.getDefaultDateTimeZone());
		return mizeDateTime;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor session) throws HibernateException, SQLException {
		String dateTimeValue = MizeDateTimeUtils.getDBDateTime((MizeDateTime)value);
		st.setString(index, dateTimeValue);
	}

}
