package com.briup.constants;

public class EstoreConstants {
	// 自动登录cookie 名字
	public static final String AUTO_LOGIN_COOKIE_NAME = "autologin";
	// 自动登录cookie 生效时间：7天，单位：秒
	public static final int AUTO_LOGIN_COOKIE_MAX_AGE = 60 * 60 * 24 * 7;
	
	// 用户登录后，在session中存在的key的名字
	public static final String USER_LOGIN_SESSION_KEY = "customer";
}
