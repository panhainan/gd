package com.gd.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd.dao.IUserDao;
import com.gd.entity.UserLogin;
import com.gd.service.IUserService;

@Component
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	private static final String LOGON_SITE = "http://www.csust.edu.cn"; //登录服务器域名
	private static final int LOGON_PORT =8081; //登录服务器端口
	static String userName="",userID="",dayID[]={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"},bucketID="";
	String responseString = "";//响应内容
	boolean flag;
	byte[] bytes;
	@Override
	public void registUser(UserLogin userLogin) {
		HttpClient client = new HttpClient(); 
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT); 
		//登录页面 
		//设置http头 
		List<Header> headers = new ArrayList<Header>(); 
		headers.add(new Header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)")); 
		headers.add(new Header("Refere", "http://www.csust.edu.cn:8081/_data/index_LOGIN.aspx")); 
		client.getHostConfiguration().getParams().setParameter("http.default-headers", headers); 
		PostMethod post = new PostMethod("http://www.csust.edu.cn:8081/_data/index_LOGIN.aspx"); 
		NameValuePair username= new NameValuePair("txt_asmcdefsddsd",userLogin.getTxt_asmcdefsddsd()); //根据学生在MyScse登录界面系统输入的登录信息构造明值对
		NameValuePair password = new NameValuePair("txt_pewerwedsdfsdff", userLogin.getTxt_pewerwedsdfsdff());
		NameValuePair yanzhengma = new NameValuePair("txt_sdertfgsadscxcadsads", userLogin.getTxt_sdertfgsadscxcadsads());
		post.setRequestBody(new NameValuePair[] {username,password,yanzhengma}); //根据明值对构造对MyScse系统的请求内容
		try {
			int status=client.executeMethod(post);
			System.out.println(status);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Cookie[] cookies = client.getState().getCookies(); 
		client.getState().addCookies(cookies); 
		post.releaseConnection(); 
		String newUrl="http://www.csust.edu.cn:8081/_data/index_LOGIN.aspx"; 
		client.getState().addCookies(cookies); 
		post.releaseConnection(); 
		GetMethod get = new GetMethod(newUrl); 
		get.setRequestHeader("Cookie", cookies.toString()); 
		try {
			client.executeMethod(get);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		get.releaseConnection(); 
	}
}
