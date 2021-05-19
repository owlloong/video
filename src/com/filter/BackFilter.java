package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.po.User;



/**
 * Servlet Filter implementation class BackFilter
 */
@WebFilter("/BackFilter")
public class BackFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public BackFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.将请求和响应转换成真实的类型：HTTP
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 2.获得session对象
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			// 未登录，跳回登录界面
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		} else {
			User user = (User) session.getAttribute("user");
			int roleId=Integer.parseInt(user.getRoleId());
			// 3.判断是否登录
			if (roleId!=1) {
				// 非管理员
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			} else {
				// 已登录，将资源向下传递
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
