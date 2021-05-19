package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CategoryMapper;
import com.mapper.CommentMapper;
import com.mapper.UserMapper;
import com.mapper.UserdataMapper;
import com.mapper.VideoMapper;
import com.mapper.Video_categoryMapper;
import com.po.Category;
import com.po.CategoryExample;
import com.po.Comment;
import com.po.CommentExample;
import com.po.User;
import com.po.Userdata;
import com.po.Video;
import com.po.VideoExample;
import com.po.Video_category;
import com.po.Video_categoryExample;
import com.service.CategoryService;
import com.service.UserService;
import com.service.VideoService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.util.ManagerThreadLocal;
import com.util.VideoDao;
import com.util.VideoDaoImpl;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserdataMapper userdataMapper;
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private VideoMapper videoMapper;
	
	@Autowired
	private Video_categoryMapper video_categoryMapper;
	
	@Autowired
	private CommentMapper commentMapper;

	public List GetFirCateVideos(String categoryId,String pageNum) {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=null;
		try {
			ManagerThreadLocal.startTransacation();
			//获取videolist
			list=videoDao.GetFirCateVideos(categoryId, pageNum);
			//获取video的user
			for(Video v:list) {
				v.setUser(userService.getUserByuid(v.getUserId()));
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//获取二级分类的视频
	public List GetSecCateVideos(String categoryId,String pageNum) {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=null;
		try {
			ManagerThreadLocal.startTransacation();
			//获取videolist
			list=videoDao.GetSecCateVideos(categoryId, pageNum);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//通过编号获取视频
	public Video GetVideoById(String videoId) {
		VideoDao videoDao=new VideoDaoImpl();
		Video video=null;
		try {
			ManagerThreadLocal.startTransacation();
			//获取video
			video=videoDao.GetVideoById(videoId);
			//获取分类
			video.setCategory(categoryService.getCategoryById(video.getCategoryId()));
			//获取用户
			video.setUser(userService.getUserByuid(video.getUserId()));
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return video;
	}
	//通过State获取视频
	public List GetVideoByState(int state) {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=new ArrayList<Video>();
		try {
			ManagerThreadLocal.startTransacation();
			//操作
			list=videoDao.GetVideoByState(state);
			//通过categoryId获取category
			for(Video v:list) {
				v.setCategory(categoryService.getCategoryById(v.getCategoryId()));
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//根据id改状态
	public int changeState(String videoId,int state) {
		VideoDao videoDao=new VideoDaoImpl();
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=videoDao.changeState(videoId, state);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result>0) {
			return 1;
		} else {
			return 0;
		}
	}
	//根据name获得
	public List getVideosByName(String videoName) {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=new ArrayList<Video>();
		try {
			ManagerThreadLocal.startTransacation();
			//操作
			list=videoDao.getVideosByName(videoName);
			//通过categoryId获取category
			for(Video v:list) {
				v.setCategory(categoryService.getCategoryById(v.getCategoryId()));
			}
			for(Video v:list) {
				v.setUser(userService.getUserByuid(v.getUserId()));
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//热门视频
	public List GetHotVideos() {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=new ArrayList<Video>();
		try {
			ManagerThreadLocal.startTransacation();
			//获取
			list=videoDao.getVideosByCount();
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//大分类视频总量
	public int countFirCateVideos(String categoryId) {
		VideoDao videoDao=new VideoDaoImpl();
		int count=0;
		try {
			ManagerThreadLocal.startTransacation();
			count=videoDao.countFirCateVideos(categoryId);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	//小分类视频总量
	public int countSecCateVideos(String categoryId) {
		VideoDao videoDao=new VideoDaoImpl();
		int count=0;
		try {
			ManagerThreadLocal.startTransacation();
			count=videoDao.countSecCateVideos(categoryId);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	//播放量增长
	public int countPlus(String videoId) {
		VideoDao videoDao=new VideoDaoImpl();
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=videoDao.countPlus(videoId);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result>0) {
			return 1;
		} else {
			return 0;
		}
	}
	//搜索
	public List<Video> searchVideo(String keyword,int pageNum){
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=new ArrayList<Video>();
		try {
			ManagerThreadLocal.startTransacation();
			list=videoDao.getVideosByNameLimit(keyword, pageNum);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	//获取搜索页数
	public int countSearchResult(String keyword) {
		VideoDao videoDao=new VideoDaoImpl();
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=videoDao.countVideosByNameLimit(keyword);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	//分类是否有视频
	public int checkCateVideo(String categoryId) {
		VideoDao videoDao=new VideoDaoImpl();
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=videoDao.checkCateVideo(categoryId);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public List<Video> GetVideoByuid(String userid) {
		VideoDao videoDao=new VideoDaoImpl();
		List<Video> list=new ArrayList<Video>();
		try {
			ManagerThreadLocal.startTransacation();
			list=videoDao.GetVideoByuid(userid);
			for(Video v:list) {
				v.setCategory(categoryService.getCategoryById(v.getCategoryId()));
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public List GetTuiJianVideos(User user) throws Exception {
		List<Video> videos=new ArrayList<>();
		if(user!=null){
			List<Category> cList=new ArrayList<>();
			Userdata userdata=userdataMapper.selectByPrimaryKey(user.getUserId());
			//按性别查找
			List<String> strings=new ArrayList<>();
			/*if (userdata!=null) {
				if(userdata.getGender()==1){
					strings=Arrays.asList("游戏","连载动画","单机游戏","鬼畜·搞笑");
				}else{
					strings=Arrays.asList("舞蹈","美食·动物","绘画","艺术");
				}
			}
			
			for (String string : strings) {
				CategoryExample example=new CategoryExample();
				CategoryExample.Criteria c=example.createCriteria();
				c.andCategoryNameLike("%"+string+"%");
				cList.addAll(categoryMapper.selectByExample(example));
			}
			Set<Integer> cids=new HashSet<>();
			for (Category category : cList) {
				cids.add(category.getCategoryId());
				if(category.getCategoryId()!=0){
					cids.add(category.getParentId());
				}
				List<Category> list=categoryService.getCategoriesById(category.getParentId());
				for (Category category2 : list) {
					cids.add(category2.getCategoryId());
					if(category2.getCategoryId()!=0){
						cids.add(category2.getParentId());
					}
				}
				
			}
			List<Video_category> vcs=new ArrayList<>();
			
			for(int id:cids){
				Video_categoryExample eVideo_categoryExample=new Video_categoryExample();
				Video_categoryExample.Criteria criteria=eVideo_categoryExample.createCriteria();
				criteria.andCategoryIdEqualTo(String.valueOf(id));
				vcs.addAll(video_categoryMapper.selectByExample(eVideo_categoryExample));
			}
			
			for(Video_category vc:vcs){
				videos.add(videoMapper.selectByPrimaryKey(vc.getVideoId()));
			}
		}
		//按点击数量
		if(videos.size()<1){
			VideoExample videoExample=new VideoExample();
			VideoExample.Criteria criteria=videoExample.createCriteria();
			criteria.andStatusEqualTo(200);
			videoExample.setOrderByClause("count desc");
			videos.addAll(videoMapper.selectByExample(videoExample));
		}*/
		
		//3按评论
		if(user!=null){
			CommentExample cExample=new CommentExample();
			CommentExample.Criteria criteria=cExample.createCriteria();
			criteria.andUserIdEqualTo(user.getUserId());
			/*List<Comment> list=commentMapper.selectByExample(cExample);*/
			List<Comment> list=commentMapper.selectCommentByUserId(user.getUserId());
			List<Comment> list22=new ArrayList<>();;
			for (Comment comment : list) {
				CommentExample cExample2=new CommentExample();
				CommentExample.Criteria criteria2=cExample2.createCriteria();
				criteria2.andCommentIdEqualTo(comment.getParentId());
				List<Comment> list2=commentMapper.selectByExample(cExample2);
				list22.addAll(list2);
			}
			list.addAll(list22);
			Set<String> set=new HashSet<>();
			
			for (Comment comment : list) {
				if(comment.getParentId().length()<15){
					set.add(String.valueOf(comment.getParentId()));
				}
			
			}
			Set<String> set2=new HashSet<>();
			
			for (String string : set) {
				 Video_category vCategory=video_categoryMapper.selectByPrimaryKey(string);
				 set2.add(vCategory.getCategoryId());
				 List<Category> list2=categoryService.getCategoriesById(Integer.parseInt(vCategory.getParentId()));
				for (Category category : list2) {
					set2.add(category.getCategoryId().toString());
				}
				 set2.add(vCategory.getParentId());
			}
			List<Video> videos2=new ArrayList<>();
			
			
			for (String string : set2) {
				List<Video_category> vcs=new ArrayList<>();
				Video_categoryExample eVideo_categoryExamples=new Video_categoryExample();
				Video_categoryExample.Criteria criterias=eVideo_categoryExamples.createCriteria();
				criterias.andCategoryIdEqualTo(string);
				vcs.addAll(video_categoryMapper.selectByExample(eVideo_categoryExamples));
				for (Video_category video_category : vcs) {
					videos2.add(videoMapper.selectByPrimaryKey(video_category.getVideoId()));
				}
			}
			List<Video> de=new ArrayList<>();
			for (Video video : videos2) {
				for (Comment comment : list) {
					if(video!=null&&video.getVideoId()!=null&&comment!=null){
						if(video.getVideoId().equals(comment.getParentId())){
							de.add(video);
						}
					}
					
				}
			}
			videos2.removeAll(de);
			videos.addAll(videos2);
		}
		}
		return videos;
	}
	@Override
	public int insert(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.insert(video);
	}
	
	

	
	
	
	
}
