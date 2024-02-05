package com.lan.lottery.service.impl;


import com.lan.lottery.mapper.BaseMapper;
import com.lan.lottery.service.BaseService;

import java.io.Serializable;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected abstract BaseMapper<T> getMapper();
	
	@Override
	public int deleteById(Serializable id) {
		return getMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int save(T record) {
		return getMapper().insertSelective(record);
	}

	@Override
	public T getById(Serializable id) {
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateSelective(T record) {
		return getMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(T record) {
		return getMapper().updateByPrimaryKey(record);
	}

}
