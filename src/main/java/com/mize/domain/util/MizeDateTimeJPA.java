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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;

public class MizeDateTimeJPA implements UserType{
	
	private static MizeApplicationProperties mizeApplicationProperties;
	@Autowired
	public void setMizeApplicationProperties(MizeApplicationProperties mizeApplicationProperties) {
		MizeDateTimeJPA.mizeApplicationProperties = mizeApplicationProperties;
	}
	
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
		DateTimeZone dateTimeZone = DateTimeZone.forID(mizeApplicationProperties.getDefaultTimeZone());
        DateTime dateTime = new DateTime(timestamp, dateTimeZone);
        return MizeDateTime.getInstance(dateTime);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor session) throws HibernateException, SQLException {
		st.setString(index,Formatter.getDBDateTime((MizeDateTime)value));
		
	}


}
