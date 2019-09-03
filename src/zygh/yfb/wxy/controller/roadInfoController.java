package zygh.yfb.wxy.controller;

import image.DownImageyy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.httpclient;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.RoadInfoService;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.IntervalVMExample;
import zygh.yfb.wxy.vo.RoadInfo;

@Controller
public class roadInfoController {
	
	@Autowired
	private RoadInfoService roadInfoService;

	@Autowired
	private IntervalVMService intervalVMService;

	@RequestMapping("/lalalalalaa")
	public void lalalalalaa(IntervalVM intervalVM, HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<IntervalVMExample> intervalVMList = intervalVMService.findIntervalVM(null);
			for (int i = 0; i < intervalVMList.size(); i++) {
				String url = intervalVMList.get(i).getURL1();
				String cph = intervalVMList.get(i).getHPHM();
				String wfdd = intervalVMList.get(i).getCJDZ();
				String sbbh = intervalVMList.get(i).getSBBH();
				try {
					DownImageyy.download(url, cph, wfdd, sbbh);
				}catch (Exception r){
					r.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="查询失败";
			response.getWriter().print(msg);
		}
	}
	
	//http://41.5.253.175:10033/Vehiclemanagement/?iw-apikey=123&iw-cmd=find1&state=-1&wfxw=-2&start=1&starttime=2018-10-19，00:00:00&endtime=2018-10-19，13:22:31
	@RequestMapping("/finddata")
	public void finddata(HttpServletResponse response)throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		
		List<RoadInfo> roadInfo = roadInfoService.findRoadInfo(null);
		for (int i = 0; i < roadInfo.size(); i++) {
			String idd = roadInfo.get(i).getId();
			String url = "http://41.5.253.175:10033/Vehiclemanagement/?iw-apikey=123&iw-cmd=find1&state=-1&wfxw=1345&start=1&starttime=2018-12-01,11:00:00&endtime=2018-12-01,17:22:31&address="+idd;
			HttpClient httpclient = new DefaultHttpClient();
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
			JSONObject data = jsonobj.getJSONObject("data");
			JSONArray jsoninformationList = data.getJSONArray("informationList");
			for (int j = 0; j < jsoninformationList.size(); j++) {
				JSONObject jsonoo = (JSONObject) jsoninformationList.get(j);
				String hphm = jsonoo.getString("Hphm");
				String wfdd = jsonoo.getString("Wfdd");
				String url1 = jsonoo.getString("Wftp");
				System.out.println("违法地址："+wfdd);
				String sbbh = "";
				try {
					sbbh = roadInfoService.findsbbhbylukou(wfdd);
					System.out.println("sbbh"+sbbh);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					DownImageyy.download(url1, hphm, wfdd, sbbh);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				
			}
			
		}
		String msg = "";
		msg="完成";
		response.getWriter().print(msg);
	}

	@RequestMapping("/main")
	public void main(String id, HttpServletResponse response) throws IOException {
		//myGet();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		//目标URL
		String url = "http://41.5.253.175:10033/Vehiclemanagement/?iw-apikey=123&iw-cmd=findAdress&controlIndexCode="+id;
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
			/*String data = jsonobj.getString("data");
			JSONObject jsondata = JSONObject.fromObject(data);
			String entityList = jsondata.getString("entityList");
			JSONArray jsonentityList = JSONArray.fromObject(entityList);
			System.out.println("返回结果： "+jsonentityList);*/
			JSONObject data = jsonobj.getJSONObject("data");
			JSONArray jsonentityList = data.getJSONArray("entityList");
			System.out.println("啥玩意： "+ jsonentityList);
			for (int i = 0; i < jsonentityList.size(); i++) {
				JSONObject jsonone = (JSONObject) jsonentityList.get(i);
				RoadInfo roadInfo= (RoadInfo)JSONObject.toBean(jsonone, RoadInfo.class);
				//RoadInfo roadInfo = (RoadInfo) jsonentityList.get(i);
				try {
					roadInfoService.addRoadInfo(roadInfo);
				} catch (Exception e) {
					System.out.println("此条失败");
				}
			}
			System.out.println("长度： "+ jsonentityList.size());
			String msg = "";
			msg="成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
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
