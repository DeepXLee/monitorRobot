package com.updateData;

import java.net.URLEncoder;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.http.HttpConnect;
import com.http.SendWechatMsg;

//import org.apache.log4j.Logger;

public class AutoRun implements ServletContextListener{
	//日志
//	 private static Logger logger = Logger.getLogger(AutoRun.class); 

	static int counter = 0;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void reset() {
		counter = 0;
	}
	
	public static int counter() {
		return counter;
	}
	
	public void contextInitialized(ServletContextEvent arg0) {
		
		// TODO Auto-generated method stub
		ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);// new一个定时器
		
		// 定时更新数据库
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				//开启定时任务
				
				counter++;
				System.out.println("counter:====="+counter);
				if(counter==5) {
					String data = "{\"first\":{\"value\":\"办公室服务器连接异常\",\"color\":\"#173177\"},\"performance\":{\"value\":\"十分钟内连续十次连接异常\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"无\",\"color\":\"#173177\"}}";//发送的微信信息
					try {
						SendWechatMsg.sendMsg(data);//发送飞鸽快信
						String url = ""+URLEncoder.encode("办公室服务器","UTF-8") + "&desp=" + URLEncoder.encode("错误10分钟","UTF-8");
						HttpConnect.sendGet(url);//发送方糖微信
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(counter==30) {
					String data = "{\"first\":{\"value\":\"办公室服务器连接异常\",\"color\":\"#173177\"},\"performance\":{\"value\":\"持续异常一小时\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"无\",\"color\":\"#173177\"}}";//发送的微信信息
					try {
						SendWechatMsg.sendMsg(data);
						String url = ""+URLEncoder.encode("办公室服务器","UTF-8") + "&desp=" + URLEncoder.encode("错误持续1小时","UTF-8");
						HttpConnect.sendGet(url);//发送方糖微信
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(counter==90) {
					String data = "{\"first\":{\"value\":\"办公室服务器连接异常\",\"color\":\"#173177\"},\"performance\":{\"value\":\"持续异常三小时\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"无\",\"color\":\"#173177\"}}";//发送的微信信息
					try {
						SendWechatMsg.sendMsg(data);
						String url = ""+URLEncoder.encode("办公室服务器","UTF-8") + "&desp=" + URLEncoder.encode("错误持续三小时","UTF-8");
						HttpConnect.sendGet(url);//发送方糖微信
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, 0, 2 * 60 * 1000, TimeUnit.MILLISECONDS);// 0表示首次执行任务的延迟时间，第二个表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
	
	}
	
	

}
