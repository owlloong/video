package com.util;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.po.Video;



public class VideoDaoImpl implements VideoDao {
	//创建一个QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	//获取一级分类的视频
	public List GetFirCateVideos(String categoryId,String pageNum) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE parentId=? AND status=200 ORDER BY videoTime DESC LIMIT ?,6", new BeanListHandler<Video>(Video.class) ,categoryId,6*(Integer.parseInt(pageNum)-1));
	}
	//获取二级视频
	public List GetSecCateVideos(String categoryId,String pageNum) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE categoryId=? AND status=200 ORDER BY videoTime DESC LIMIT ?,6", new BeanListHandler<Video>(Video.class) ,categoryId,6*(Integer.parseInt(pageNum)-1));
	}
	//编号获取视频
	public Video GetVideoById(String videoId) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE v.videoId=?",new BeanHandler<Video>(Video.class), videoId);
	}
	//state获取视频
	public List GetVideoByState(int state) throws Exception{
		return qr.query("SELECT v.videoId,videoName,videoBrief,userId,videoURL,videoSRC,videoTime,`status`,categoryId FROM video v JOIN video_category vc ON v.videoId=vc.videoId WHERE `status`=?",new BeanListHandler<Video>(Video.class), state);
	}
	//根据id改state
	public int changeState(String videoId,int state) throws Exception{
		return qr.update("UPDATE video SET `status`=? WHERE videoId=?",state,videoId);
	}
	//根据name获得
	public List getVideosByName(String videoName) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON v.videoId=vc.videoId WHERE videoName LIKE ?",new BeanListHandler<Video>(Video.class), "%"+videoName+"%");
	}
	//根据name获得有限制
	public List getVideosByNameLimit(String videoName,int pageNum) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON v.videoId=vc.videoId WHERE videoName LIKE ? LIMIT ?,6",new BeanListHandler<Video>(Video.class), "%"+videoName+"%",(pageNum-1)*6);
	}
	//count search结果
	public int countVideosByNameLimit(String videoName) throws Exception{
		Number number=(Number) qr.query("SELECT COUNT(*) FROM video v JOIN video_category vc ON v.videoId=vc.videoId WHERE videoName LIKE ?",new ScalarHandler() ,videoName);
		int result=number.intValue();
		return result;
	}
	//热门视频
	public List getVideosByCount() throws Exception{
		return qr.query("SELECT * FROM video WHERE status=? ORDER BY count DESC LIMIT 0,6",new BeanListHandler<Video>(Video.class),"200");
	}
	//大分类视频量
	public int countFirCateVideos(String categoryId) throws Exception{
		Number number=(Number) qr.query("SELECT COUNT(*) FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE parentId=?",new ScalarHandler(), categoryId);
		int count=number.intValue();
		return count;
	}
	//小分类视频量
	public int countSecCateVideos(String categoryId) throws Exception{
		Number number=(Number) qr.query("SELECT COUNT(*) FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE categoryId=?",new ScalarHandler(), categoryId);
		int count=number.intValue();
		return count;
	}
	//增加count
	public int countPlus(String videoId) throws Exception{
		return qr.update("UPDATE video SET count=count+1 WHERE videoId=?",videoId);
	}
	//检查视频是否还有分类
	public int checkCateVideo(String categoryId) throws Exception{
		Number number=(Number) qr.query("SELECT COUNT(*) FROM video_category WHERE categoryId=?",new ScalarHandler(),categoryId);
		int result=number.intValue();
		return result;
	}
	//userid获取视频
	public List GetVideoByuid(String userId) throws Exception{
		return qr.query("SELECT * FROM video v JOIN video_category vc ON (v.videoId=vc.videoId) WHERE userId=?",new BeanListHandler<Video>(Video.class), userId);
	}
}
