package com.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
 
/**
 * ���ͷɸ����
 *
 */
public class SendWechatMsg {
    public static void sendMsg(String data) throws Exception {
        // ����һ��httpclient����
        CloseableHttpClient client = HttpClients.createDefault();
        // ����һ��post����
        HttpPost post = new HttpPost("https://u.ifeige.cn/api/message/send");
        // ����һ��Entity��ģ�������
        List<NameValuePair> formList = new ArrayList<NameValuePair>();
        // ��ӱ�����  
        formList.add(new BasicNameValuePair("secret", ""));
        formList.add(new BasicNameValuePair("app_key", ""));
        formList.add(new BasicNameValuePair("template_id", ""));
        formList.add(new BasicNameValuePair("data", data));
        
        // ��װ��һ��Entity����
        StringEntity entity = new UrlEncodedFormEntity(formList, "utf-8");
        // �������������
        post.setEntity(entity);
        // ��������ı���ͷ���ı���
        // post.setHeader(new BasicHeader("Content-Type",
        // "application/x-www-form-urlencoded; charset=utf-8"));
        // ������������˷��صı���
        // post.setHeader(new BasicHeader("Accept",
        // "text/plain;charset=utf-8"));
        // ִ��post����
        CloseableHttpResponse response = client.execute(post);
        // ��ȡ��Ӧ��
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            // ��ȡ����
            String resStr = EntityUtils.toString(response.getEntity());
            // ���
            System.out.println(resStr);
        } else {
            // ���
            System.out.println(statusCode);
        }
    }
    
}

