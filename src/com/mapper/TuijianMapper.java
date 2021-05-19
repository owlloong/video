package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Tuijian;
import com.po.TuijianExample;

public interface TuijianMapper {
	int countByExample(TuijianExample example);

    int deleteByExample(TuijianExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Tuijian record);

    int insertSelective(Tuijian record);

    List<Tuijian> selectByExampleWithBLOBs(TuijianExample example);

    List<Tuijian> selectByExample(TuijianExample example);

    Tuijian selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Tuijian record, @Param("example") TuijianExample example);

    int updateByExampleWithBLOBs(@Param("record") Tuijian record, @Param("example") TuijianExample example);

    int updateByExample(@Param("record") Tuijian record, @Param("example") TuijianExample example);

    int updateByPrimaryKeySelective(Tuijian record);

    int updateByPrimaryKeyWithBLOBs(Tuijian record);

    int updateByPrimaryKey(Tuijian record);
}
