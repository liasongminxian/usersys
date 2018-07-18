package com.lingnan.usersys.common.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *  ��ʽת����
 * @author Administrator
 *
 */
public class TypeUtils {
	
	/**
	 * �ַ���ת��Ϊ����
	 * @param str   
	 * @return date ת���������
	 */
	
	public static java.sql.Date strToDate(String str){
		Date date=null;
		java.sql.Date sdate=null;
//		����Ҫ��ʽ�������ڸ�ʽ
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
//			����parse���������ַ���������ָ����ʽ����������
			date=sdf.parse(str);
//			util.Date����ת��Ϊsql.Date����
			  sdate  =  new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("�ַ���ת��Ϊ���ڳ���");
			e.printStackTrace();
		}
		
//		����ת�����ֵ
		return sdate;
		
	}
	
	/**
	 * ����ת��Ϊ�ַ���
	 * @param date
	 * @return ת������ַ���
	 */
	
	public static String dateToStr(java.sql.Date sdate){
		String str=null;

		try{
//			sql.Date����ת��Ϊutil.Date����
			Date date  = new Date(sdate.getTime());		
	        
		
//		����Ҫ��ʽ�������ڸ�ʽ
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		����format�����������ڸ�ʽ��Ϊ�ַ���
		str=sdf.format(date);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����ת��Ϊ�ַ�������");
			e.printStackTrace();
			
		}

		//		����ת�����ֵ
		return str;
	}
	
	
	
	public static boolean mailCheck(String input){
		boolean flag=false;
		
		//������֤��ǰ������λ���ǿ��ַ��������@��ĩβ������.com����.cnƥ��ʽ�� \w+@\w+\.(com)|(cn)
		String regex = "\\w+@\\w+\\.(com)|(cn)";  
		Pattern pattern = Pattern.compile(regex) ;//����������ʽ  
		Matcher matcher = pattern.matcher(input) ;//����ƥ��  
		if (matcher.matches()) flag = true;  
		
		return flag;
	}
	
	

}
