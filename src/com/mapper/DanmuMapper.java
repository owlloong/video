package com.mapper;

import com.po.Danmu;
import com.po.DanmuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DanmuMapper {
    int countByExample(DanmuExample example);

    int deleteByExample(DanmuExample example);

    int deleteByPrimaryKey(String danmuId);

    int insert(Danmu record);

    int insertSelective(Danmu record);

    List<Danmu> selectByExampleWithBLOBs(DanmuExample example);

    List<Danmu> selectByExample(DanmuExample example);

    Danmu selectByPrimaryKey(String danmuId);

    int updateByExampleSelective(@Param("record") Danmu record, @Param("example") DanmuExample example);

    int updateByExampleWithBLOBs(@Param("record") Danmu record, @Param("example") DanmuExample example);

    int updateByExample(@Param("record") Danmu record, @Param("example") DanmuExample example);

    int updateByPrimaryKeySelective(Danmu record);

    int updateByPrimaryKeyWithBLOBs(Danmu record);

    int updateByPrimaryKey(Danmu record);
}