package util;

import java.util.ArrayList;  
import java.util.List;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.ResponseHandler;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.BasicResponseHandler;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.message.BasicNameValuePair;

public class httpclient {

	/*public static void main(String[] args) {
		myGet();
		myPost();
	}*/
	
	/**
	 * 以post方式请求网页
	 */
	public static void myPost(){
		
		//目标URL
		String url = "http://192.168.40.128:8080/wxy/say";
		//创建一个默认的HttpClient
		HttpClient httpclient = new DefaultHttpClient();
		try {
			//以post方式请求网页
			HttpPost httpPost = new HttpPost(url);
			//添加HTTP POST参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", "cz"));
			nvps.add(new BasicNameValuePair("password", "123"));
			//将POST参数以UTF-8编码并包装成表单实体对象
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			//打印请求地址
			System.out.println("executing request " + httpPost.getRequestLine().getUri());
			//创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			//执行请求并获取结果
			String responseBody = httpclient.execute(httpPost, responseHandler);
			System.out.println(responseBody);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	/**
	 * @Description: 以get方式请求网页 
	 */
	public static void myGet(String sbbh, String hpzl, String hphm, String wfxw, String imgurl){
		//目标URL
		String url = "http://192.168.40.128:8080/wxy/say?"+sbbh+"&"+hpzl+"&"+hphm+"&"+wfxw+"&"+wfxw;
		//创建一个默认的HttpClient
		HttpClient httpclient = new DefaultHttpClient();
		try {
			//以get方式请求网页
			HttpGet httpGet = new HttpGet(url);
			//打印请求地址
			System.out.println("executing request " + httpGet.getURI());
			//创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			//执行请求并获取结果
			String responseBody = httpclient.execute(httpGet, responseHandler);
			System.out.println(responseBody);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			// 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
			httpclient.getConnectionManager().shutdown();
		}
	}
}
