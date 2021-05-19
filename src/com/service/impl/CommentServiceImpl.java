package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CommentMapper;
import com.mapper.TuijianMapper;
import com.mapper.UserMapper;
import com.po.Comment;
import com.po.CommentExample;
import com.po.Tuijian;
import com.po.User;
import com.service.CommentService;
import com.service.UserService;
import com.test.hadoop.hdfs.TestHDFSDao;
import com.util.CommonsUtils;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserService  userService;
	
	private SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Autowired
	private TuijianMapper tuijianMapper;
	
	//发送评论
	public void sendComment(String userId,String parentId,String comment,String datetime) throws Exception {
		Comment comm=new Comment();
		comm.setUserId(userId);
		comm.setParentId(parentId);
		comm.setCommContext(comment);
		comm.setCommentTime(sFormat.parse(datetime));
		comm.setCommentId(CommonsUtils.getUUID());
		commentMapper.insert(comm);
		
		//推荐表插入
		Tuijian tj=new Tuijian();
		tj.setUserId(userId);
		tj.setParentId(parentId);
		tj.setNum(1);
		tuijianMapper.insert(tj);
		//TestHDFSDao testHDFSDao=new TestHDFSDao();
		
	}
	//获取视频评论
	public List getVideoComment(String videoId,int pageNum) throws Exception {
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andParentIdEqualTo(videoId);
		cExample.setOrderByClause("commentTime DESC  LIMIT "+6*(pageNum-1) +" ,6");
		List<Comment> list= commentMapper.selectByExampleWithBLOBs(cExample);
		for(Comment c:list) {
			int count=getSubCommCount(c.getCommentId());
			c.setSubCommCount(count);
		}
		//获取评论user信息
		for(Comment c:list) {
			User user=userService.getUserByuid(c.getUserId());
			c.setUser(user);
		}
		return list;
		//return qr.query("SELECT * FROM `comment` WHERE parentId=? ORDER BY commentTime DESC LIMIT ?,6",new BeanListHandler<Comment>(Comment.class),videoId,6*(pageNum-1));
	}
	//获取视频评论总数
	public int countVideoComment(String videoId) throws Exception{
		
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andParentIdEqualTo(videoId);
		return commentMapper.countByExample(cExample);
		/*Number number= (Number) qr.query("SELECT COUNT(*) FROM `comment` WHERE parentId=?",new ScalarHandler(),videoId);
		int count=number.intValue();
		return count;*/
	}
	//获取子评论数量
	public int getSubCommCount(String commentId) throws Exception{
		
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andParentIdEqualTo(commentId);
		return commentMapper.countByExample(cExample);
		/*Number number= (Number) qr.query("SELECT COUNT(*) FROM `comment` WHERE parentId=?",new ScalarHandler(), commentId);
		int count=number.intValue();
		return count;*/
	}
	@Override
	public int deleteSubCommCount(String commentId) throws Exception {
		if(getSubCommCount(commentId)>0){
			return -9;
		}
		return commentMapper.deleteByPrimaryKey(commentId);
	}
	@Override
	public List getAllComm() throws Exception {
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andCommentIdIsNotNull();
		List<Comment> list= commentMapper.selectByExampleWithBLOBs(cExample);
		return list;
	}
	@Override
	public List getAllComm(int pageNum) throws Exception {
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andCommentIdIsNotNull();
		cExample.setOrderByClause("commentTime DESC  LIMIT "+6*(pageNum-1) +" ,6");
		List<Comment> list= commentMapper.selectByExampleWithBLOBs(cExample);
		for(Comment c:list) {
			int count=getSubCommCount(c.getCommentId());
			c.setSubCommCount(count);
		}
		for(Comment c:list) {
			User user=userService.getUserByuid(c.getUserId());
			c.setUser(user);
		}
		return list;
	}
	
	@Override
	public boolean userIsComment(String userId) throws Exception {
		CommentExample cExample=new CommentExample();
		CommentExample.Criteria criteria=cExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Comment> commentList = commentMapper.selectByExample(cExample);
		if(commentList.size()!=0){
			return true;
		}
		return false;
	}
	
}
