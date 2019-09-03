package util;

import net.sf.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class SpecialHp {

    /**
     * @Description: 以get方式请求网页 
     */
    public static Boolean myGet(String hphm){
        //目标URL
        //String url = "http://192.168.100.130:8080/GetBoolean?hphm=asd&hpzl=01";
        String url = "http://41.5.252.7:8082/policewhite/GetBoolean?hphm="+hphm;
        //String url = "http://192.168.100.137:8080/findWLByhphm.action?hphm="+hphm;
        //创建一个默认的HttpClient
        HttpClient httpclient = new DefaultHttpClient();
        try {
            //以get方式请求网页
            HttpGet httpGet = new HttpGet(url);
            //打印请求地址
            //System.out.println("executing request " + httpGet.getURI());
            //创建响应处理器处理服务器响应内容
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            //执行请求并获取结果
            String responseBody = httpclient.execute(httpGet, responseHandler);
            JSONObject jsonObject = JSONObject.fromObject(responseBody);
            //System.out.println(responseBody);
            boolean res = jsonObject.getBoolean("boolean");
            //System.out.println(res);
            return res;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally{
            // 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
            httpclient.getConnectionManager().shutdown();
        }
        return null;
    }


}
