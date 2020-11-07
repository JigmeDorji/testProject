package com.test.srv.helper;

import org.hibernate.dialect.MySQL5Dialect;

import java.sql.Types;

/**
 * Created by USER on 10/14/2019.
 */
public class MySQLCustomDialect extends MySQL5Dialect {
    public MySQLCustomDialect() {
        super();
        registerHibernateType(-9, "string");
        registerHibernateType(Types.NULL, "string");
    }
}

