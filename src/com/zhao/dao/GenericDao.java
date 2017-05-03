package com.zhao.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {

	public void add(T t);

	public void update(T t);

	public T find(String att, Object value);

	public boolean exist(Map<String, Object> params);

	public Object findAttribute(String attName, Map<String, Object> param);

	public List<T> queryAll();

	public List<T> querySome(Map<String, Object> params);

	public List<T> querySome(Map<String, Object> params, Integer begin, Integer capacity);

}
