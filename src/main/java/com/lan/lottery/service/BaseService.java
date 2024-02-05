package com.lan.lottery.service;

import java.io.Serializable;

public interface BaseService<T> {

	int deleteById(Serializable id);

    int save(T record);

    T getById(Serializable id);

    int updateSelective(T record);

    int update(T record);
}
