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
	//��־
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
		ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);// newһ����ʱ��
		
		// ��ʱ�������ݿ�
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				//������ʱ����
				
				counter++;
				System.out.println("counter:====="+counter);
				if(counter==5) {
					String data = "{\"first\":{\"value\":\"�칫�ҷ����������쳣\",\"color\":\"#173177\"},\"performance\":{\"value\":\"ʮ����������ʮ�������쳣\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"��\",\"color\":\"#173177\"}}";//���͵�΢����Ϣ
					try {
						SendWechatMsg.sendMsg(data);//���ͷɸ����
						String url = ""+URLEncoder.encode("�칫�ҷ�����","UTF-8") + "&desp=" + URLEncoder.encode("����10����","UTF-8");
						HttpConnect.sendGet(url);//���ͷ���΢��
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(counter==30) {
					String data = "{\"first\":{\"value\":\"�칫�ҷ����������쳣\",\"color\":\"#173177\"},\"performance\":{\"value\":\"�����쳣һСʱ\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"��\",\"color\":\"#173177\"}}";//���͵�΢����Ϣ
					try {
						SendWechatMsg.sendMsg(data);
						String url = ""+URLEncoder.encode("�칫�ҷ�����","UTF-8") + "&desp=" + URLEncoder.encode("�������1Сʱ","UTF-8");
						HttpConnect.sendGet(url);//���ͷ���΢��
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(counter==90) {
					String data = "{\"first\":{\"value\":\"�칫�ҷ����������쳣\",\"color\":\"#173177\"},\"performance\":{\"value\":\"�����쳣��Сʱ\",\"color\":\"#173177\"},\"time\":{\"value\":\"now\",\"color\":\"#173177\"},\"remark\":{\"value\":\"��\",\"color\":\"#173177\"}}";//���͵�΢����Ϣ
					try {
						SendWechatMsg.sendMsg(data);
						String url = ""+URLEncoder.encode("�칫�ҷ�����","UTF-8") + "&desp=" + URLEncoder.encode("���������Сʱ","UTF-8");
						HttpConnect.sendGet(url);//���ͷ���΢��
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, 0, 2 * 60 * 1000, TimeUnit.MILLISECONDS);// 0��ʾ�״�ִ��������ӳ�ʱ�䣬�ڶ�����ʾÿ��ִ������ļ��ʱ�䣬TimeUnit.MILLISECONDSִ�е�ʱ������ֵ��λ
	
	}
	
	

}
