package com.hungteshun.shop.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件工具类
 *
 */
public class MailUtils {
	public static final String HOST = "smtp.163.com";
	public static final String PROTOCOL = "smtp";
	public static final int PORT = 25;
	public static final String FROM = "13192344270@163.com";//发件人的email
	public static final String PWD = "?";//发件人密码
	private static Session getSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);//设置服务器地址
		props.put("mail.store.protocol" , PROTOCOL);//设置协议
		props.put("mail.smtp.port", PORT);//设置端口
		props.put("mail.smtp.auth" , "true");

		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PWD);
			}

		};
		Session session = Session.getDefaultInstance(props , authenticator);
		return session;
	}

	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	/*	public static void sendMail(String to,String code){
             * 1.获得一个Session对象.
             * 2.创建一个代表邮件的对象Message.
             * 3.发送邮件Transport
             *//*
	// 1.获得连接对象
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.qq.com");
	Session session = getSession();
	// 2.创建邮件对象:

	Message message = new MimeMessage(session);
	// 设置发件人:
		try {
			message.setFrom(new InternetAddress("739638270@qq.com"));
		*//**


	public static final String HOST = "smtp.163.com";
	// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("来自线上商城官方激活邮件");
			// 设置邮件正文:
			message.setContent("<h1>欢迎来到线上商城，请点击下面的链接完成激活操作!</h1><h3><a href='http://localhost:8888/shop/user_active.action?code="+code+"'>点击激活码 code="+code+"完成激活操作</a></h3>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}*/

	/**
	 *
	 * @param toEmail 要发送的email地址
	 * @param page 发送的html页面
	 * @param subject 邮件主题
	 */
	public static void send(String toEmail , String page, String subject) {
		Session session = getSession();
		//设置自定义发件人昵称
		String nick="";
		try {
			nick=javax.mail.internet.MimeUtility.encodeText("sdc");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			// Instantiate a message
			Message msg = new MimeMessage(session);
			//Set message attributes
			msg.setFrom(new InternetAddress(nick+" <"+FROM+">"));
			InternetAddress[] address = {new InternetAddress(toEmail)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(page , "text/html;charset=utf-8");

			//Send the message
			Transport.send(msg);
		}
		catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		send("739638270@qq.com","<h1>欢迎来到线上商城，请点击下面的链接完成激活操作!</h1><h3><a href='http://localhost:8888/shop/user_active.action?code=\"+code+\"'>点击激活码 code=\"+code+\"完成激活操作</a></h3>\", \"text/html;charset=UTF-8\"","欢迎使用");
	}
}
