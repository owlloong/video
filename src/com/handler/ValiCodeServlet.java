package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;

public class ValiCodeServlet extends BaseServlet {
	public void MakeCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 告诉客户端不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);

		ValidateCode vc = new ValidateCode(1100, 250, 4, 9);
		String code = vc.getCode();// 得到生成的字符
		HttpSession session = request.getSession();
		session.setAttribute("ValiCode", code);
		vc.write(response.getOutputStream());
	}
	public void CheckCode(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		String code=request.getParameter("code");
		//从session获取code
		HttpSession session = request.getSession();
		String correctCode=(String) session.getAttribute("ValiCode");
		if(correctCode.equalsIgnoreCase(code)) {
			//验证码正确
			out.write("correct");
		} else {
			out.write("incorrect");
		}
	}
}
