package com.yc.bank.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
@WebServlet("/login/*")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = -3015154294142033804L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlName=req.getRequestURI();
		System.out.println(urlName);
		LogManager.getLogger().debug("UserServlet===>"+urlName+"请求");
		if(urlName.endsWith("do")){
			doLogin(req,resp);
		}
	}
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name=req.getParameter("username");
		String pwd=req.getParameter("password");
		System.out.println(name+pwd);
		resp.sendRedirect("admin.jsp");
	}
}
