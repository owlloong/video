package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.DanmuMapper;
import com.po.Danmu;
import com.po.DanmuExample;
import com.service.DanmuService;
import com.util.CommonsUtils;

@Service("danmuService")
public class DanmuServiceImpl implements DanmuService {
	
	@Autowired
	private DanmuMapper danmuMapper;
	
	private SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Override
	public List getDanmu(String videoId) throws Exception {
		DanmuExample dExample=new DanmuExample();
		DanmuExample.Criteria criteria= dExample.createCriteria();
		criteria.andVideoIdEqualTo(videoId);
		return danmuMapper.selectByExampleWithBLOBs(dExample);
		
	}

	@Override
	public void postDanmu(String userId, String videoId, String danmu) throws Exception {
		Danmu danmu2=new Danmu();
		danmu2.setUserId(userId);
		danmu2.setVideoId(videoId);
		danmu2.setDanmu(danmu);
		danmu2.setDanmuId(CommonsUtils.getUUID());
		danmuMapper.insert(danmu2);
		
	}
	
}
