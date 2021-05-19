package com.mapper;

import com.po.Userdata;
import com.po.UserdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserdataMapper {
    int countByExample(UserdataExample example);

    int deleteByExample(UserdataExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Userdata record);

    int insertSelective(Userdata record);

    List<Userdata> selectByExample(UserdataExample example);

    Userdata selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Userdata record, @Param("example") UserdataExample example);

    int updateByExample(@Param("record") Userdata record, @Param("example") UserdataExample example);

    int updateByPrimaryKeySelective(Userdata record);

    int updateByPrimaryKey(Userdata record);
}