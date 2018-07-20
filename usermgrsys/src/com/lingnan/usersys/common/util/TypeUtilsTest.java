package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
/**
 * 格式转换类的测试类
 * @author Administrator
 *
 */
public class TypeUtilsTest {

	@Test
	/**
	 * 测试TypeUtils里面的strToDate方法
	 */
	public void testStrToDate() {
		Date date=TypeUtils.strToDate("1997-03-09");
		System.out.println("1."+date);

	}

	@Test
	/**
	 * 测试TypeUtils里面的dateToStr方法
	 */
	public void testDateToStr() {
		java.sql.Date sdate=new java.sql.Date(97,2,9);
		
		String str=TypeUtils.dateToStr(sdate);
		System.out.println("2."+str);
		
	}

	@Test
	/**
	 * 测试TypeUtils里面的mailCheck方法
	 */
	public void testMailCheck() {
		String str1="a@163.com";
		String str2="aaa";
		boolean flag1,flag2;
		flag1=false;
		flag2=false;
		flag1=TypeUtils.mailCheck(str1);
		flag2=TypeUtils.mailCheck(str2);
		System.out.println(flag1+","+flag2);
		
	}

}
