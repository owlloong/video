package com.service;


import java.util.List;


public interface BaseService <E>{
	
	int insert(E entity);//增加

    int delete(String id);//删除

    int update(E entity);//修改

    E findById(String id);//查询
    
    
    List<E> findAll();//查询
    
    
    List<E> findByCondition(E e) throws Exception;//查询
    
    

}
