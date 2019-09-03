package util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zygh.yfb.wxy.service.RoadInfoService;
import zygh.yfb.wxy.vo.RoadInfo;

public class FindYanyun {
	
	@Autowired
	private RoadInfoService roadInfoService;

	public static void main(String[] args) {
		//myGet();
		//目标URL
		String url = "http://41.5.253.175:10033/Vehiclemanagement/?iw-apikey=123&iw-cmd=findAdress&controlIndexCode=controlUnit_413401";
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
			/*String responseBody = httpclient.execute(httpGet, responseHandler);
			System.out.println("返回结果： "+responseBody);*/
			String responseBody = httpclient.execute(httpGet, responseHandler);
			JSONObject jsonobj = JSONObject.fromObject(responseBody);
			String data = jsonobj.getString("data");
			JSONObject jsondata = JSONObject.fromObject(data);
			String entityList = jsondata.getString("entityList");
			JSONArray jsonentityList = JSONArray.fromObject(entityList);
			System.out.println("返回结果： "+jsonentityList);
			for (int i = 0; i < jsonentityList.size(); i++) {
				RoadInfo roadInfo = (RoadInfo) jsonentityList.get(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
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
