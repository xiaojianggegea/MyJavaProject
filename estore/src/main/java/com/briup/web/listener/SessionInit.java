package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShopCar;

@WebListener
public class SessionInit implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		
		session.setAttribute("ShopCar", new ShopCar());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
