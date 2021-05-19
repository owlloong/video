package com.dao;


public class DaoFactory {
	private static DaoFactory daoFactory = new DaoFactory();
	private DaoFactory(){
	}
	public static DaoFactory getInstance(){
		return daoFactory;
	}
	public static VideoDao getVideoDao(){
		return new DoDao();
	}
}
