package com.briup.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	
	@Test
	public void test() {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		
	}
	
}
