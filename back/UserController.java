package com.gd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gd.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	// @RequestMapping(method = RequestMethod.GET)
	// public String ControlUser(@RequestParam("name")String
	// name,@RequestParam("password")String password){
	// System.out.println(name);
	// System.out.println(password);
	// Subject subject = SecurityUtils.getSubject();
	// UsernamePasswordToken token = new UsernamePasswordToken(name,password);
	//
	// subject.login(token);
	// return "success";
	// }
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void userLogin(String __VIEWSTATE,String __VIEWSTATEGENERATOR, String pcInfo,
			String typeName, String dsdsdsdsdxcxdfgfg,
			String fgfggfdgtyuuyyuuckjg, String txt_asmcdefsddsd,
			String txt_pewerwedsdfsdff, String txt_sdertfgsadscxcadsads,
			String sbtState) {
		DefaultHttpClient client = new DefaultHttpClient();
		String url = "http://10.64.6.5/_data/index_LOGIN.aspx";
		HttpPost post = new HttpPost(url);
		List<Cookie> cookies; // 保存获取的cookie
		 post.setHeader("Accept",
		 "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 post.setHeader("Accept-Encoding", "gzip, deflate");
		 post.setHeader("Accept-Language",
		 "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		 post.setHeader("Referer", url);
		 post.setHeader("Connection", "keep-alive");
		// post.setHeader(
		// "Cookie",
		// "CNZZDATA1000049794=854649538-1415944709-http%253A%252F%252Fwww.baidu.com%252F%7C1415944709; ASP.NET_SessionId=qutyajqsupaof1uwaowvnm45");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair(
				"__VIEWSTATE",__VIEWSTATE));
		nvps.add(new BasicNameValuePair("__VIEWSTATEGENERATOR",
				__VIEWSTATEGENERATOR));
		nvps.add(new BasicNameValuePair("pcInfo", pcInfo));
		nvps.add(new BasicNameValuePair("typeName", typeName));
		nvps.add(new BasicNameValuePair("dsdsdsdsdxcxdfgfg", dsdsdsdsdxcxdfgfg));
		nvps.add(new BasicNameValuePair("fgfggfdgtyuuyyuuckjg",
				fgfggfdgtyuuyyuuckjg));
		nvps.add(new BasicNameValuePair("Sel_Type", "STU")); // 以学生身份登录
		nvps.add(new BasicNameValuePair("txt_asmcdefsddsd", txt_asmcdefsddsd));
		nvps.add(new BasicNameValuePair("txt_pewerwedsdfsdff",
				txt_pewerwedsdfsdff));
		nvps.add(new BasicNameValuePair("txt_sdertfgsadscxcadsads",
				txt_sdertfgsadscxcadsads));
		nvps.add(new BasicNameValuePair("sbtState", sbtState));
		
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			System.out.println("----------------------");
			System.out.println(EntityUtils.toString(entity));
			if (response.getStatusLine().getStatusCode() == 200) { // 返回值正常
				// 获取返回的cookie
				cookies = ((AbstractHttpClient) client).getCookieStore()
						.getCookies();

				HttpPost httppost2 = new HttpPost(
						"http://10.64.6.5/MyWeb/M_Log_Rpt.aspx");
				httppost2.setHeader(new BasicHeader("Cookie",
						"ASP.NET_SessionId=" + cookies.get(0).getValue()));
				httppost2.setHeader(new BasicHeader("Referer",
						"http://10.64.6.5/MyWeb/M_Log_Rpt.aspx"));
				System.out.println("ASP.NET_SessionId="
						+ cookies.get(0).getValue());
				List<NameValuePair> nvps2 = new ArrayList<NameValuePair>();
				nvps2.add(new BasicNameValuePair("sel_type", "1"));
				nvps2.add(new BasicNameValuePair("txtIPAddr", ""));
				nvps2.add(new BasicNameValuePair("txtTimeBeg", ""));
				nvps2.add(new BasicNameValuePair("txtTimeEnd", ""));
//				nvps2.add(new BasicNameValuePair(
//						"__VIEWSTATE",
//						"dDwtMTMwOTYyOTQ5Mjt0PDtsPGk8MD47aTwxPjtpPDI+Oz47bDx0PHA8bDxUZXh0Oz47bDzplb/mspnnkIblt6XlpKflraY7Pj47Oz47dDxwPGw8VGV4dDs+O2w8XDxzY3JpcHQgdHlwZT0idGV4dC9qYXZhc2NyaXB0Ilw+Clw8IS0tCmZ1bmN0aW9uIENoa1ZhbHVlKCl7CiB2YXIgdlU9JCgnVUlEJykuaW5uZXJIVE1MXDsKIHZVPXZVLnN1YnN0cmluZygwLDEpK3ZVLnN1YnN0cmluZygyLDMpXDsKIHZhciB2Y0ZsYWcgPSAiWUVTIlw7IGlmICgkKCd0eHRfYXNtY2RlZnNkZHNkJykudmFsdWU9PScnKXsKIGFsZXJ0KCfpobvlvZXlhaUnK3ZVKyfvvIEnKVw7JCgndHh0X2FzbWNkZWZzZGRzZCcpLmZvY3VzKClcO3JldHVybiBmYWxzZVw7Cn0KIGVsc2UgaWYgKCQoJ3R4dF9wZXdlcndlZHNkZnNkZmYnKS52YWx1ZT09JycpewogYWxlcnQoJ+mhu+W9leWFpeWvhuegge+8gScpXDskKCd0eHRfcGV3ZXJ3ZWRzZGZzZGZmJykuZm9jdXMoKVw7cmV0dXJuIGZhbHNlXDsKfQogZWxzZSBpZiAoJCgndHh0X3NkZXJ0ZmdzYWRzY3hjYWRzYWRzJykudmFsdWU9PScnICYmIHZjRmxhZyA9PSAiWUVTIil7CiBhbGVydCgn6aG75b2V5YWl6aqM6K+B56CB77yBJylcOyQoJ3R4dF9zZGVydGZnc2Fkc2N4Y2Fkc2FkcycpLmZvY3VzKClcO3JldHVybiBmYWxzZVw7Cn0KIGVsc2UgeyAkKCdkaXZMb2dOb3RlJykuaW5uZXJIVE1MPSdcPGZvbnQgY29sb3I9InJlZCJcPuato+WcqOmAmui/h+i6q+S7vemqjOivgS4uLuivt+eojeWAmSFcPC9mb250XD4nXDsKIHJldHVybiB0cnVlXDt9Cn0KZnVuY3Rpb24gU2VsVHlwZShvYmopewogdmFyIHM9b2JqLm9wdGlvbnNbb2JqLnNlbGVjdGVkSW5kZXhdLmdldEF0dHJpYnV0ZSgndXNySUQnKVw7CiB2YXIgdz1vYmoub3B0aW9uc1tvYmouc2VsZWN0ZWRJbmRleF0uZ2V0QXR0cmlidXRlKCdQd2RJRCcpXDsKICQoJ1VJRCcpLmlubmVySFRNTD1zXDsKIHNlbFR5ZU5hbWUoKVw7Cn0KZnVuY3Rpb24gb3BlbldpbkxvZyh0aGVVUkwsdyxoKXsKdmFyIFRmb3JtLHJldFN0clw7CmV2YWwoIlRmb3JtPSd3aWR0aD0iK3crIixoZWlnaHQ9IitoKyIsc2Nyb2xsYmFycz1ubyxyZXNpemFibGU9bm8nIilcOwpwb3A9d2luZG93Lm9wZW4odGhlVVJMLCd3aW5LUFQnLFRmb3JtKVw7IC8vcG9wLm1vdmVUbygwLDc1KVw7CmV2YWwoIlRmb3JtPSdkaWFsb2dXaWR0aDoiK3crInB4XDtkaWFsb2dIZWlnaHQ6IitoKyJweFw7c3RhdHVzOm5vXDtzY3JvbGxiYXJzPW5vXDtoZWxwOm5vJyIpXDsKcG9wLm1vdmVUbygoc2NyZWVuLndpZHRoLXcpLzIsKHNjcmVlbi5oZWlnaHQtaCkvMilcO2lmKHR5cGVvZihyZXRTdHIpIT0ndW5kZWZpbmVkJykgYWxlcnQocmV0U3RyKVw7Cn0KZnVuY3Rpb24gc2hvd0xheShkaXZJZCl7CnZhciBvYmpEaXYgPSBldmFsKGRpdklkKVw7CmlmIChvYmpEaXYuc3R5bGUuZGlzcGxheT09Im5vbmUiKQp7b2JqRGl2LnN0eWxlLmRpc3BsYXk9IiJcO30KZWxzZXtvYmpEaXYuc3R5bGUuZGlzcGxheT0ibm9uZSJcO30KfQpmdW5jdGlvbiBzZWxUeWVOYW1lKCl7CiAgJCgndHlwZU5hbWUnKS52YWx1ZT0kTignU2VsX1R5cGUnKVswXS5vcHRpb25zWyROKCdTZWxfVHlwZScpWzBdLnNlbGVjdGVkSW5kZXhdLnRleHRcOwp9CndpbmRvdy5vbmxvYWQ9ZnVuY3Rpb24oKXsKCXZhciBzUEM9TVNJRT93aW5kb3cubmF2aWdhdG9yLnVzZXJBZ2VudCt3aW5kb3cubmF2aWdhdG9yLmNwdUNsYXNzK3dpbmRvdy5uYXZpZ2F0b3IuYXBwTWlub3JWZXJzaW9uKycgU046TlVMTCc6d2luZG93Lm5hdmlnYXRvci51c2VyQWdlbnQrd2luZG93Lm5hdmlnYXRvci5vc2NwdSt3aW5kb3cubmF2aWdhdG9yLmFwcFZlcnNpb24rJyBTTjpOVUxMJ1w7CnRyeXskKCdwY0luZm8nKS52YWx1ZT1zUENcO31jYXRjaChlcnIpe30KdHJ5eyQoJ3R4dF9hc21jZGVmc2Rkc2QnKS5mb2N1cygpXDt9Y2F0Y2goZXJyKXt9CnRyeXskKCd0eXBlTmFtZScpLnZhbHVlPSROKCdTZWxfVHlwZScpWzBdLm9wdGlvbnNbJE4oJ1NlbF9UeXBlJylbMF0uc2VsZWN0ZWRJbmRleF0udGV4dFw7fWNhdGNoKGVycil7fQp9CmZ1bmN0aW9uIG9wZW5XaW5EaWFsb2codXJsLHNjcix3LGgpCnsKdmFyIFRmb3JtXDsKZXZhbCgiVGZvcm09J2RpYWxvZ1dpZHRoOiIrdysicHhcO2RpYWxvZ0hlaWdodDoiK2grInB4XDtzdGF0dXM6IitzY3IrIlw7c2Nyb2xsYmFycz1ub1w7aGVscDpubyciKVw7CndpbmRvdy5zaG93TW9kYWxEaWFsb2codXJsLDEsVGZvcm0pXDsKfQpmdW5jdGlvbiBvcGVuV2luKHRoZVVSTCl7CnZhciBUZm9ybSx3LGhcOwp0cnl7Cgl3PXdpbmRvdy5zY3JlZW4ud2lkdGgtMTBcOwp9Y2F0Y2goZSl7fQp0cnl7Cmg9d2luZG93LnNjcmVlbi5oZWlnaHQtMzBcOwp9Y2F0Y2goZSl7fQp0cnl7ZXZhbCgiVGZvcm09J3dpZHRoPSIrdysiLGhlaWdodD0iK2grIixzY3JvbGxiYXJzPW5vLHN0YXR1cz1ubyxyZXNpemFibGU9eWVzJyIpXDsKcG9wPXBhcmVudC53aW5kb3cub3Blbih0aGVVUkwsJycsVGZvcm0pXDsKcG9wLm1vdmVUbygwLDApXDsKcGFyZW50Lm9wZW5lcj1udWxsXDsKcGFyZW50LmNsb3NlKClcO31jYXRjaChlKXt9Cn0KZnVuY3Rpb24gY2hhbmdlVmFsaWRhdGVDb2RlKE9iail7CnZhciBkdCA9IG5ldyBEYXRlKClcOwpPYmouc3JjPSIuLi9zeXMvVmFsaWRhdGVDb2RlLmFzcHg/dD0iK2R0LmdldE1pbGxpc2Vjb25kcygpXDsKfQpmdW5jdGlvbiBjaGtwd2Qob2JqKSB7ICBpZihvYmoudmFsdWUhPScnKSAgeyAgICB2YXIgcz1tZDUoZG9jdW1lbnQuYWxsLnR4dF9hc21jZGVmc2Rkc2QudmFsdWUrbWQ1KG9iai52YWx1ZSkuc3Vic3RyaW5nKDAsMzApLnRvVXBwZXJDYXNlKCkrJzEwNTM2Jykuc3Vic3RyaW5nKDAsMzApLnRvVXBwZXJDYXNlKClcOyAgIGRvY3VtZW50LmFsbC5kc2RzZHNkc2R4Y3hkZmdmZy52YWx1ZT1zXDt9IGVsc2UgeyBkb2N1bWVudC5hbGwuZHNkc2RzZHNkeGN4ZGZnZmcudmFsdWU9b2JqLnZhbHVlXDt9IH0gIGZ1bmN0aW9uIGNoa3l6bShvYmopIHsgIGlmKG9iai52YWx1ZSE9JycpIHsgICB2YXIgcz1tZDUobWQ1KG9iai52YWx1ZS50b1VwcGVyQ2FzZSgpKS5zdWJzdHJpbmcoMCwzMCkudG9VcHBlckNhc2UoKSsnMTA1MzYnKS5zdWJzdHJpbmcoMCwzMCkudG9VcHBlckNhc2UoKVw7ICAgZG9jdW1lbnQuYWxsLmZnZmdnZmRndHl1dXl5dXVja2pnLnZhbHVlPXNcO30gZWxzZSB7ICAgIGRvY3VtZW50LmFsbC5mZ2ZnZ2ZkZ3R5dXV5eXV1Y2tqZy52YWx1ZT1vYmoudmFsdWUudG9VcHBlckNhc2UoKVw7fX0vLy0tXD4KXDwvc2NyaXB0XD47Pj47Oz47dDw7bDxpPDE+Oz47bDx0PDtsPGk8MD47PjtsPHQ8cDxsPFRleHQ7PjtsPFw8b3B0aW9uIHZhbHVlPSdTVFUnIHVzcklEPSflrabjgIDlj7cnXD7lrabnlJ9cPC9vcHRpb25cPgpcPG9wdGlvbiB2YWx1ZT0nVEVBJyB1c3JJRD0n5bel44CA5Y+3J1w+5pWZ5biI5pWZ6L6F5Lq65ZGYXDwvb3B0aW9uXD4KXDxvcHRpb24gdmFsdWU9J1NZUycgdXNySUQ9J+W4kOOAgOWPtydcPueuoeeQhuS6uuWRmFw8L29wdGlvblw+Clw8b3B0aW9uIHZhbHVlPSdBRE0nIHVzcklEPSfluJDjgIDlj7cnXD7pl6jmiLfnu7TmiqTlkZhcPC9vcHRpb25cPgo7Pj47Oz47Pj47Pj47Pj47Ppd1QJsmvBWx/h2Ga3g2PFe/MZ9f"));
				httppost2
						.setEntity(new UrlEncodedFormEntity(nvps2, HTTP.UTF_8));
				// 如果httpclient中已经有cookie可能需要设置httpclient的cookie策略，具体可查官方API
				HttpResponse getresponse2 = new DefaultHttpClient()
						.execute(httppost2);
				System.out.println(response.getStatusLine());
				HttpEntity getentity = getresponse2.getEntity();
				System.out.println("******************************");
				String body = EntityUtils.toString(getentity);
				System.out.println(body);
				// userService.registUser(userLogin);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		post.abort();// 释放连接资源
		client.getConnectionManager().shutdown();// 关闭连接管理器
	}
}