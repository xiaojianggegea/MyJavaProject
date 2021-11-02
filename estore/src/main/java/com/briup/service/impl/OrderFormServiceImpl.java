package com.briup.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.dao.OrderFormMapper;
import com.briup.dao.OrderLineMapper;
import com.briup.service.IOrderFormService;
import com.briup.util.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements IOrderFormService {
	
	private OrderFormMapper orderFormMapper;
	private OrderLineMapper orderLineMapper;
	
	@Override
	public void saveOrderForm(OrderForm order) {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		orderLineMapper = sqlSession.getMapper(OrderLineMapper.class);
		
		orderFormMapper.saveOrderForm(order);
		
		Collection<OrderLine> orderLines = order.getOrderLines();
		
		for(OrderLine orderLine : orderLines) {
			orderLine.setOrderForm(order);
			orderLineMapper.saveOrderLine(orderLine);
		}
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}

	@Override
	public OrderForm findOrderFormByOrderid(Long orderid) {
		return null;
	}

	@Override
	public List<OrderForm> findOrderFormByCustomerId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		
		List<OrderForm> list = orderFormMapper.findOrderFormByCustomerId(id);
		
		sqlSession.close();
		return list;
	}

	@Override
	public void deleteOrderFormById(Integer id) {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		orderLineMapper = sqlSession.getMapper(OrderLineMapper.class);
		
		orderLineMapper.deleteOrderLineByOrderId(id);
		orderFormMapper.deleteOrderFormById(id);
		
		sqlSession.commit();
		
		sqlSession.close();
	}

}
