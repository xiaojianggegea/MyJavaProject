package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.ShopAddress;
import com.briup.dao.ShopAddressMapper;
import com.briup.service.IShopAddressService;
import com.briup.util.MyBatisSqlSessionFactory;

public class ShopAddressServiceImpl implements IShopAddressService {
	
	private ShopAddressMapper addressMapper;
	
	@Override
	public List<ShopAddress> findAddressByCustomerId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		addressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		
		List<ShopAddress> list = addressMapper.findAddressByCustomerId(id);
		
		sqlSession.close();
		
		return list;
	}

	
	@Override
	public void saveAddress(ShopAddress sd) {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		addressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		
		// 注意，sd对象中，一定要有customer对象，否则无法插入外键列的值
		addressMapper.saveAddress(sd);
		
		sqlSession.commit();
		sqlSession.close();
		
	}


	@Override
	public ShopAddress findAddressById(int addressId) {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		addressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		
		ShopAddress address = addressMapper.findShopAddressById(addressId);
		
		sqlSession.close();
		
		return address;
	}

}
