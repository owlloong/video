package com.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.po.Category;
import com.po.Comment;
import com.po.User;
import com.po.Userdata;
import com.po.Video;
import com.service.CategoryService;
import com.service.CommentService;
import com.service.UserService;
import com.service.UserdataService;
import com.service.VideoService;
import com.util.MD5Utils;
import com.util.MailUtils;
import com.util.Upload;

@Controller
@RequestMapping("/User")
public class UserHandler {

	@Autowired
	private VideoService videoService;
	/*
	 * @Autowired private VideoService videoService;
	 * 
	 * @Autowired private CommentService commentService;
	 * 
	 * @Autowired private CategoryService categoryService;
	 */

	@Autowired
	private UserService userService;

	@Autowired
	private UserdataService userdataService;

	@RequestMapping("/Login")
	public String Login(String email, String password, HttpSession session,
			Model model) throws Exception {
		User user = userService.login(email, password);
		if (user == null) {
			// 登录失败,用户名或密码错误
			System.out.println("登录失败，用户名或密码错误");
			return "/login";
		} else {
			// state判断
			if (user.getState() == 100) {
				// 登录成功
				session.setAttribute("user", user);
				return "forward:/Category/Index.do";
			} else {
				// 登录失败，用户状态异常
				System.out.println("登录失败，用户状态异常");
				return "/login";
			}
		}
	}

	@RequestMapping("/Register")
	public String Register(String userName, String email, String password,
			HttpSession session, Model model) throws Exception {
		int result = userService.register(email, userName, password);

		if (result > 0) {
			// 成功
			// 提示邮箱激活
			// 获取userId
			User user = userService.login(email, password);
			String userId = user.getUserId();
			// 发送激活邮件
			String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
					+ "<a href='http://localhost:8080/Video/User/Active.do?Code="
					+ userId + "'>"
					+ "http://localhost:8080/Video/User/Active.do?&Code="
					+ userId + "</a>";
			try {
				MailUtils.sendMail(email, emailMsg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			// 跳转到注册成功页面
			return "/registerSuccess";
		} else {
			// 失败
			return "/login";
		}
	}

	@RequestMapping("/Active")
	public String Active(String Code, HttpSession session, Model model)
			throws Exception {

		int result = userService.frozeUser(Code, 1);
		if (result > 0) {
			// 激活成功，进行登录
			return "/login";
		} else {
			// 激活失败
			return "/register";
		}
	}

	@RequestMapping("/FrozeUser")
	@ResponseBody
	public String FrozeUser(String userId, String type, HttpSession session,
			Model model) throws Exception {

		int types = Integer.parseInt(type);
		int result = 0;
		result = userService.frozeUser(userId, types);
		if (result > 0) {
			// 成功
			return "success";
		} else {
			return "failure";
		}
	}

	@RequestMapping("/ChangeRole")
	@ResponseBody
	public String ChangeRole(String userId, String type, HttpSession session,
			Model model) throws Exception {

		int types = Integer.parseInt(type);
		int result = 0;
		result = userService.changeRole(userId, types);
		if (result > 0) {
			// 成功
			return "success";
		} else {
			return "failure";
		}
	}

	@RequestMapping("/CheckMail")
	@ResponseBody
	public String ChangeRole(String email, HttpSession session, Model model)
			throws Exception {
		if (email == null || email.equals("")) {
			// 为空
			return "empty";
		} else {
			// 非空
			// 检查格式
			if (email
					.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
				// 正确
				int temp = userService.checkEmailUnique(email);
				if (temp > 0) {
					return "false";
				} else {
					return "true";
				}
			} else {
				return "format";
			}
		}

	}

	@RequestMapping("/CheckName")
	@ResponseBody
	public String CheckName(String name, HttpSession session, Model model)
			throws Exception {

		if (name == null || name.equals("")) {
			// 空
			return "empty";
		} else {
			// 长于3位
			if (name.length() >= 3) {
				// 合格
				// 检查唯一性
				int temp = userService.CheckNameUnique(name);
				if (temp > 0) {
					return "false";
				} else {
					return "true";
				}
			} else {
				return "short";
			}
		}
	}

	@RequestMapping("/AlterPassword")
	@ResponseBody
	public String AlterPassword(String newpwd, HttpSession session, Model model)
			throws Exception {
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		String password = newpwd;
		if (password == null) {
			// 空
			return "empty";
		}
		/*password = MD5Utils.md5(password);*/
		int result = userService.AlterPassword(password, userId);

		if (result >= 0) {

			return "success";
		} else {
			return "failure";
		}

	}
	@RequestMapping("/CheckPassword")
	@ResponseBody
	public String CheckPassword(String password, HttpSession session, Model model)
			throws Exception {
		
		User user=(User) session.getAttribute("user");
		if(user==null) {
			return "nolog";
		} else {
			//已登录
			String email=user.getEmail();
			/*password=MD5Utils.md5(password);*/
			User checkuser=userService.login(email, password);
			if(checkuser==null) {
				 return "false";
			} else {
				return  "true";
			}
		}
	}
	@RequestMapping("/changeName")
	@ResponseBody
	public String changeName(String userName, HttpSession session, Model model)
			throws Exception {
		User user=(User) session.getAttribute("user");
		String userId=user.getUserId();
		//获取userName
		//检查用户名是否重复
		int unique=userService.CheckNameUnique(userName);
		if(unique>0) {
			//重复
			 return "notunique";
		} else {
			int result=userService.AlterName(userId, userName);
			if(result>0) {
				user.setUserName(userName);
				session.setAttribute("user", user);
				 return "success";
			} else {
				 return "failure";
			}
		}
	}
	
	@RequestMapping("/chanePhoto")
	@ResponseBody
	public String chanePhoto(MultipartFile file, HttpSession session, Model model)
			throws Exception {
		User user=(User) session.getAttribute("user");
		String userId=user.getUserId();
		
		if(file==null) {
			//重复
			return "failure";
		} else {
			Userdata userdata=	userdataService.GetUserData(user.getUserId());
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(userdata==null){
				userdata=new Userdata();
				userdataService.UpdateUserData(
						Upload.creatpicture(file, "images"),
						null,
						"1"
						, null, 
						"2019-05-07 18:28:25",
						userId);
			}else{
				
			
			userdataService.UpdateUserData(
					Upload.creatpicture(file, "images"),
					userdata.getBrief(),
					userdata.getGender().toString()
					, userdata.getQq(), 
					simpleDateFormat.format(userdata.getBirthday()),
					userdata.getUserId());}
				session.setAttribute("user", user);
				session.setAttribute("userData", userdata);
				return "success";
			} 
		}
	

	@RequestMapping("/SearchUser")
	public String SearchUser(String userName, HttpSession session, Model model)
			throws Exception {
		List list = userService.getUserByName(userName);
		model.addAttribute("UserList", list);
		return "/back/userResult";

	}

	@RequestMapping("/LogOut")
	public String LogOut(HttpSession session, Model model) throws Exception {

		session.removeAttribute("user");
		return "/login";

	}
	
	@RequestMapping("/editUserData")
	public String editUserData(String brief,String gender,String qq,String birthday,
			HttpSession session, Model model) throws Exception {
		User user=(User) session.getAttribute("user");
		String userId=user.getUserId();
		//调用Dao
		int result=userdataService.AlterUserData("",brief, gender, qq, birthday, userId);
		if(result>0) {
			//成功
			return "forward:ListUserData.do";
		} else {
			//失败
			return "forward:ListUserData.do";
		}
		
	}

	@RequestMapping("/ListUserData")
	public String ListUserData(String userName, HttpSession session, Model model)
			throws Exception {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			// 未登录
			return "/login";
		} else {
			// 已登录拿取userdata
			Userdata userData = userdataService.GetUserData(user.getUserId());
			// 拿取个人上传的视频
			List<Video> list = videoService.GetVideoByuid(user.getUserId());
			// 转发
			model.addAttribute("PersonalVList", list);
			model.addAttribute("userData", userData);
			return "/user";
		}

	}

}
