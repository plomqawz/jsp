package com.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	// DB 연결 : public static
	public static Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env"); //가상의 폴더에서 찾아옴.
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp"); // 임의 이름등록해서 찾음.
		return ds.getConnection();
	}
}
