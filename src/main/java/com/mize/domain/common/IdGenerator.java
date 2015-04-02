package com.mize.domain.common;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentifierGeneratorHelper;

public class IdGenerator implements IdentifierGenerator {

	   // private static Logger log = Logger.getLogger(IdGenerator.class);

	    @SuppressWarnings("unused")
		public Serializable generate(SessionImplementor session, Object object)
	            throws HibernateException {

	        Connection connection = session.connection();
	        try {
	           /* PreparedStatement ps = connection .prepareStatement("SELECT nextval ('id') as nextval");
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                long id = rs.getLong(1);
	               // String code = prefix + StringUtils.leftPad("" + id,3, '0');
	               // log.debug("Generated Stock Code: " + code);
	                //return code;
	            }*/

	        } catch (Exception e) {
	           // log.error(e);
	            throw new HibernateException(
	                    "Unable to generate Stock Code Sequence");
	        }
	        return IdentifierGeneratorHelper.POST_INSERT_INDICATOR;
	    }
	}
