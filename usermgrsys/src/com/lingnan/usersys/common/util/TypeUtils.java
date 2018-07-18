package com.lingnan.usersys.common.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *  格式转换类
 * @author Administrator
 *
 */
public class TypeUtils {
	
	/**
	 * 字符串转换为日期
	 * @param str   
	 * @return date 转换后的日期
	 */
	
	public static java.sql.Date strToDate(String str){
		Date date=null;
		java.sql.Date sdate=null;
//		设置要格式化的日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
//			调用parse方法，将字符串解析成指定格式的日期类型
			date=sdf.parse(str);
//			util.Date类型转化为sql.Date类型
			  sdate  =  new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("字符串转换为日期出错");
			e.printStackTrace();
		}
		
//		返回转换后的值
		return sdate;
		
	}
	
	/**
	 * 日期转换为字符串
	 * @param date
	 * @return 转换后的字符串
	 */
	
	public static String dateToStr(java.sql.Date sdate){
		String str=null;

		try{
//			sql.Date类型转化为util.Date类型
			Date date  = new Date(sdate.getTime());		
	        
		
//		设置要格式化的日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		调用format方法，将日期格式化为字符串
		str=sdf.format(date);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("日期转换为字符串出错");
			e.printStackTrace();
			
		}

		//		返回转换后的值
		return str;
	}
	
	
	
	public static boolean mailCheck(String input){
		boolean flag=false;
		
		//邮箱验证：前面任意位数非空字符，必须带@，末尾必须有.com或者.cn匹配式： \w+@\w+\.(com)|(cn)
		String regex = "\\w+@\\w+\\.(com)|(cn)";  
		Pattern pattern = Pattern.compile(regex) ;//编译正则表达式  
		Matcher matcher = pattern.matcher(input) ;//进行匹配  
		if (matcher.matches()) flag = true;  
		
		return flag;
	}
	
	

}
