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

public class DateTimeJPA implements UserType{

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

	public Object nullSafeGet(ResultSet arg0, String[] arg1, Object arg2) throws HibernateException, SQLException {
		Timestamp timestamp = arg0.getTimestamp(arg1[0]);
        if (arg0.wasNull()) {
            return null;
        }
        return new DateTime(timestamp);
	}

	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2) throws HibernateException, SQLException {
		arg0.setString(arg2,Formatter.getDBDateTime((DateTime)arg1));
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {		
		return DateTime.class;
	}

	@Override
	public int[] sqlTypes() {
		 return new int[] {Types.TIMESTAMP};
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1,SessionImplementor arg2, Object arg3) throws HibernateException, SQLException {
		Timestamp timestamp = arg0.getTimestamp(arg1[0]);
        if (arg0.wasNull()) {
            return null;
        }
        return new DateTime(timestamp);
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,SessionImplementor arg3) throws HibernateException, SQLException {
		arg0.setString(arg2,Formatter.getDBDateTime((DateTime)arg1));
		
	}

}
