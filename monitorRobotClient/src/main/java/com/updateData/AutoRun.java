package com.updateData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.http.HttpConnect;

//import org.apache.log4j.Logger;

public class AutoRun {
	//��־
//	 private static Logger logger = Logger.getLogger(AutoRun.class); 

	public static void main(String[] args) {
ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);// newһ����ʱ��
		
		// ��ʱ�������ݿ�
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				//������ʱ����
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				System.out.println("����������Զ�̷���������       " + df.format(new Date()));
				String url ="http://XXX/monitorRobotServicer/index.html?token=sgerewhgwrhjt564654";
				String result = HttpConnect.sendGet(url);
				System.out.println(result);
			}
		}, 0, 2 * 60 * 1000, TimeUnit.MILLISECONDS);// 0��ʾ�״�ִ��������ӳ�ʱ�䣬�ڶ�����ʾÿ��ִ������ļ��ʱ�䣬TimeUnit.MILLISECONDSִ�е�ʱ������ֵ��λ
		
		
	}

}
