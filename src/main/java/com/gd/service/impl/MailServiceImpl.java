package com.gd.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gd.dto.MailType;
import com.gd.service.MailService;

import freemarker.template.Template;
/**
 * @author phn
 * TODO 发送邮件
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
	private final String MAIL_FROM_ADDRESS = "";
	private final String MAIL_ACTIVE_TEMPLATE = "active";
	private final String MAIL_FIND_PASS_TEMPLATE = "findpass";
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer; // FreeMarker的技术类

	/**
	 * TODO 发送单个邮件
	 * @param MailTye 
	 */
	@Override
	public void sendSingleMail(MailType mailType) {
		MimeMessage msg = mailSender.createMimeMessage();
		String MAIL_CLICK_URL = mailType.getUrl();
		try {
			// 设置utf-8或GBK编码，否则邮件会有乱码，true表示为multipart邮件
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			// 邮件接收地址
			helper.setTo(mailType.getEmail());
			// 邮件发送地址,这里必须和xml里的邮件地址相同一致
			String nick = "";
			try {
				nick = javax.mail.internet.MimeUtility.encodeText("果动应用开发平台");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			helper.setFrom(new InternetAddress(nick + " <" + MAIL_FROM_ADDRESS + ">")); // 邮件发送地址,这里必须和xml里的邮件地址相同一致
			String mailContent = "";
			if (mailType.getType() == MailType.REGISTER_TYPE_MAIL) {
				// 添加主题
				helper.setSubject("你好，恭喜你注册成功");
				mailContent = getMailContent(mailType.getUsername(),
						MAIL_ACTIVE_TEMPLATE, MAIL_CLICK_URL);
			}else if(mailType.getType() == MailType.RESET_PASSWORD_TYPE_MAIL){
				// 添加主题
				helper.setSubject("果动应用账号找回密码");
				mailContent = getMailContent(mailType.getUsername(),
						MAIL_FIND_PASS_TEMPLATE, MAIL_CLICK_URL);
			}
			// 邮件内容，注意加参数true，表示启用html格式
			helper.setText(mailContent, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 发送邮件
		mailSender.send(msg);
	}

	// 通过模板构造邮件内容，参数content将替换模板文件中的${content}标签。
	private String getMailContent(String UserName, String MailTypeName,
			String MailClickUrl) throws Exception {
		String htmlText = "";
		// 通过指定模板名获取FreeMarker模板实例
		Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(
				MailTypeName);
		Map<String, Object> map = new HashMap<String, Object>(); // FreeMarker通过Map传递动态数据
		map.put("USERNAME", UserName); // 注意动态数据的key和模板标签中指定的属性相匹配
		map.put("MAILCLICKURL", MailClickUrl);
		// 解析模板并替换动态数据，最终USERNAME将替换模板文件中的${USERNAME}标签。
		htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
//		System.out.println(htmlText);
		return htmlText;
	}

}
