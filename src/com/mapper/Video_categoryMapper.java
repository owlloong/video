package com.mapper;

import com.po.Video_category;
import com.po.Video_categoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Video_categoryMapper {
    int countByExample(Video_categoryExample example);

    int deleteByExample(Video_categoryExample example);

    int deleteByPrimaryKey(String videoId);

    int insert(Video_category record);

    int insertSelective(Video_category record);

    List<Video_category> selectByExample(Video_categoryExample example);

    Video_category selectByPrimaryKey(String videoId);

    int updateByExampleSelective(@Param("record") Video_category record, @Param("example") Video_categoryExample example);

    int updateByExample(@Param("record") Video_category record, @Param("example") Video_categoryExample example);

    int updateByPrimaryKeySelective(Video_category record);

    int updateByPrimaryKey(Video_category record);
}