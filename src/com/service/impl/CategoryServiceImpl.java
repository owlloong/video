package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CategoryMapper;
import com.mapper.Video_categoryMapper;
import com.po.Category;
import com.po.CategoryExample;
import com.po.Video_categoryExample;
import com.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	//创建一个QueryRunner对象
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private Video_categoryMapper video_categoryMapper;
	
	//通过Id获取分类
	public List getCategoriesById(int categoryId) throws Exception{
		CategoryExample categoryExample=new CategoryExample();
		CategoryExample.Criteria criteria=categoryExample.createCriteria();
		criteria.andParentIdEqualTo(categoryId);
		return categoryMapper.selectByExample(categoryExample);
	}
	//id获取单个分类
	public Category getCategoryById(int categoryId) throws Exception{
		
		 Category category=categoryMapper.selectByPrimaryKey(categoryId);
		 category.setSubCategory(getCategoriesById(categoryId));
		 return category;
	}
	//新增分类
	public int addCategory(String categoryName,String parentId) throws Exception{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setParentId(Integer.parseInt(parentId));
		return categoryMapper.insert(category);
	}
	//删除分类
	public int delCategory(String categoryId) throws Exception{
		return categoryMapper.deleteByPrimaryKey(Integer.parseInt(categoryId));
	}
	@Override
	public int countCateVideos(String categoryId) throws Exception {
		Video_categoryExample video_categoryExample=new Video_categoryExample();
		Video_categoryExample.Criteria  criteria=video_categoryExample.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		return video_categoryMapper.countByExample(video_categoryExample);
	}
	@Override
	public List GetCategories() throws Exception {
		List<Category> list=new ArrayList<Category>();
		list=getCategoriesById(0);
		for(Category c:list) {
			c.setSubCategory(getCategoriesById(c.getCategoryId()));
		}
		//获得每个分类的视频数量
		for(Category c:list) {
			c.setCount(countCateVideos(c.getCategoryId().toString()));
		}
		return list;
	}
	
}
