package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
/**
 * DBUtils�Ĳ�����
 */
public class DBUtilsTest {

	@Test
	/**
	 * ����DBUtils�����getConnection����
	 */
	public void testGetConnection() {
		Connection conn=null;
		conn=DBUtils.getConnection();
		System.out.println(conn);
	}

}
