package com.yc.bank.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jspsmart.upload.Request;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//直接响应字符串处理
	/**
	 * 
	 * @param response 响应处理对象
	 * @param outStr   响应的数据
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void respOutStr(HttpServletResponse response,String outStr) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println(outStr);
		out.flush();
		out.close();
	}

	protected String toJsonStr(Object obj){
	//	Gson gson=new Gson();
		//设置Gson转换时，日期的转换格式
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}
	
	//Class 为类，接口的类型，类似int为整型的类型
	//UserServlet.class的类型是class，类似1的类型是int
	//class为类的抽象
	protected <T> T getReqParam20bj(HttpServletRequest request, Class<T> clazz) {
			//1.取到要转换成的对象实例
			T t=null;
			try {
				 t=clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LogManager.getLogger().error("创建"+clazz.getName()+"实例对象失败！！！");
			}
			
			//2.取到所有的请求参数名
			Enumeration<String> paramNames=request.getParameterNames();
			while(paramNames.hasMoreElements()){
				String valName=paramNames.nextElement();
				String val=request.getParameter(valName);
		
				//3.根据请求参数名，通过反射取到对应的实体类中的方法对象
				String suff=String.format("et%c%s",
						Character.toUpperCase(valName.charAt(0)),valName.substring(1));
				Class<?> paramType;
				try {
					paramType = clazz.getMethod("g"+suff).getReturnType();//取到getXxx()方法的返回类型
					Method sm=clazz.getMethod("s"+suff, paramType);//取到setXxx的方法对象
					if(paramType.getName().intern()==int.class.getName().intern()||
							paramType.getName().intern()==Integer.class.getName().intern()){
						sm.invoke(t, Integer.parseInt(val));
					}else if(paramType.getName().intern()==double.class.getName().intern()||
							paramType.getName().intern()==Double.class.getName().intern()){
						sm.invoke(t, Double.parseDouble(val));
					}else{
						sm.invoke(t, val);//从中调用底层方法的对象   用于方法调用的参数 
					}
				} catch (NoSuchMethodException |SecurityException e) {
					LogManager.getLogger().warn("在"+clazz.getName()+"中没有对应"+e.getMessage()+"方法");
				}  catch (IllegalAccessException |IllegalArgumentException|InvocationTargetException e) {
					LogManager.getLogger().warn(e.getMessage()+"转换中有参数格式不正确，转换数据类型失败");
				} 
			}
			return t;
		}
	protected <T> T getReqParam20bj(Request request, Class<T> clazz) {
		//1.取到要转换成的对象实例
		T t=null;
		try {
			 t=clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LogManager.getLogger().error("创建"+clazz.getName()+"实例对象失败！！！");
		}
		
		//2.取到所有的请求参数名
		Enumeration<String> paramNames=request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String valName=paramNames.nextElement();
			String val=request.getParameter(valName);
	
			//3.根据请求参数名，通过反射取到对应的实体类中的方法对象
			String suff=String.format("et%c%s",
					Character.toUpperCase(valName.charAt(0)),valName.substring(1));
			Class<?> paramType;
			try {
				paramType = clazz.getMethod("g"+suff).getReturnType();//取到getXxx()方法的返回类型
				Method sm=clazz.getMethod("s"+suff, paramType);//取到setXxx的方法对象
				if(paramType.getName().intern()==int.class.getName().intern()||
						paramType.getName().intern()==Integer.class.getName().intern()){
					sm.invoke(t, Integer.parseInt(val));
				}else if(paramType.getName().intern()==double.class.getName().intern()||
						paramType.getName().intern()==Double.class.getName().intern()){
					sm.invoke(t, Double.parseDouble(val));
				}else{
					sm.invoke(t, val);//从中调用底层方法的对象   用于方法调用的参数 
				}
			} catch (NoSuchMethodException |SecurityException e) {
				LogManager.getLogger().warn("在"+clazz.getName()+"中没有对应"+e.getMessage()+"方法");
			}  catch (IllegalAccessException |IllegalArgumentException|InvocationTargetException e) {
				LogManager.getLogger().warn(e.getMessage()+"转换中有参数格式不正确，转换数据类型失败");
			} 
		}
		return t;
	}
}
