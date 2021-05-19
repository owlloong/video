package com.service;

import java.util.List;

import com.po.Category;



public interface CategoryService {
		
	/*
	 * 获取所有类别
	 */
	public List GetCategories() throws Exception;
	/*
	 * 通过ID获取分类
	 * @param categoryId
	 */
	public List<Category> getCategoriesById(int categoryId) throws Exception;
	/*
	 * 通过id获取单个
	 * @param categoryId
	 */
	public Category getCategoryById(int categoryId) throws Exception;
	/*
	 * 新增分类
	 * @param categoryName
	 * @param parentId
	 */
	public int addCategory(String categoryName,String parentId) throws Exception;
	/*
	 * 计算分类中视频数量
	 */
	public int countCateVideos(String categoryId) throws Exception;
	/*
	 * 删除分类
	 */
	public int delCategory(String categoryId) throws Exception;
}
