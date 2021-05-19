package com.po;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:category表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Category  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Integer categoryId;

    private List<Category> subCategory;
	private List<Video> video;
	private int count;
	
    public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 
     * @return categoryId 
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId 
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return categoryName 
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName 
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 
     * @return parentId 
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId 
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}