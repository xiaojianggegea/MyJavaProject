package com.briup.util;

import org.junit.Test;

public class MD5UtilTest {

	@Test
	public void test_md5() {
		
		//hello - 5D41402ABC4B2A76B9719D911017C592
		//123   - 202CB962AC59075B964B07152D234B70
		String str = MD5Util.md5("123");
		
		System.out.println(str);
		
	}

}
