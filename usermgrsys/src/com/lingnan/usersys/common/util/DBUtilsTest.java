package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
/**
 * DBUtils的测试类
 */
public class DBUtilsTest {

	@Test
	/**
	 * 测试DBUtils里面的getConnection方法
	 */
	public void testGetConnection() {
		Connection conn=null;
		conn=DBUtils.getConnection();
		System.out.println(conn);
	}

}
